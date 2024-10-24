import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCustomerComponent } from './pages/create-customer/create-customer.component';
import { SearchCustomerComponent } from './pages/search-customer/search-customer.component';

const routes: Routes = [
  {
    path: 'create-customer',
    component: CreateCustomerComponent,
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
