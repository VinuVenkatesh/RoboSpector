import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipment } from '../equipment-single-view/equipment';

@Injectable({
  providedIn:'root'
})
export class EquipmentService {

  url = "http://localhost:8002/all/";
  constructor(private httpClient:HttpClient) {

  }

  getAllEquipment() {
    return this.httpClient.get<Equipment[]>(this.url);
  }
}
