import { Component, OnInit } from '@angular/core';
import { MemberService } from '../../services/member.service';
import { Member } from '../../models/member.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.scss']
})
export class MemberListComponent implements OnInit {
  members$!: Observable<Member[]>;

  constructor(private memberService: MemberService) { }

  ngOnInit(): void {
    this.loadMembers();
  }

  private loadMembers(): void {
    this.members$ = this.memberService.getMembers();
  }

  onVote(memberId: number): void {
    this.memberService.vote(memberId).subscribe(() => {
      this.loadMembers();
    });
  }
}
