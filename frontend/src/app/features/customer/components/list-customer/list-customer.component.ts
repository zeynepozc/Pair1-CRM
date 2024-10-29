import { Component, Input } from '@angular/core';
import { CustomerSearchRequest } from '../../models/customerSearchRequest';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrl: './list-customer.component.scss',
})
export class ListCustomerComponent {
  @Input() searchData!: CustomerSearchRequest[];
}
