import { Component, OnInit } from '@angular/core';
import { Furniture } from '../model/furniture';
import { FurnitureService } from '../service/furniture/furniture.service';

@Component({
  selector: 'app-furniture-list',
  templateUrl: './furniture-list.component.html',
  styleUrls: ['./furniture-list.component.css'],
})
export class FurnitureListComponent implements OnInit {
  furniture: Furniture[];

  constructor(private furnitureService: FurnitureService) {}

  ngOnInit() {
    this.furnitureService.findAll().subscribe((data) => {
      this.furniture = data;
    });
  }
}
