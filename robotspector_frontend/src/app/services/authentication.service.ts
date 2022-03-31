import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn:'root'
})
export class AuthenticationService {

  url = "http://localhost:8001/login/";
  constructor(private httpClient:HttpClient) {

  }

  authenticateUser(data:any) {
   
    return this.httpClient.post(this.url, {"username":data.username, "password":data.password});
  }

  setBearerToken(token:any) {
    localStorage.setItem('token',token);
  }

  getBearerToken() {
    return localStorage.getItem('token');
  }

  // isUserAuthenticated(): Promise<boolean> {

  //   return this.httpClient.post<boolean>(`${this.url}isAuthenticated`,{},
  //   {
  //     headers: new HttpHeaders().set('Authorization',`${this.getBearerToken()}`)
  //   }).toPromise()
    
  // }
}
