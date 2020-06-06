import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AuthService {
  adminUrl: string;
  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin';
  }

  public getToken(): string {
    return sessionStorage.getItem('token');
  }

  public isAuthenticated() {
    return this.getToken() !== null && this.getToken() !== '';
  }

  public hasAdminRole() {
    return (
      localStorage.getItem('adminRole') !== null &&
      localStorage.getItem('adminRole') === 'true'
    );
  }

  public fetchAdminRole() {
    this.http
      .get<boolean>(this.adminUrl)
      .subscribe((res) => localStorage.setItem('adminRole', String(res)));
  }
}
