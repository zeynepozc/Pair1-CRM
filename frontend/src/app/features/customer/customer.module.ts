import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { SharedModule } from '../../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';
import { ListCustomerComponent } from './components/list-customer/list-customer.component';
import { SearchFilterComponent } from './components/search-filter/search-filter.component';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';
import { CustomerInfoComponent } from './components/customer-info/customer-info.component';
import { CustomerAccountComponent } from './components/customer-account/customer-account.component';
import { AddressComponent } from './components/address/address.component';
import { ContactMediumComponent } from './components/contact-medium/contact-medium.component';

@NgModule({
  declarations: [
    SearchCustomerComponent,
    ListCustomerComponent,
    SearchFilterComponent,
    CreateCustomerComponent,
    CustomerInfoComponent,
    CustomerAccountComponent,
    AddressComponent,
    ContactMediumComponent,
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class CustomerModule {}
