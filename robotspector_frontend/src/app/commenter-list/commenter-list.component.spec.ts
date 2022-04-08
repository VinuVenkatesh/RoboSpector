import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommenterListComponent } from './commenter-list.component';

describe('CommenterListComponent', () => {
  let component: CommenterListComponent;
  let fixture: ComponentFixture<CommenterListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommenterListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CommenterListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
