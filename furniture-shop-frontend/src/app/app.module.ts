import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FurnitureListComponent } from './furniture-list/furniture-list.component';
import { FurnitureService } from './service/furniture/furniture.service';
import { NavbarComponent } from './navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { FooterComponent } from './footer/footer.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginComponent } from './login/login.component';
import { UserService } from './service/user/user.service';
import { AuthService } from './service/auth/auth.service';
import { CartComponent } from './cart/cart.component';
import { CartService } from './service/cart/cart.service';
import { RequestInterceptor } from './service/auth/request-interceptor';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderService } from './service/order/order-service.service';
import { UserAddressComponent } from './user-address/user-address.component';

@NgModule({
  declarations: [
    AppComponent,
    FurnitureListComponent,
    NavbarComponent,
    FooterComponent,
    RegistrationFormComponent,
    LoginComponent,
    CartComponent,
    OrderListComponent,
    UserAddressComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule,
  ],
  providers: [
    FurnitureService,
    UserService,
    AuthService,
    CartService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true,
    },
    OrderService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
