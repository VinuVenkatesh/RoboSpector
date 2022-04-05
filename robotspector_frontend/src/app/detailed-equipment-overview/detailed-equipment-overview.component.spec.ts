import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailedEquipmentOverviewComponent } from './detailed-equipment-overview.component';

describe('DetailedEquipmentOverviewComponent', () => {
  let component: DetailedEquipmentOverviewComponent;
  let fixture: ComponentFixture<DetailedEquipmentOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailedEquipmentOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailedEquipmentOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
