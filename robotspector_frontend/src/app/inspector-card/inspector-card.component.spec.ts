import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InspectorCardComponent } from './inspector-card.component';

describe('InspectorCardComponent', () => {
  let component: InspectorCardComponent;
  let fixture: ComponentFixture<InspectorCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InspectorCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InspectorCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
