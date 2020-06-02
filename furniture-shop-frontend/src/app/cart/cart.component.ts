import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartDto } from '../model/cart-dto';
import { CartService } from '../service/cart/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  items: CartDto;
  sum: number;

  constructor(private router: Router, private cartService: CartService) { }

  ngOnInit(): void {
    this.fetchData();
  }
  fetchData() {
    this.cartService.findAll().subscribe(
      res => {
        this.items = res;
        // this.calculateSum();
      });
  }

}
