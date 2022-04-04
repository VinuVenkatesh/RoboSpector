import { Component, OnInit } from '@angular/core';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';

@Component({
  selector: 'app-location-view',
  templateUrl: './location-view.component.html',
  styleUrls: ['./location-view.component.css']
})
export class LocationViewComponent implements OnInit {

  constructor(private equipmentSingleViewService: EquipmentSingleViewService) { }

  ngOnInit(): void {
    this.equipmentSingleViewService.getSingleEquipment(3).subscribe(data => {
      console.log(data);
    })
  }

}
