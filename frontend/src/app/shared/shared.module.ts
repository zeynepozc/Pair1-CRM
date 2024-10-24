import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';

@NgModule({
  declarations: [NavbarComponent, MainLayoutComponent],
  imports: [CommonModule, SharedRoutingModule],
  exports: [],
})
export class SharedModule {}
