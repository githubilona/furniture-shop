import { Furniture } from './furniture';

export class CartItem {
  id: number;
  furniture: Furniture;
  price: number;
  amount: number;

  constructor(id: number, furniture: Furniture, price: number, amount: number) {
    this.id = id;
    this.furniture = furniture;
    this.price = price;
    this.amount = amount;
  }
}
