import { Component, OnInit } from '@angular/core';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';

@Component({
  selector: 'app-location-view',
  templateUrl: './location-view.component.html',
  styleUrls: ['./location-view.component.css']
})
export class LocationViewComponent implements OnInit {

  lat? : string;
  long? : string;
  url? : string;
  constructor(private equipmentSingleViewService: EquipmentSingleViewService) { }

  ngOnInit(): void {
   
    this.equipmentSingleViewService.getSingleEquipment(3).subscribe(data => {
      this.lat = data.location?.latitude;
      this.long = data.location?.longitude;
      this.url = "https://api.mapbox.com/styles/v1/leigham/cl16y4cq6002s15qrih661fck.html?title=false&access_token=pk.eyJ1IjoibGVpZ2hhbSIsImEiOiJjbDE2eTB4enUwMDltM2lxcWVoMmIwZGczIn0.MYUBLCAOT7rs9oyGqhXeWA&zoomwheel=false#8.34/"+this.lat+"/" + this.long;
    })
  }
}
