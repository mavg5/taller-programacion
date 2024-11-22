import { Component, OnInit } from '@angular/core';
import { ElementosService } from '../servicios/elementos.service';

interface Elemento {
  id: number;
  nombre: string;
  descripcion: string;
}

@Component({
  selector: 'app-elementos-list',
  templateUrl: './elementos-list.component.html',
  styleUrls: ['./elementos-list.component.css']
})
export class ListaElementosComponent implements OnInit {
  elementos: Elemento[] = [];

  constructor(private dataService: ElementosService) {}

  ngOnInit(): void {
    this.dataService.getElementos().subscribe(
      (data) => {
        this.elementos = data;
      },
      (error) => {
        console.error('Error al obtener los datos', error);
      }
    );
  }
}