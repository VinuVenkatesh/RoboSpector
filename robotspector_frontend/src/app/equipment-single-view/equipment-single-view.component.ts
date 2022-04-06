import { Component, Input, OnInit } from '@angular/core';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';
import { DataService } from '../services/data-service.service';
@Component({
  selector: 'app-equipment-single-view',
  templateUrl: './equipment-single-view.component.html',
  styleUrls: ['./equipment-single-view.component.css']
})
export class EquipmentSingleViewComponent implements OnInit {

  slider:any;
  isDown:any = false;
  startX:any;
  scrollLeft:any;
  currentView:String = "location";
  viewTitles = {"Inspection":"Inspection", "Location":"Location", "Comments":"comments"};
  constructor(private dataSharing: DataService) {}

  @Input()
  title?:String;

  ngOnInit(): void {

    this.dataSharing.SharingData.subscribe((res:any) =>{
      this.currentView = res;
    })
  }
  onMouseDown(e:MouseEvent){

    this.isDown = true;
    this.slider.classList.add('active');
    this.startX = e.pageX - this.slider.offsetLeft;
    this.scrollLeft = this.slider.scrollLeft;
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
    const x = e.pageX - this.slider.offsetLeft;
    const walk = (x - this.startX) * 3; //scroll-fast
    this.slider.scrollLeft = this.scrollLeft - walk;
  }

}
