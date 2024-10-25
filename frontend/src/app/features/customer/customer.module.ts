import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { SharedModule } from '../../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';

@NgModule({
  declarations: [SearchCustomerComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class CustomerModule {}
