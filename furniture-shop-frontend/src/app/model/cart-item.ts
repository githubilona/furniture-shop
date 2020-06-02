import { Furniture } from './furniture';

export class CartItem {
  id: number;
  furniture: Furniture;
  amount: number;

  constructor(id: number, furniture: Furniture, amount: number) {
    this.id = id;
    this.furniture = furniture;
    this.amount = amount;
  }
}
