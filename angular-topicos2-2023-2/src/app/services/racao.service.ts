import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Racao } from '../models/racao.model';

@Injectable({
  providedIn: 'root'
})
export class RacaoService {
  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getRacoes(): Observable<Racao[]> {
    return this.http.get<Racao[]>(`${this.baseURL}/racoes`);
  }

  salvar(racao: Racao): Observable<Racao> {
    return this.http.post<Racao>(`${this.baseURL}/racoes`, racao);
  }
}
