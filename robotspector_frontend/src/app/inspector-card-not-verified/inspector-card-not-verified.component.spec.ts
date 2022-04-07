import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InspectorCardNotVerifiedComponent } from './inspector-card-not-verified.component';

describe('InspectorCardNotVerifiedComponent', () => {
  let component: InspectorCardNotVerifiedComponent;
  let fixture: ComponentFixture<InspectorCardNotVerifiedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InspectorCardNotVerifiedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InspectorCardNotVerifiedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
