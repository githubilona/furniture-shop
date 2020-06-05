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

  constructor(private userAddressService: UserAddressService) {}

  ngOnInit(): void {
    this.fetchData();
  }
  fetchData() {
    this.userAddressService
      .getAddress()
      .subscribe((res) => (this.address = res));
  }
}
