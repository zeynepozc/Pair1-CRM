import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { LoginComponent } from './pages/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [LoginComponent],
  imports: [CommonModule, UserRoutingModule, FormsModule, ReactiveFormsModule],
  exports: [],
})
export class UserModule {}
