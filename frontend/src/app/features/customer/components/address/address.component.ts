import { Component } from '@angular/core';

interface Address {
  title: string;
  description: string;
}

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrl: './address.component.scss'
})
export class AddressComponent {
  selectedTab: string = 'Address';
  isModalOpen: boolean = false;

  addresses!: Address[];

  newAddress = { name: '', street: '', city: '', description: '' };

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.resetNewAddress();
  }

  addAddress() {
    this.addresses.push({ title: this.newAddress.name, description: this.newAddress.description });
    this.closeModal();
  }

  resetNewAddress() {
    this.newAddress = { name: '', street: '', city: '', description: '' };
  }

  selectTab(tab: string) {
    this.selectedTab = tab;
  }
  goToPreviousPage() {
    // Logic to go to the previous page or section
    console.log("Going to previous page...");
  }
  
  goToNextPage() {
    // Logic to go to the next page or section
    console.log("Going to next page...");
  }
}
