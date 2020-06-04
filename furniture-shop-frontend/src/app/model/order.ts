import { CartItem } from './cart-item';
import { User } from './user';

export class Order {
    id: number;
    cartItems: CartItem[];
    orderDate: Date;
    user: User;
    orderID: number;
}
