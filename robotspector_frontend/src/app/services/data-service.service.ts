import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  SharingData = new Subject();//subject
  detailedEquipmentData = new Subject();
  currentSelectedRowData = new Subject();
  currentDashboardInputData = new Subject();
  currentSortOrder = new Subject();
  currentCreateModalState = new Subject();
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
}