import { Component, OnInit } from '@angular/core';
import { UserAddressService } from '../service/user-address/user-address.service';
import { Address } from '../model/address';

@Component({
  selector: 'app-user-address',
  templateUrl: './user-address.component.html',
  styleUrls: ['./user-address.component.css'],
})
export class UserAddressComponent implements OnInit {
  address: Address;
  isDone: boolean;

  constructor(private userAddressService: UserAddressService) {}

  ngOnInit(): void {
    this.fetchData();
  }
  fetchData() {
    this.userAddressService
      .getAddress()
      .subscribe((res) => (this.address = res));
  }

  updateAddress() {
    this.userAddressService.update(this.address).subscribe((res) => {
      this.address = res;
      this.isDone = true;
      setTimeout(() => (this.isDone = false), 5000);
    });
  }
}
