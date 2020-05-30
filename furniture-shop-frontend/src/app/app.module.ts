import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FurnitureListComponent } from './furniture-list/furniture-list.component';
import { FurnitureService } from './service/furniture.service';
import { NavbarComponent } from './navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';


@NgModule({
   declarations: [
      AppComponent,
      FurnitureListComponent,
      NavbarComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      MatToolbarModule,
      BrowserAnimationsModule,
      MatButtonModule
   ],
   providers: [
     FurnitureService
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
