import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { CustomerCreateRequest } from '../../models/customerCreateRequest';
import { CustomerCreateResponse } from '../../models/customerCreateResponse';
import { IsCustomerExistsWithNatIDRequest } from '../../models/isCustomerExistsWithNatIDRequest';
import { IsCustomerExistsWithNatIDResponse } from '../../models/isCustomerExistsWithNatIDResponse';
import { StorageService } from '../../../../shared/services/storage.service';

@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrl: './customer-info.component.scss',
})
export class CustomerInfoComponent {
  form!: FormGroup;
  createData!: CustomerCreateResponse;
  natIDExists!: Boolean;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private storageService: StorageService
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      firstName: [null, [Validators.required]],
      lastName: [null, [Validators.required]],
      middleName: [null, []],
      birthDate: [null, [Validators.required]],
      gender: [null, [Validators.required]],
      motherName: [null, [Validators.required]],
      fatherName: [null, [Validators.required]],
      natID: [null, [Validators.required, this.elevenDigitValidator]],
    });
  }

  elevenDigitValidator(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    const isValid = /^\d{11}$/.test(value);
    return isValid ? null : { elevenDigit: true };
  }

  submitForm() {
    if (!this.form.valid) {
      return;
    }
    this.customerService
      .createCustomer(this.form.value as CustomerCreateRequest)
      .subscribe({
        next: (response: CustomerCreateResponse) => {
          this.storageService.set('customerId', response.id);
          this.storageService.remove('addresses');
          this.createData = response;
        },
      });
  }

  checkNatID() {
    if (!this.form.get('natID')?.valid) {
      return;
    }

    const natID = this.form.get('natID')?.value;
    const request: IsCustomerExistsWithNatIDRequest = { natID };

    this.customerService.isCustomerExistsWithNatID(request).subscribe({
      next: (response: IsCustomerExistsWithNatIDResponse) => {
        this.natIDExists = response.isExists;
      },
    });
  }

  get isFormValid() {
    return this.form.valid;
  }
}
