import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import { Subscription } from 'rxjs';
import { Inspection } from '../model/Inspection.model';
import { VerificationDetails } from '../model/VerificationDetails.model';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';
import { animate, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-inspector-list',
  templateUrl: './inspector-list.component.html',
  styleUrls: ['./inspector-list.component.css'],
  animations: [
    trigger('fade', [
      transition('* => show', [ // using status here for transition
        style({ opacity: 0 }),
        animate(250, style({ opacity: 1 }))
      ]),
      transition('* => void', [
        animate(150, style({ opacity: 0 }))
      ])
    ])
  ]
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
  @Input()
  inspectionList : Inspection[] = [];
  @Input()
  showVerified:boolean = false;
  constructor(private dataSharing: DataService, private equipmentSingleViewService: EquipmentSingleViewService) { }
  ngOnInit(): void {
    this.dataSharing.currentEquipmentId.subscribe(x =>{
      this.equipmentSingleViewService.getAllInspections(x).subscribe(data =>{
        this.inspectionList = data;
        console.log(this.inspectionList);
      })
    })
    
    this.dataSharing.currentRole.subscribe(data =>{
      this.currentRole = data;
      console.log(data);
    })
    this.dataSharing.showVerified.subscribe((data:any) =>{
      this.showVerified = data;
    })
    this.dataSharing.listOfInspections.subscribe((data:any)=>{
      this.inspectionList = data;
    })
  }
  getSeverityLevel(inspection:any){
    console.log("======");
    let firstValue = this.inspectionList.filter((a) => a.id == inspection.id);
    if (firstValue.length != 0){
      return firstValue[0].verificationDetails?.inspectionResult?.severity
    }
    console.log("======");
    return inspection.verificationDetails?.inspectionResult.severity == undefined ? -1000 : inspection.verificationDetails?.inspectionResult.severity;
  }

  getVerificationDate(inspection : any){
    return inspection.verificationDetails?.verifiedDate.date == undefined ? '' : inspection.verificationDetails?.verifiedDate.date;
  }

  getVerificationComment(inspection : any){
    return inspection.verificationDetails?.engineerComment == undefined ? '' : inspection.verificationDetails?.engineerComment;

  }


  ngAfterViewInit():void{
    console.log("after view init");
    this.slider = document.querySelector('#comments_inspection');
  }

  ngOnDestroy(){
    this.subscription?.unsubscribe();
  }
  onMouseDown(e:MouseEvent){
    this.slider  = !this.showVerified? document.querySelector('#comments_inspection'):document.querySelector("#inspection_not_verified");
    this.isDown = true;
    this.slider.classList.add('active');
    this.startY = e.pageY - this.slider.offsetHeight;
    this.scrollTop = this.slider.scrollTop ;
  }
  onMouseLeave(e:MouseEvent){
    this.slider  = !this.showVerified? document.querySelector('#comments_inspection'):document.querySelector("#inspection_not_verified");
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseUp(e:MouseEvent){
    this.slider  = !this.showVerified? document.querySelector('#comments_inspection'):document.querySelector("#inspection_not_verified");
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseMove(e:MouseEvent){
    this.slider  = !this.showVerified? document.querySelector('#comments_inspection'):document.querySelector("#inspection_not_verified");
    if(!this.isDown) return;
    e.preventDefault();
    const y = e.pageY - this.slider.offsetHeight;
    const walk = (y - this.startY) * 3; //scroll-fast
    this.slider.scrollTop = this.scrollTop - walk;
  }
}
