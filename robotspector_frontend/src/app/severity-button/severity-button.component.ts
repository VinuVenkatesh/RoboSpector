import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-severity-button',
  templateUrl: './severity-button.component.html',
  styleUrls: ['./severity-button.component.css']
})
export class SeverityButtonComponent implements OnInit {

  constructor() { }

  @Input()
  title?:string;

  ngOnInit(): void {
  }

}
