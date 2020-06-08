import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Furniture } from '../../model/furniture';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class FurnitureService {
  private furnitureUrl: string;
  constructor(private http: HttpClient) {
    this.furnitureUrl = 'http://localhost:8080/furniture';
  }

  public findAll(): Observable<Furniture[]> {
    return this.http.get<Furniture[]>(this.furnitureUrl);
  }

  public save(furniture: Furniture) {
    return this.http.post<Furniture>(this.furnitureUrl + '/add', furniture);
  }
  public delete(id: number) {
    return this.http.delete(this.furnitureUrl + '/' + id);
  }

  public findById(id: number): Observable<Furniture> {
    return this.http.get<Furniture>(this.furnitureUrl + '/' + id);
  }

  public edit(id: number, furniture: Furniture) {
    return this.http.put<Furniture>(this.furnitureUrl + '/' + id, furniture);
  }
}
