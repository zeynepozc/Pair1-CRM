import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
} from '@angular/forms';
import { CustomerCreateAddressResponse } from '../../models/customerCreateAddressResponse';
import { CustomerCreateAddressRequest } from '../../models/customerCreateAddressRequest';
import { AddressService } from '../../services/address.service';
import { StorageService } from '../../../../shared/services/storage.service';
import { AddressForStorage } from '../../models/addressForStorage';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrl: './address.component.scss',
})
export class AddressComponent implements OnInit {
  form!: FormGroup;
  customerId: string | null = null;
  isModalOpen: boolean = false;
  addedAddress!: CustomerCreateAddressResponse;
  addresses: CustomerCreateAddressResponse[] = [];
  addressList: AddressForStorage[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private addressService: AddressService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      primaryAddress: [false],
      name: [null, [Validators.required]],
      district: [null, [Validators.required]],
      city: [null, [Validators.required]],
      description: [null, [Validators.required]],
      neighborhood: [null, [Validators.required]],
      houseNo: [null, [Validators.required]],
      postalCode: [null, [Validators.required]],
      customerId: [this.customerId, []],
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
    this.form
      .get('customerId')
      ?.setValue(this.storageService.get('customerId'));
    if (!this.form.valid) {
      return;
    }
    this.addressService
      .createAddress(this.form.value as CustomerCreateAddressRequest)
      .subscribe({
        next: (response: CustomerCreateAddressResponse) => {
          this.addedAddress = response;
          this.addresses.push(this.addedAddress);

          const address: AddressForStorage = {
            id: response.id,
            primaryAddress: response.primaryAddress,
          };
          this.addressList.push(address);
          this.storageService.set(
            'addresses',
            JSON.stringify(this.addressList)
          );
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
  goToPreviousPage() {}

  goToNextPage() {}
}
