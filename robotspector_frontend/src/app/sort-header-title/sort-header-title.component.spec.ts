import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortHeaderTitleComponent } from './sort-header-title.component';

describe('SortHeaderTitleComponent', () => {
  let component: SortHeaderTitleComponent;
  let fixture: ComponentFixture<SortHeaderTitleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortHeaderTitleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortHeaderTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
