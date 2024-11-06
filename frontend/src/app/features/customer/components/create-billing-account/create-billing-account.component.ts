import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StorageService } from '../../../../shared/services/storage.service';
import { CustomerAccountService } from '../../services/customer-account.service';
import { CustomerAccountCreateRequest } from '../../models/customerAccountCreateRequest';
import { CustomerAccountCreateResponse } from '../../models/customerAccountCreateResponse';
import { Router } from '@angular/router';
import { AddressService } from '../../services/address.service';
import { CustomerCreateAddressResponse } from '../../models/customerCreateAddressResponse';

@Component({
  selector: 'app-create-billing-account',
  templateUrl: './create-billing-account.component.html',
  styleUrl: './create-billing-account.component.scss',
})
export class CreateBillingAccountComponent {
  form!: FormGroup;
  customerId: string | null = null;
  addresses: CustomerCreateAddressResponse[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private customerAccountService: CustomerAccountService,
    private addressService: AddressService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.customerId = this.storageService.get('customerId');

    this.fetchAddresses();
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      accountStatus: ['Active', []],
      accountType: ['Billing Account', []],
      customerId: [this.customerId, []],
      accountName: [null, [Validators.required]],
      accountDescription: [null, [Validators.required]],
    });
  }

  fetchAddresses() {
    if (this.customerId != null) {
      this.addressService.getAddresses(Number(this.customerId)).subscribe({
        next: (response: CustomerCreateAddressResponse[]) => {
          this.addresses = response;
        },
      });
    }
  }

  concatenateAddressDetails(address: CustomerCreateAddressResponse): string {
    return ` ${address.description}, ${address.neighborhood}, ${address.houseNo} ${address.postalCode}, ${address.district}/${address.city}`;
  }

  submitForm() {
    if (!this.form.valid) {
      return;
    }
    this.customerAccountService
      .createCustomerAccount(this.form.value as CustomerAccountCreateRequest)
      .subscribe({
        next: (response: CustomerAccountCreateResponse) => {
          this.router.navigateByUrl(
            '/customer/create-customer/customer-account'
          );
        },
      });
  }

  get isFormValid() {
    return this.form.valid;
  }
}
