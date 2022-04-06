import { Component, Input, OnInit } from '@angular/core';
import { Equipment } from '../equipment-single-view/equipment';
import { DataService } from '../services/data-service.service';
import {EquipmentService} from '../services/EquipmentService'
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  
  slider:any;
  isDown:any = false;
  startY:any;
  scrollTop:any;
  equipment?:[Equipment];
  searchText:string = "";
  @Input()
  sortColumnOrder = {column:"name",order:"dsc"};
  @Input()
  equipmentLength?:Number;
  constructor(private service:EquipmentService,private dataSharing: DataService) {}

  ngOnInit(): void {
    this.slider = document.querySelector('#table');
    this.service.getAllEquipment().subscribe((data:any) =>{
      if (data != null){
       this.equipment = data;
       this.equipmentLength = data.length;
       this.dataSharing.changeCurrentEquipmentLength(data.length);
       console.log("data from table", this.equipment);
      }
    })
    this.dataSharing.currentDashboardInputData.subscribe((res:any) =>{
      this.searchText = res;
    })
    this.dataSharing.currentSortOrder.subscribe((res:any) =>{
      this.sortColumnOrder = res;
    })
    this.dataSharing.currentEquipmentList.subscribe((res:[Equipment]) =>{
      this.equipment = res;
    })
    
  }
  onMouseDown(e:MouseEvent){
    this.isDown = true;
    this.slider.classList.add('active');
    this.startY = e.pageY - this.slider.offsetHeight;
    this.scrollTop = this.slider.scrollTop ;
  }
  onMouseLeave(e:MouseEvent){
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseUp(e:MouseEvent){
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseMove(e:MouseEvent){
    if(!this.isDown) return;
    e.preventDefault();
    const y = e.pageY - this.slider.offsetHeight;
    const walk = (y - this.startY) * 3; //scroll-fast
    this.slider.scrollTop = this.scrollTop - walk;
  }
}
