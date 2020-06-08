import { Component, OnInit } from '@angular/core';
import { Furniture } from '../model/furniture';
import { FurnitureService } from '../service/furniture/furniture.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-furniture',
  templateUrl: './edit-furniture.component.html',
  styleUrls: ['./edit-furniture.component.css'],
})
export class EditFurnitureComponent implements OnInit {
  furniture: Furniture;
  urlId: number;
  constructor(
    private furnitureService: FurnitureService,
    private at: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData() {
    this.at.params.subscribe((params) => (this.urlId = params.id));
    this.furnitureService
      .findById(this.urlId)
      .subscribe((res) => (this.furniture = res));
  }

  edit() {
    this.furnitureService.edit(this.urlId, this.furniture).subscribe(
      (res) => {
        this.furniture = res;
        this.router.navigate(['/furniture']);
      },
      (err) => {}
    );
  }
}
