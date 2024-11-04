import { Component } from '@angular/core';

interface Product {
  id: string;
  name: string;
  offerName: string;
  offerId: string;
  campaignName: string;
  campaignId: string;
}

interface Account {
  status: string;
  number: string;
  name: string;
  type: string;
}

@Component({
  selector: 'app-customer-account',
  templateUrl: './customer-account.component.html',
})
export class CustomerAccountComponent {
  accounts: Account[] = [
    {
      status: 'Active',
      number: '011112987',
      name: 'ExampleAccount',
      type: 'Billing Account',
    },
    // Other accounts can be added here
  ];

  // This will hold the fetched products for each account
  fetchedProducts: { [key: string]: Product[] } = {};
  
  selectedIndex: number | null = null; // Track the currently selected account index

  toggleDetails(index: number) {
    // Toggle the details for the clicked account
    if (this.selectedIndex === index) {
      this.selectedIndex = null; // Collapse if already selected
    } else {
      this.selectedIndex = index; // Set the index of the currently selected account
      
      const account = this.accounts[index];

      // Fetch products if not already fetched
      if (!this.fetchedProducts[account.number]) {
        this.fetchProducts(account.number).then(products => {
          this.fetchedProducts[account.number] = products;
        });
      }
    }
  }

  async fetchProducts(accountNumber: string): Promise<Product[]> {
    // Simulate a backend call
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve([
          {
            id: '001',
            name: 'ADSL 8MB',
            offerName: 'Her eve internet',
            offerId: '1',
            campaignName: 'Campaign 1',
            campaignId: '1',
          },
          {
            id: '002',
            name: 'ADSL Data Modem',
            offerName: 'Her eve internet',
            offerId: '1',
            campaignName: 'Campaign 1',
            campaignId: '1',
          },
        ]);
      }, 1000); // Simulate a network delay
    });
  }

  // Other methods can be added here
}
