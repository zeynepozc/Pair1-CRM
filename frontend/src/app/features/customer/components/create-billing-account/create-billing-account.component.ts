import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StorageService } from '../../../../shared/services/storage.service';
import { CustomerAccountService } from '../../services/customer-account.service';
import { CustomerAccountCreateRequest } from '../../models/customerAccountCreateRequest';
import { CustomerAccountCreateResponse } from '../../models/customerAccountCreateResponse';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-billing-account',
  templateUrl: './create-billing-account.component.html',
  styleUrl: './create-billing-account.component.scss',
})
export class CreateBillingAccountComponent {
  form!: FormGroup;
  customerId: string | null = null;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private customerAccountService: CustomerAccountService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.customerId = this.storageService.get('customerId');
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
