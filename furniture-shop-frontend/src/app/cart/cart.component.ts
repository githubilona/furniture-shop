import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartDto } from '../model/cart-dto';
import { CartService } from '../service/cart/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cartItems: CartDto;
  sum: number;

  constructor(private router: Router, private cartService: CartService) {}

  ngOnInit(): void {
    this.fetchData();
  }
  fetchData() {
    this.cartService.findAll().subscribe((res) => {
      this.cartItems = res;
      this.calculateSum();
    });
  }

  calculateSum() {
    let total = 0;
    this.cartItems.list.forEach((cartItem) => {
      total += cartItem.amount * cartItem.furniture.price;
    });
    this.sum = total;
  }

  buy() {
    this.cartService
      .buy()
      .subscribe((res) => this.router.navigate(['/orders']));
  }
  remove(id: number){
    this.cartService.remove(id).subscribe(() => this.fetchData());
  }
}
