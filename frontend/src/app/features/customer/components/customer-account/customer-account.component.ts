import { Component } from '@angular/core';

interface Account {
  status: string;
  number: string;
  name: string;
  type: string;
  expanded?: boolean; // to track if the account row is expanded
  offers?: Offer[]; // list of offers associated with the account
}

interface Offer {
  id: string;
  name: string;
  offerName: string;
  offerId: string;
  campaignName: string;
  campaignId: string;
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
      expanded: false,
    },
    {
      status: 'Active',
      number: '011112987',
      name: 'ExampleAccount',
      type: 'Billing Account',
      expanded: false,
    },
    // You can add more accounts here
  ];

  // Example offer data (this simulates an API response)
  allOffers: Offer[] = [
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
  ];

  toggleExpand(account: Account) {
    // Toggle the expanded state
    account.expanded = !account.expanded;

    // If expanded, fetch offers if they haven't been fetched yet
    if (account.expanded && !account.offers) {
      this.fetchOffers(account);
    }
  }

  fetchOffers(account: Account) {
    // Simulate an API call to fetch offers based on account number
    // In a real application, replace this with an actual HTTP call
    // For example: this.http.get<Offer[]>(`api/offers/${account.number}`).subscribe(offers => { ... });
    setTimeout(() => {
      account.offers = this.allOffers; // Simulating a response
    }, 1000); // Simulate a delay
  }

  viewOffer(offer: Offer) {
    console.log('Viewing offer:', offer);
    // Implement your view logic here, e.g., navigate to a detail page
  }

  deleteOffer(offer: Offer) {
    console.log('Deleting offer:', offer);
    // Implement your delete logic here, e.g., make an API call to delete the offer
    // Optionally, remove the offer from the account's offers list
  }
}
