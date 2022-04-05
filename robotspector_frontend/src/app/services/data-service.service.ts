import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  SharingData = new Subject();//subject

  private role = new BehaviorSubject('guest');
  currentRole = this.role.asObservable();

   constructor() { }
  changeDataSubject(data: any) {
    this.SharingData.next(data);
  }
  changeRole(newRole : string){
    this.role.next(newRole);
  }
}