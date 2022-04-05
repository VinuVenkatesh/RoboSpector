import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, MaxLengthValidator, Validators } from '@angular/forms';
import { VerificationDetails } from '../model/VerificationDetails.model';

@Component({
  selector: 'app-inspector-card',
  templateUrl: './inspector-card.component.html',
  styleUrls: ['./inspector-card.component.css']
})
export class InspectorCardComponent implements OnInit {

  @Input()
  severityLevel?:number;

  @Input()
  collectingTime?: number;

  @Input()
  date? : string;
  
  @Input()
  engineerName? : string;

  @Input()
  verificationDate?: string;
  
  @Input()
  verificationComment? : string;

  form : any;

  verificationDetails?: VerificationDetails

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      verifiedBy :[3],
      engineerComment:['test',[Validators.maxLength(1000)]],
      name: ['Acceptable'],
      severity:[1]
    })
  }

  getColor(){

    switch(this.severityLevel){
      
      case 1:
        return "#86E05C";
      case 2:
        return "#DDE05C";
      case 3:
        return "#E99363";
      case 4:
        return "#E05C5C";
      case 5:
        return "#A91212";
      default:
        return "#DDE05C";
    }
   
  }

  onSubmit(){
    this.verificationDetails = {
      verifiedBy : this.form.get('verifiedBy').value,
    inspectionResult:{
        name : this.form.get('name').value,
        severity : this.form.get('severity').value
    },
    engineerComment : this.form.get('engineerComment').value
    }
    console.log(this.verificationDetails)
  }
}
