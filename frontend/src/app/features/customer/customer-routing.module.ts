import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';
import { CustomerInfoComponent } from './components/customer-info/customer-info.component';
import { AddressComponent } from './components/address/address.component';
import { ContactMediumComponent } from './components/contact-medium/contact-medium.component';
import { CustomerAccountComponent } from './components/customer-account/customer-account.component';
import { CreateBillingAccountComponent } from './components/create-billing-account/create-billing-account.component';

const routes: Routes = [
  {
    path: 'create-customer',
    component: CreateCustomerComponent,
    children: [
      { path: 'customer-info', component: CustomerInfoComponent },
      { path: 'address', component: AddressComponent },
      { path: 'contact-medium', component: ContactMediumComponent },
      { path: 'customer-account', component: CustomerAccountComponent },
      {
        path: 'create-billing-account',
        component: CreateBillingAccountComponent,
      },
      { path: '', redirectTo: 'customer-info', pathMatch: 'full' }, // İlk sekme varsayılan
    ],
  },
  {
    path: 'search-customer',
    component: SearchCustomerComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule {}
