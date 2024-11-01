import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
} from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { CustomerCreateAddressResponse } from '../../models/customerCreateAddressResponse';
import { CustomerCreateAddressRequest } from '../../models/customerCreateAddressRequest';

interface Address {
  title: string;
  description: string;
}

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrl: './address.component.scss'
})
export class AddressComponent implements OnInit {
  form!: FormGroup;
  selectedTab: string = 'Address';
  isModalOpen: boolean = false;
  addedAddress!: CustomerCreateAddressResponse;
  addresses: CustomerCreateAddressResponse[] = [];
  

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService
  ) {}
  
  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      name: [null, [Validators.required]],
      district: [null, [Validators.required]],
      city: [null, [Validators.required]],
      description: [null, [Validators.required]],
      neighborhood: [null, [Validators.required]],
      houseNo: [null, [Validators.required]],
      postalCode: [null, [Validators.required]],
      customerId: [null,[]]
    });
  }

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
    this.resetNewAddress();
  }

  submitForm() {
    console.log('Eklenecek Address:', this.form.value);
    console.log(this.form);
    if (!this.form.valid) {
      return console.log('Not Valid');
    }
    this.customerService
      .createAddress(this.form.value as CustomerCreateAddressRequest)
      .subscribe({
        next: (response: CustomerCreateAddressResponse) => {
          console.log(response);
          this.addedAddress = response;
          this.addresses.push(this.addedAddress);
          this.closeModal();
        },
      });

    
  }

  concatenateAddressDetails(address: CustomerCreateAddressResponse): string {
    return `Address description: ${address.description},Neighborhood: ${address.neighborhood}, House/Flat Number: ${address.houseNo}, Postal Code: ${address.postalCode}, ${address.district}/${address.city}`;
  }

  resetNewAddress() {
    this.form.reset();
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
