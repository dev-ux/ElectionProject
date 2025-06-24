import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { environment } from '../environments/environment';

describe('AppComponent', () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [AppComponent]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should load voters', () => {
    const httpMock = TestBed.inject(HttpClientTestingModule);
    spyOn(httpMock, 'get').and.returnValue({ subscribe: () => {} });
    component.loadVoters();
    expect(httpMock.get).toHaveBeenCalledWith(`${environment.apiUrl}/voters`);
  });

  it('should handle voting', () => {
    const httpMock = TestBed.inject(HttpClientTestingModule);
    spyOn(httpMock, 'post').and.returnValue({ subscribe: () => {} });
    component.vote(1);
    expect(httpMock.post).toHaveBeenCalledWith(`${environment.apiUrl}/voters/1/vote`, {});
  });
});
