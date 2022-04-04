import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Inspection } from '../model/Inspection.model';
import { VerificationDetails } from '../model/VerificationDetails.model';

@Injectable({
  providedIn: 'root'
})
export class EquipmentSingleViewService {

  equipmentServiceUrl = "http://localhost:8002"
  inspectionServiceUrl = "http://localhost:8004"

  constructor(private httpClient:HttpClient) { }

  getAllInspections(equipmentId:any){
    let url = this.equipmentServiceUrl + "/equipment/" + equipmentId;
    return this.httpClient.get<Inspection[]>(url);
  }

  addVerificationDetails(verificationDetails : any, inspectionId:any){
    let url = this.inspectionServiceUrl + "/verify/" + inspectionId;
    return this.httpClient.put<VerificationDetails>(url,verificationDetails);
  }
}
