import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';

interface Voter {
  id: number;
  firstName: string;
  lastName: string;
  dateOfBirth: string;
  hasVoted: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  voters: Voter[] = [];
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadVoters();
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
    this.http.post(`${this.apiUrl}/voters/${voterId}/vote`, {}).subscribe({
      next: () => {
        this.loadVoters();
      },
      error: (error) => {
        console.error('Error voting:', error);
      }
    });
  }
}
