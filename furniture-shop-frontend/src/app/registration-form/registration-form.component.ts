import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css'],
})
export class RegistrationFormComponent implements OnInit {
  user: User;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
    this.user = new User();
  }

  ngOnInit(): void {}

  onSubmit() {
    this.userService.save(this.user).subscribe((result) => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/furniture']);
  }
}
