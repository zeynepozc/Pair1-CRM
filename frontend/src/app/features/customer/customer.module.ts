import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { SharedModule } from '../../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';
import { ListCustomerComponent } from './components/list-customer/list-customer.component';
import { SearchFilterComponent } from './components/search-filter/search-filter.component';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';

@NgModule({
  declarations: [SearchCustomerComponent,ListCustomerComponent,SearchFilterComponent,CreateCustomerComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class CustomerModule {}
