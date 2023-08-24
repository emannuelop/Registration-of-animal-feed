import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RacaoRoutingModule } from './racao-routing.module';
import { RacaoListComponent } from './components/racao-list/racao-list.component';
import { RacaoFormComponent } from './components/racao-form/racao-form.component';
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';

import { ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    RacaoListComponent,
    RacaoFormComponent
  ],
  imports: [
    CommonModule,
    RacaoRoutingModule,
    MatTableModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ]
})
export class RacaoModule { }
