import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-inspector-list',
  templateUrl: './inspector-list.component.html',
  styleUrls: ['./inspector-list.component.css']
})
export class InspectorListComponent implements OnInit {
  slider:any;
  isDown:any = false;
  startY:any;
  scrollTop:any;
  comment:String = `Sturdy , albeit needs further inspection potential mechanical issues Sturdy , 
  albeit needs further needs further inspection Sturdy , albeit needs further inspection 
  potential mechanical issues Sturdy , albeit needs further needs albeit  ..............`
  constructor(private dataSharing: DataService) { 
    dataSharing.SharingData.subscribe((res:any) =>{
      
    })
  }

  ngOnInit(): void {
    this.slider = document.querySelector('#comments_inspection');
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
