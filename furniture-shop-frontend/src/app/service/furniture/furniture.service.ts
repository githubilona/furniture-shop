import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Furniture } from '../../model/furniture';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class FurnitureService {
  private furnitureUrls: string;
  constructor(private http: HttpClient) {
    this.furnitureUrls = 'http://localhost:8080/furniture';
  }

  public findAll(): Observable<Furniture[]> {
    return this.http.get<Furniture[]>(this.furnitureUrls);
  }
}
