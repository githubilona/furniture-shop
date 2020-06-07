import { Component, OnInit } from '@angular/core';
import { Furniture } from '../model/furniture';
import { FurnitureService } from '../service/furniture/furniture.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-furniture',
  templateUrl: './add-furniture.component.html',
  styleUrls: ['./add-furniture.component.css'],
})
export class AddFurnitureComponent implements OnInit {
  furniture: Furniture;

  constructor(private furnitureService: FurnitureService, private router: Router) {}

  ngOnInit(): void {}
  onSubmit() {
    this.furnitureService.save(this.furniture).subscribe(
      (result) => this.goToFurnitureList(),
      (res) => alert('Failed to add new furniture')
    );
  }
  goToFurnitureList() {
    this.router.navigate(['/discs']);
  }
}
