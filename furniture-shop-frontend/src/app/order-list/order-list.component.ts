import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order';
import { Router } from '@angular/router';
import { OrderService } from '../service/order/order-service.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
})
export class OrderListComponent implements OnInit {
  orders: Order[];

  constructor(private router: Router, private orderService: OrderService) {}

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData() {
    this.orderService.findAll().subscribe((res) => (this.orders = res));
  }
  calculateSum(id: number) {
    let sum = 0;
    const cartItems = this.orders[id].cartItems;
    cartItems.forEach(cartItem => {
      sum += cartItem.amount * cartItem.furniture.price;
    });
    return sum;
  }
}
