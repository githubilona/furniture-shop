import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FurnitureListComponent } from './furniture-list/furniture-list.component';
import { FurnitureService } from './service/furniture/furniture.service';
import { NavbarComponent } from './navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { FooterComponent } from './footer/footer.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginComponent } from './login/login.component';
import { UserService } from './service/user/user.service';
import { AuthService } from './service/auth/auth.service';


@NgModule({
   declarations: [
      AppComponent,
      FurnitureListComponent,
      NavbarComponent,
      FooterComponent,
      RegistrationFormComponent,
      LoginComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      MatToolbarModule,
      BrowserAnimationsModule,
      MatButtonModule,
      FormsModule
   ],
   providers: [
     FurnitureService,
     UserService,
     AuthService
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
