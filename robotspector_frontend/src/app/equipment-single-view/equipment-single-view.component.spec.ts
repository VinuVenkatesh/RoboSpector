import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentSingleViewComponent } from './equipment-single-view.component';

describe('EquipmentSingleViewComponent', () => {
  let component: EquipmentSingleViewComponent;
  let fixture: ComponentFixture<EquipmentSingleViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EquipmentSingleViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipmentSingleViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
