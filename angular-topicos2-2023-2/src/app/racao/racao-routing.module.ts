import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RacaoListComponent } from './components/racao-list/racao-list.component';
import { RacaoFormComponent } from './components/racao-form/racao-form.component';

const routes: Routes = [
  {path: 'list', component: RacaoListComponent},
  {path: 'new', component: RacaoFormComponent},
  {path: 'edit/:id', component: RacaoFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RacaoRoutingModule { }
