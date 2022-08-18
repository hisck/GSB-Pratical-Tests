import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { User } from "./user";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService{
  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public findUsers(userId: number): Observable<User>{
    return this.http.get<User>(`${this.apiServerUrl}/users/${userId}`);
  }

  public getUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiServerUrl}/users/all`);
  }

  public addUser(user: User): Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/users/create`, user);
  }

  public updateUser(user: User): Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/users/update`, user);
  }

  public deleteUser(userId: number): Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/users/delete/${userId}`, userId);
  }
}
