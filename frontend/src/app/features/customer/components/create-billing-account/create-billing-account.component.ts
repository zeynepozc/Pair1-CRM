import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StorageService } from '../../../../shared/services/storage.service';
import { CustomerAccountService } from '../../services/customer-account.service';
import { CustomerAccountCreateRequest } from '../../models/customerAccountcreateRequest';
import { CustomerAccountCreateResponse } from '../../models/customerAccountcreateResponse';

@Component({
  selector: 'app-create-billing-account',
  templateUrl: './create-billing-account.component.html',
  styleUrl: './create-billing-account.component.scss',
})
export class CreateBillingAccountComponent {
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private customerAccountService: CustomerAccountService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      accountName: [null, [Validators.required]],
      accontDescription: [null, [Validators.required]],
    });
  }

  submitForm() {
    console.log('Eklenecek Customer:', this.form.value);
    if (!this.form.valid) {
      return console.log('Not Valid');
    }
    this.customerAccountService
      .createCustomerAccount(this.form.value as CustomerAccountCreateRequest)
      .subscribe({
        next: (response: CustomerAccountCreateResponse) => {
          console.log(response);
          // this.storageService.set('customerId', response.id);
        },
      });
  }

  get isFormValid() {
    return this.form.valid;
  }
}
