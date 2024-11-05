import { Component, OnInit } from '@angular/core';
import { StorageService } from '../../../../shared/services/storage.service';
import { CustomerAccountService } from '../../services/customer-account.service';
import { GetCustomerAccountsByCustomerIdResponse } from '../../models/getCustomerAccountsByCustomerIdResponse';
import { Product } from '../../models/product';

@Component({
  selector: 'app-customer-account',
  templateUrl: './customer-account.component.html',
})
export class CustomerAccountComponent implements OnInit {
  customerId: string | null = null;
  accounts: GetCustomerAccountsByCustomerIdResponse[] = [];
  
  constructor(
    private customerAccountService: CustomerAccountService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.customerId = this.storageService.get('customerId');
    this.fethAccounts();
  }

  fethAccounts() {
    this.customerAccountService
      .getCustomerAccountsByCustomerId(Number(this.customerId))
      .subscribe({
        next: (response: GetCustomerAccountsByCustomerIdResponse[]) => {
          this.accounts = response;
        },
      });

    
  }

  toggleExpand(account: GetCustomerAccountsByCustomerIdResponse) {
    account.expanded = !account.expanded;
  }

  viewProduct(product: Product) {
  }

  deleteProduct(product: Product) {

  }
}
