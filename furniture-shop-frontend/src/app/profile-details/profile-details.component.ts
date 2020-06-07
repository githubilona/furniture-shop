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
  isDone: boolean;
  success: string;
  constructor(private userService: UserService) {
    this.success = 'Your profile details have been updated';
  }

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
      this.isDone = true;
      setTimeout(() => this.isDone = false, 5000);
      this.fetchData();
    });
  }
}
