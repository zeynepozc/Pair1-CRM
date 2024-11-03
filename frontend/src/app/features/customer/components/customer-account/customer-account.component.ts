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
  products: Product[];
  showDetails: boolean;
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
      products: [
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
      ],
      showDetails: false,
    },
    // Diğer hesaplar buraya eklenebilir
  ];

  pages = [1, 2, 3, 4];
  currentPage = 1;

  toggleDetails(account: Account) {
    console.log(account.showDetails);

    account.showDetails = !account.showDetails;
  }

  goToPage(page: number) {
    this.currentPage = page;
  }
}
