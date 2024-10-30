import { Component, OnInit } from '@angular/core';
import { CustomerSearchRequest } from '../../models/customerSearchRequest';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { CustomerSearchResponse } from '../../models/customerSearchResponse';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrl: './search-customer.component.scss',
})
export class SearchCustomerComponent implements OnInit {
  form!: FormGroup;
  searchData!: CustomerSearchResponse[];

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      natId: [null, []],
      customerId: [null, []],
      firstName: [null, []],
      lastName: [null, []],
      phoneNo: [null, [Validators.pattern(/^(\+?\d{1,3})?[-.\s]?\d{10}$/)]],
      email: [null, [Validators.email]],
      isActive: [null],
      createdDate: [null, []],
    });
  }
  submitForm(): void {
    console.log('submit');
    if (!this.form.valid) {
      console.log('not valid');

      return;
    }
    const isAnyFieldFilled = Object.values(this.form.controls).some(
      (control) =>
        control.value !== null &&
        control.value !== '' &&
        control.value !== false
    );

    if (!isAnyFieldFilled) {
      console.log('Lütfen en az bir alanı doldurun!');
      return;
    }

    console.log('Arama Verisi:', this.form.value);

    this.customerService
      .searchCustomer(this.form.value as CustomerSearchRequest)
      .subscribe({
        next: (response: CustomerSearchResponse[]) => {
          console.log(response);
          this.searchData = response;
        },
      });
  }

  clearForm() {
    console.log('clear');
    this.form.reset();
    this.searchData = [];
    console.log(this.searchData);
  }

  hasError(controlName: string) {
    return (
      !this.form.get(controlName)?.valid && this.form.get(controlName)?.touched
    );
  }
  isAnyFieldFilled(): boolean {
    return Object.values(this.form.value).some((value) => value);
  }

  get isFormValid() {
    return this.form.valid;
  }
}
