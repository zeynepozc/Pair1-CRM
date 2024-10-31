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

  addresses: Address[] = [
    { title: 'Ev adresi', description: 'Caferağa Mah. Martı Sok. Deniz Apt. 23/11 Hacı Bakkal yanı, Kadıköy/Istanbul' },
    { title: 'Ev adresi2', description: 'Another Address' },
    { title: 'Is adresi', description: 'Work Address' }
  ];

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
}
