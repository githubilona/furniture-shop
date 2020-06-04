import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Order } from 'src/app/model/order';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private ordersUrl: string;
  constructor(private http: HttpClient) {
    this.ordersUrl = 'http://localhost:8080/orders';
  }
  public findAll(){
    return this.http.get<Order[]>(this.ordersUrl);
  }
}
