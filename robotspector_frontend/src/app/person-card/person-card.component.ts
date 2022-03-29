import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-person-card',
  templateUrl: './person-card.component.html',
  styleUrls: ['./person-card.component.css']
})
export class PersonCardComponent implements OnInit {

  @Input() role?:String;
  @Input() level?:String;
  @Input() email?:String;
  @Input() image?:String;
  constructor() { }

  ngOnInit(): void {
  }
  getColor(){
   
    if ( this.role?.toLowerCase() == "admin"){
      return "#5C5CE0";
    }else if (this.role?.toLowerCase() == "engineer"){
      return "#E05C5C";
    }else {
      return "#FEC601";
    }
   
  }
  getImage(imageNumber?:String):String{
    console.log("../../assets/images/person_profile_" + imageNumber + ".png");
    return "../../assets/images/person_profile_" + imageNumber + ".png";
  }
}
