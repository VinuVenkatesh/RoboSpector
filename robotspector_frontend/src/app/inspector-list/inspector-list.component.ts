import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Inspection } from '../model/Inspection.model';
import { VerificationDetails } from '../model/VerificationDetails.model';
import { DataServiceService } from '../services/data-service.service';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';

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
  subscription?:Subscription;
  currentRole?:string;
  comment:String = `Sturdy , albeit needs further inspection potential mechanical issues Sturdy , 
  albeit needs further needs further inspection Sturdy , albeit needs further inspection 
  potential mechanical issues Sturdy , albeit needs further needs albeit  ..............`
  inspectionList : Inspection[] = [];
  constructor(private dataSharing: DataServiceService, private equipmentSingleViewService: EquipmentSingleViewService) { 
    dataSharing.SharingData.subscribe((res:any) =>{
      
    })
  }

  getSeverityLevel(inspection:any){
    return inspection.verificationDetails?.inspectionResult.severity == undefined ? -1000 : inspection.verificationDetails?.inspectionResult.severity;
  }

  getVerificationDate(inspection : any){
    return inspection.verificationDetails?.verifiedDate.date == undefined ? '' : inspection.verificationDetails?.verifiedDate.date;
  }

  getVerificationComment(inspection : any){
    return inspection.verificationDetails?.engineerComment == undefined ? '' : inspection.verificationDetails?.engineerComment;

  }


  ngOnInit(): void {
    this.slider = document.querySelector('#comments_inspection');
    this.equipmentSingleViewService.getAllInspections(3).subscribe(data =>{
      this.inspectionList = data;
      console.log(this.inspectionList);
    })
    this.dataSharing.currentRole.subscribe(data =>{
      this.currentRole = data;
      console.log(data);
    })
    
  }

  ngOnDestroy(){
    this.subscription?.unsubscribe();
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
