import { Component, OnInit } from '@angular/core';
import { VoterService } from '../../services/voter.service';
import { Voter } from '../../models/voter.model';

@Component({
  selector: 'app-voter-list',
  templateUrl: './voter-list.component.html',
  styleUrls: ['./voter-list.component.css']
})
export class VoterListComponent implements OnInit {
  voters: Voter[] = [];
  loading = true;

  constructor(private voterService: VoterService) { }

  ngOnInit() {
    this.loadVoters();
  }

  loadVoters() {
    this.voterService.getVoters().subscribe({
      next: (voters) => {
        this.voters = voters;
        this.loading = false;
      },
      error: (error) => {
        console.error('Error loading voters:', error);
        this.loading = false;
      }
    });
  }

  vote(voter: Voter) {
    if (!voter.hasVoted) {
      this.voterService.vote(voter.id).subscribe({
        next: (updatedVoter) => {
          const index = this.voters.findIndex(v => v.id === updatedVoter.id);
          if (index !== -1) {
            this.voters[index] = updatedVoter;
          }
        },
        error: (error) => {
          console.error('Error voting:', error);
        }
      });
    }
  }
}
