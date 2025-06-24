import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VoterListComponent } from './voter-list.component';
import { VoterService } from '../../services/voter.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Voter } from '../../models/voter.model';

describe('VoterListComponent', () => {
  let component: VoterListComponent;
  let fixture: ComponentFixture<VoterListComponent>;
  let voterService: VoterService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoterListComponent ],
      imports: [ HttpClientTestingModule ],
      providers: [ VoterService ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoterListComponent);
    component = fixture.componentInstance;
    voterService = TestBed.inject(VoterService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should load voters', () => {
    const mockVoters = [
      { id: 1, firstName: 'John', lastName: 'Doe', birthDate: '1985-01-01', hasVoted: false }
    ] as Voter[];
    spyOn(voterService, 'getVoters').and.returnValue(of(mockVoters));

    component.loadVoters();

    expect(voterService.getVoters).toHaveBeenCalled();
    expect(component.voters).toEqual(mockVoters);
  });

  it('should mark voter as voted', () => {
    const mockVoter = { id: 1, firstName: 'John', lastName: 'Doe', birthDate: '1985-01-01', hasVoted: false } as Voter;
    spyOn(voterService, 'vote').and.returnValue(of(mockVoter));

    component.vote(mockVoter);

    expect(voterService.vote).toHaveBeenCalledWith(1);
  });
});