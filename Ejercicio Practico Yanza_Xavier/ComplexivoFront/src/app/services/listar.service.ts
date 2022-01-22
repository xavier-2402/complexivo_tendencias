import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/usuario';


@Injectable({
  providedIn: 'root'
})
export class ListarService {

  httpHeaders: any;
  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      Authorization: localStorage.getItem('token'),
    });
   }

   private url = 'http://localhost:8080/listar-usuarios';

  listarUsuarios() {
    return this.http.get<Usuario[]>(this.url, { headers: this.httpHeaders });
  }
}
