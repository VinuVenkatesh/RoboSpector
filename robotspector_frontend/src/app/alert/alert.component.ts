import { animate, style, transition, trigger } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import { EquipmentService } from '../services/EquipmentService';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css'],
  animations: [
    trigger('fade', [
      transition('* => show', [ // using status here for transition
        style({ opacity: 0 }),
        animate(250, style({ opacity: 1 }))
      ]),
      transition('* => void', [
        animate(100, style({ opacity: 0 }))
      ])
    ])
  ]
})
export class AlertComponent implements OnInit {

  @Input()
  alertState:Boolean = false;

  @Input()
  currentRowId:any;
  @Input()
  currentEquipment:any;
  constructor(private dataSharing: DataService, private equipmentService:EquipmentService) {}

  ngOnInit(): void {
    this.dataSharing.currentAlertState.subscribe((data:any) =>{
      this.alertState = data;
    })
    this.dataSharing.currentSelectedRowData.subscribe((res:any) =>{
      this.currentRowId = res;
    })
    this.dataSharing.curentSelectedEquipment.subscribe((res:any)=>{
      this.currentEquipment = res;
    })
  }

  toggleAlertState(){
    this.dataSharing.changeCurrentAlertState(false);
  }

  onClickNo(){
    this.toggleAlertState();
  }
  onClickYes(){
    this.equipmentService.deleteEquipment(this.currentRowId).subscribe((data:any) =>{
      if (data != null){
        this.equipmentService.getAllEquipment().subscribe((data:any) =>{
          this.dataSharing.changeCurrentEquipmentList(data);
          this.toggleAlertState();
        })
      }
  });
    
  }
}
