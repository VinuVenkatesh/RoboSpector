import { animate, style, transition, trigger } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DataService } from '../services/data-service.service';

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

  constructor(private dataSharing:DataService,private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.dataSharing.currentVerifyModalState.subscribe((data:boolean) =>{
      this.showModal = data;
    })
    this.verifyForm = this.formBuilder.group({
      name: "",
      locationurl: "",
      long:"",
      lat:"",
      age:"",
      comment:"",
   })
  }
  onClickCancel(){

  }
  toggleModalState(){
    this.showModal = !this.showModal;
    this.dataSharing.changeCurrentVerifyModalState(this.showModal);
  }

  onVerifySubmit(){

  }

}
