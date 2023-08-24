import { Component, OnInit } from '@angular/core';
import { Racao } from 'src/app/models/racao.model';
import { RacaoService } from 'src/app/services/racao.service';

@Component({
  selector: 'app-racao-list',
  templateUrl: './racao-list.component.html',
  styleUrls: ['./racao-list.component.css']
})
export class RacaoListComponent implements OnInit {

  tableColumns: string[] = ['id-column', 'nome-column', 'marca-column', 'preco-column', 'estoque-column', 'quantidadeQuilos-column', 'sabor-column', 'animal-column'];
  racoes: Racao[] = [];

  constructor(private racaoService: RacaoService) {}

  ngOnInit(): void {
    this.racaoService.getRacoes().subscribe(data => {
      this.racoes = data;
    });
  }

}
