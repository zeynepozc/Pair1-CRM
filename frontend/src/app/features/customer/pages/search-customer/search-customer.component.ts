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

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrl: './search-customer.component.scss',
})
export class SearchCustomerComponent implements OnInit {
  form!: FormGroup;
  searchData!: CustomerSearchRequest;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.form = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
      ]),
    });
  }
}
