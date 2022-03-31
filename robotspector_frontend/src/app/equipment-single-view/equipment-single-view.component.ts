import { Component, Input, OnInit } from '@angular/core';
import { DataServiceService } from '../services/data-service.service';
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
  
  constructor(private datasharing: DataServiceService) {
    datasharing.SharingData.subscribe((res: any) => {
      this.currentView= res;
    })
   }

  @Input()
  title?:String;

  ngOnInit(): void {
    this.slider = document.querySelector('#commenters');
   
  }
  onMouseDown(e:MouseEvent){
    console.log("Mouse has been clicked down");
    
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
  changeCurrentView(e:Event){
    console.log("Event from equipment view");
  }
}
