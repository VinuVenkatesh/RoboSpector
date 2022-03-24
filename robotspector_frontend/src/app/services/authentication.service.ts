import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn:'root'
})
export class AuthenticationService {

  url = "http://localhost:3000/auth/v1/";
  constructor(private httpClient:HttpClient) {

  }

  authenticateUser(data:any) {
   
    return this.httpClient.post(this.url, {"username":data.username, "password":data.password});
  }

  setBearerToken(token:any) {
    localStorage.setItem('bearerToken',token);
  }

  getBearerToken() {
    return localStorage.getItem('bearerToken');
  }

  // isUserAuthenticated(): Promise<boolean> {

  //   return this.httpClient.post<boolean>(`${this.url}isAuthenticated`,{},
  //   {
  //     headers: new HttpHeaders().set('Authorization',`${this.getBearerToken()}`)
  //   }).toPromise()
    
  // }
}
