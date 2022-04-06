import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {
  SharingData = new Subject();//subject

  private role = new BehaviorSubject('guest');
  currentRole = this.role.asObservable();

  private userName = new BehaviorSubject('Kale');
  currentUserName = this.userName.asObservable();

  private engineerName = new BehaviorSubject('Kevin');
  currentEngineerName = this.engineerName.asObservable();

   constructor() { }
  changeDataSubject(data: any) {
    this.SharingData.next(data);
  }
  changeRole(newRole : string){
    this.role.next(newRole);
  }
  changeUser_Name(newUserName : string){
    this.userName.next(newUserName);
  }

  changeEngineerName(newEngineerName : string){
    this.engineerName.next(newEngineerName);
  }
}