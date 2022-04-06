import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipment } from '../equipment-single-view/equipment';

@Injectable({
  providedIn:'root'
})
export class EquipmentService {

  getAllEquipmentUrl = "http://localhost:8002/all/";
  createEquipmentUrl = "http://localhost:8002/create/";
  deleteEquipmentUrl = "http://localhost:8002/delete/";
  constructor(private httpClient:HttpClient) {}
  getAllEquipment() {
    return this.httpClient.get<Equipment[]>(this.getAllEquipmentUrl);
  }
  createEquipment(data:Equipment){
    return this.httpClient.post<Equipment>(this.createEquipmentUrl,data);
  }
  deleteEquipment(id:any){
    return this.httpClient.put<Equipment>(this.deleteEquipmentUrl + id,{});
  }
}
