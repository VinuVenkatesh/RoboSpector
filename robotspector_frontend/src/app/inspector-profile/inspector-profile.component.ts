import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';

@Component({
  selector: 'app-inspector-profile',
  templateUrl: './inspector-profile.component.html',
  styleUrls: ['./inspector-profile.component.css']
})
export class InspectorProfileComponent implements OnInit {

  engineerName?: string;
  engineerId?:string;
  constructor(private dataServiceService : DataService, private equipmentSingleViewService: EquipmentSingleViewService) { }

  ngOnInit(): void {
    this.dataServiceService.currentEquipmentId.subscribe((equipmentData:any) =>{
      this.equipmentSingleViewService.getMostRecentVerification(equipmentData).subscribe(data =>{
        this.engineerId = data.verificationDetails?.verifiedBy;
      })
  
    })
    
  }

}
