import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../model/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private registerUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = 'http://localhost:8080/register';
  }
  public save(user: User) {
    return this.http.post<User>(this.registerUrl, user);
  }
}
