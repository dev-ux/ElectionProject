import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { Subject } from 'rxjs';

interface Voter {
  id: number;
  firstName: string;
  lastName: string;
  dateOfBirth: string;
  hasVoted: boolean;
}

@Component({
  selector: 'app-voters',
  templateUrl: './voters.component.html',
  styleUrls: ['./voters.component.css']
})
export class VotersComponent implements OnInit {
  voters: Voter[] = [];
  searchTerm = '';
  isVoting = false;
  private apiUrl = environment.apiUrl;
  private searchSubject = new Subject<string>();

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadVoters();
    
    // Setup search debouncing
    this.searchSubject.pipe(
      debounceTime(300),
      distinctUntilChanged()
    ).subscribe(() => {
      this.filterVoters();
    });
  }

  loadVoters() {
    this.http.get<Voter[]>(`${this.apiUrl}/voters`).subscribe({
      next: (data) => {
        this.voters = data;
      },
      error: (error) => {
        console.error('Error loading voters:', error);
      }
    });
  }

  vote(voterId: number) {
    if (this.isVoting) return;
    
    this.isVoting = true;
    this.http.post(`${this.apiUrl}/voters/${voterId}/vote`, {}).subscribe({
      next: () => {
        this.loadVoters();
      },
      error: (error) => {
        console.error('Error voting:', error);
      },
      complete: () => {
        this.isVoting = false;
      }
    });
  }

  filterVoters() {
    if (!this.searchTerm) {
      return this.voters;
    }
    const term = this.searchTerm.toLowerCase();
    return this.voters.filter(voter =>
      voter.firstName.toLowerCase().includes(term) ||
      voter.lastName.toLowerCase().includes(term)
    );
  }

  get filteredVoters() {
    return this.filterVoters();
  }

  get totalVoters() {
    return this.voters.length;
  }

  get votedCount() {
    return this.voters.filter(v => v.hasVoted).length;
  }

  get remainingCount() {
    return this.voters.filter(v => !v.hasVoted).length;
  }
}
