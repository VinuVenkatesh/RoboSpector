import { animate, style, transition, trigger } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { InspectionResult } from '../equipment-single-view/InspectionResult';
import { VerificationDetails } from '../model/VerificationDetails.model';
import { DataService } from '../services/data-service.service';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';

@Component({
  selector: 'app-verify-modal',
  templateUrl: './verify-modal.component.html',
  styleUrls: ['./verify-modal.component.css'],
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
export class VerifyModalComponent implements OnInit {

  @Input()
  showModal:boolean = true;

  severityNames = ["Acceptable",
  "Minor wear","Major wear","On-site","911"];

  verifyForm:any;
  comment = new FormControl();
  severity = new FormControl();

  @Input()
  severityValue?:string;

  @Input()
  verificationDetials = new VerificationDetails();
  inspectionId:string = "";
  constructor(private dataSharing:DataService,private formBuilder:FormBuilder,private equipmentSingleViewService:EquipmentSingleViewService) { }

  ngOnInit(): void {
    this.dataSharing.currentVerifyModalState.subscribe((data:boolean) =>{
      this.showModal = data;
    })
    this.verifyForm = this.formBuilder.group({
      comment: "",
      severity : "",
   })
   this.dataSharing.currentEngineerName.subscribe((data:any) =>{
    this.verificationDetials.verifiedBy = data;
   })
   this.dataSharing.currentInspectionId.subscribe((data:any) =>{
     this.inspectionId = data;
   })
   this.dataSharing.selectedSeverity.subscribe((data:any) =>{
    this.severityValue = data;
   })
  }
  onClickCancel(){
    this.showModal = !this.showModal;
    this.dataSharing.changeCurrentVerifyModalState(this.showModal);
  }
  toggleModalState(){
    this.showModal = !this.showModal;
    this.dataSharing.changeCurrentVerifyModalState(this.showModal);
  }

  onVerifySubmit(){
    console.log();
    let inspectionResult = new InspectionResult();
    let verificationDetails = new VerificationDetails();
    
    verificationDetails.engineerComment = this.comment.value;
    inspectionResult.severity = this.getSeverity(this.severityValue);
    inspectionResult.name = this.severityValue;

    verificationDetails.inspectionResult = inspectionResult;

    verificationDetails.verifiedBy = this.verificationDetials.verifiedBy;

      this.equipmentSingleViewService.addVerificationDetails(verificationDetails,this.inspectionId).subscribe((data:any)=>{
        console.log("inspection is", data);
      })
    if (this.verificationDetials.inspectionResult?.severity != null){
     
      
    }
    
  }
  getSeverity(severityVal:any){
    switch(severityVal){
      case "Acceptable":
        return 1;
      case "Minor wear":
          return 2;
      case "Major Wear":
          return 3;
      case "On-site":
        return 4;
      case "911":
        return 99;
      default:
        return 1;
    }
      
  }
}