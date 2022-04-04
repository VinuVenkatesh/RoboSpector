import { TestBed } from '@angular/core/testing';

import { EquipmentSingleViewService } from './equipment-single-view.service';

describe('EquipmentSingleViewService', () => {
  let service: EquipmentSingleViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EquipmentSingleViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
