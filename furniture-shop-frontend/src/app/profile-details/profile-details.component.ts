import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user/user.service';

@Component({
  selector: 'app-profile-details',
  templateUrl: './profile-details.component.html',
  styleUrls: ['./profile-details.component.css'],
})
export class ProfileDetailsComponent implements OnInit {
  user: User;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.fetchData();
  }
  fetchData() {
    this.userService.getCurrentUser().subscribe((res) => {
      this.user = res;
      this.user.password = null;
    });
  }

  updateUser() {
    this.userService.update(this.user.id, this.user).subscribe((res) => {
      sessionStorage.setItem(
        'token',
        btoa(this.user.username + ':' + this.user.password)
      );
      this.fetchData();
    });
  }
}
