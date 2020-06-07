import { Component, OnInit } from '@angular/core';
import { Furniture } from '../model/furniture';
import { FurnitureService } from '../service/furniture/furniture.service';
import { CartService } from '../service/cart/cart.service';
import { CartItem } from '../model/cart-item';
import { AuthService } from '../service/auth/auth.service';

@Component({
  selector: 'app-furniture-list',
  templateUrl: './furniture-list.component.html',
  styleUrls: ['./furniture-list.component.css'],
})
export class FurnitureListComponent implements OnInit {
  furniture: Furniture[];
  bought: boolean;
  list: Array<CartItem> = [];

  constructor(
    private furnitureService: FurnitureService,
    private cartService: CartService,
    public authService: AuthService
  ) {}

  ngOnInit() {
    this.fetchData();
  }

  fetchData() {
    this.furnitureService.findAll().subscribe((data) => {
      this.furniture = data;
    });
  }
  addToCart(id: number, amount: number) {
    this.cartService.save(id, amount).subscribe((res) => {
      this.bought = true;
      setTimeout(() => this.changeStatus(), 2000);
    });
  }
  changeStatus() {
    this.bought = false;
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }
  delete(id: number) {
    return this.furnitureService.delete(id).subscribe(() => this.fetchData());
  }
}
