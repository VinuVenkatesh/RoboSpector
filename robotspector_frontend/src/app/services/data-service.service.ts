import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  SharingData = new Subject();//subject
   constructor() { }

 //update value
  changeDataSubject(data: any) {
    this.SharingData.next(data.value);
  }
}