import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Voter } from '../models/voter.model';

@Injectable({
  providedIn: 'root'
})
export class VoterService {
  private apiUrl = 'http://localhost:8080/api/voters';

  constructor(private http: HttpClient) { }

  getVoters(): Observable<Voter[]> {
    return this.http.get<Voter[]>(this.apiUrl);
  }

  vote(voterId: number): Observable<Voter> {
    return this.http.post<Voter>(`${this.apiUrl}/${voterId}/vote`, {});
  }
}
