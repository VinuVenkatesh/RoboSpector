import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Equipment } from '../equipment-single-view/Equipment';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  SharingData = new Subject();//subject
  detailedEquipmentData = new Subject();
  currentSelectedRowData = new Subject();
  curentSelectedEquipment = new Subject();
  currentDashboardInputData = new Subject();
  currentSortOrder = new Subject();
  currentCreateModalState = new Subject();
  currentEquipmentLength = new Subject<string>();
  currentEquipmentList = new Subject<[Equipment]>();
  currentAlertState = new Subject();
  currentVerifyModalState = new Subject<boolean>();
  showVerified =  new Subject<boolean>();
  selectedSeverity = new Subject<string>();

  private role = new BehaviorSubject('guest');
  currentRole = this.role.asObservable();

  private userName = new BehaviorSubject('Guest');
  currentUserName = this.userName.asObservable();

  private engineerName = new BehaviorSubject('Kevin');
  currentEngineerName = this.engineerName.asObservable();

   constructor() { }
  changeDataSubject(data: any) {
    this.SharingData.next(data);
  }
  changedetailedEquipmentData(data:any){
    this.detailedEquipmentData.next(data);
  }
  changeCurrentSelectedRowData(data:any){
    this.currentSelectedRowData.next(data);
  }
  changeDashboardInputText(data:any){
    this.currentDashboardInputData.next(data);
  }
  changeSortOrder(data:any){
    this.currentSortOrder.next(data);
  }
  changeCurrentCreateModalState(data:boolean){
    this.currentCreateModalState.next(data);
  }
  changeCurrentEquipmentLength(data:string){
    this.currentEquipmentLength.next(data);
  }
  changeCurrentEquipmentList(data:[Equipment]){
    this.currentEquipmentList.next(data);
  }
  changeCurrentAlertState(data:any){
    this.currentAlertState.next(data);
  }
  changeCurentSelectedEquipment(data:any){
    this.curentSelectedEquipment.next(data);
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
  changeShowVerifiedStatus(data:boolean){
    this.showVerified.next(data);
  }
  changeCurrentVerifyModalState(data:boolean){
    this.currentVerifyModalState.next(data);
  }
  changeSelectedSeverity(data:string){
    this.selectedSeverity.next(data);
  }
}
