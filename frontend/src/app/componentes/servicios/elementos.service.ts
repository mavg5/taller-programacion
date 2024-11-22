import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Elemento {
  id: number;
  nombre: string;
  descripcion: string;
}

@Injectable({
  providedIn: 'root'
})
export class ElementosService {
  private apiUrl = 'http://localhost:8080/mostrar/elementos';  // URL del backend

  constructor(private http: HttpClient) {}

  getElementos(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}
