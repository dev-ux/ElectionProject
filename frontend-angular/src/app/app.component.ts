import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { MemberListComponent } from './components/member-list/member-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, MemberListComponent],
  template: `
    <app-member-list></app-member-list>
  `,
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'Voting Application';
}
