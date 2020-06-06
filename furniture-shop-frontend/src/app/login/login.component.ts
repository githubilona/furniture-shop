import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  model: any = {};
  invalidText = 'Incorrect login and/or password';
  isInvalid: boolean;
  info: boolean;
  timer: any;
  value: number;
  loading = false;
  baseUrl: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private authService: AuthService
  ) {
    this.baseUrl = 'http://localhost:8080/';
  }

  ngOnInit(): void {
    sessionStorage.setItem('token', '');
  }
  // login() {
  //   this.http
  //     .post<Observable<boolean>>('http://localhost:8080/login', {
  //       username: this.model.username,
  //       password: this.model.password,
  //     })
  //     .subscribe((isValid) => {
  //       if (isValid) {
  //         sessionStorage.setItem(
  //           'token',
  //           btoa(this.model.username + ':' + this.model.password)
  //         );
  //         this.router.navigate(['/furniture']);
  //       } else {
  //         alert('Wrong login or password');
  //       }
  //     });
  // }

  login() {
    this.http
      .post<Observable<boolean>>(this.baseUrl + 'login', {
        username: this.model.username,
        password: this.model.password,
      })
      .subscribe((isValid) => {
        if (isValid) {
          sessionStorage.setItem(
            'token',
            btoa(this.model.username + ':' + this.model.password)
          );
          this.info = true;
          this.authService.fetchAdminRole();

          this.router.navigate(['/furniture']);
        } else {
          alert('Wrong login or password');
        }
      });
  }
}
