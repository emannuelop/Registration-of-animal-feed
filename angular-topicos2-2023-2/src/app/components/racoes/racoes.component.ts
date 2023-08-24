import { Component, OnInit } from '@angular/core';
import { Racao } from 'src/app/models/racao.model';
import { RacaoService } from 'src/app/services/racao.service';

@Component({
  selector: 'app-racoes',
  templateUrl: './racoes.component.html',
  styleUrls: ['./racoes.component.css']
})
export class RacoesComponent implements OnInit {

  estados: Racao[] = [];

  constructor(private racaoService: RacaoService) {}

  ngOnInit(): void {
    this.racaoService.getRacoes().subscribe(data => {
      this.estados = data;
    });
  }

}
