import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FurnitureListComponent } from './furniture-list/furniture-list.component';
import { FurnitureService } from './service/furniture.service';

@NgModule({
   declarations: [
      AppComponent,
      FurnitureListComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      HttpClientModule
   ],
   providers: [
     FurnitureService
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
