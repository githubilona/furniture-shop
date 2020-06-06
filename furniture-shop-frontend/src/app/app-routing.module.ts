import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FurnitureListComponent } from './furniture-list/furniture-list.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { OrderListComponent } from './order-list/order-list.component';
import { UserAddressComponent } from './user-address/user-address.component';
import { ProfileDetailsComponent } from './profile-details/profile-details.component';


const routes: Routes = [
  { path: 'furniture', component: FurnitureListComponent },
  { path: 'register', component: RegistrationFormComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cart', component: CartComponent },
  { path: 'orders', component: OrderListComponent },
  { path: 'address', component: UserAddressComponent },
  { path: 'user/profile', component: ProfileDetailsComponent },
  { path: 'user', component: ProfileDetailsComponent },
  { path: 'user/:id', component: ProfileDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
