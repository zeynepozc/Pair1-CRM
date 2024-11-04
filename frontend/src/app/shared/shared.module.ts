import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [NavbarComponent, MainLayoutComponent],
  imports: [CommonModule, SharedRoutingModule, FormsModule],
  exports: [],
})
export class SharedModule {}
