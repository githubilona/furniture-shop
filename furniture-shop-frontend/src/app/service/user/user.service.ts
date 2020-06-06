import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private registerUrl: string;
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = 'http://localhost:8080/register';
    this.baseUrl = 'http://localhost:8080/';
  }
  public save(user: User) {
    return this.http.post<User>(this.registerUrl, user);
  }
  public getCurrentUser() {
    return this.http.get<User>(this.baseUrl + 'user/profile');
  }
  public update(id: number, user: User) {
    return this.http.put<User>(this.baseUrl + 'user/' + id, user);
  }
}
