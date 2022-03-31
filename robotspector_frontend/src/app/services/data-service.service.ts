import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  SharingData = new Subject();//subject
   constructor() { }
  changeDataSubject(data: any) {
    this.SharingData.next(data);
  }
}