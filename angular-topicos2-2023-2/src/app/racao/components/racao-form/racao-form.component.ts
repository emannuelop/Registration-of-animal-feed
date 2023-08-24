import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RacaoService } from 'src/app/services/racao.service';

@Component({
  selector: 'app-racao-form',
  templateUrl: './racao-form.component.html',
  styleUrls: ['./racao-form.component.css']
})
export class RacaoFormComponent {
  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private racaoService: RacaoService,
              private router: Router) {
    this.formGroup = formBuilder.group({
      nome:['', Validators.required],
      marca:['', Validators.required],
      preco:['', Validators.required],
      estoque:['', Validators.required],
      quantidadeQuilos:['', Validators.required],
      sabor:['', Validators.required],
      animal:['', Validators.required]
    })
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const novoRacao = this.formGroup.value;
      this.racaoService.salvar(novoRacao).subscribe({
        next: (racaoCadastrado) => {
          this.router.navigateByUrl('/racoes/list');
        },
        error: (err) => {
          console.log('Erro ao salvar' + JSON.stringify(err));
        }
      })
    
    }
  }

}