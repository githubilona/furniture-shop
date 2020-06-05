import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Address } from 'src/app/model/address';

@Injectable({
  providedIn: 'root',
})
export class UserAddressService {
  userAddressUrl: string;

  constructor(private http: HttpClient) {
    this.userAddressUrl = 'http://localhost:8080/address';
  }
  public getAddress() {
    return this.http.get<Address>(this.userAddressUrl);
  }

  public update(address: Address) {
    return this.http.put<Address>(this.userAddressUrl, address);
  }
}
