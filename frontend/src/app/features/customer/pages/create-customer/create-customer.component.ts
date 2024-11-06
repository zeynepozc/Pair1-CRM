import { Component } from '@angular/core';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrl: './create-customer.component.scss',
})
export class CreateCustomerComponent {
  selectedTab: string = 'Customer Info';

  selectTab(tab: string) {
    this.selectedTab = tab;
  }
}
