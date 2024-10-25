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
import { CustomerService } from '../../../../shared/services/customer.service';
import { CustomerSearchResponse } from '../../models/customerSearchResponse';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrl: './search-customer.component.scss',
})
export class SearchCustomerComponent implements OnInit {
  form!: FormGroup;
  searchData!: CustomerSearchRequest;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      natId: ['', []], 
      customerId: [null, []], 
      firstName: ['', []], 
      lastName: ['', []],
      phoneNo: new FormControl('', Validators.pattern(/^(\+?\d{1,3})?[-.\s]?\d{10}$/)), 
      email: new FormControl('', [Validators.email]), 
      isActive: [false, []], 
      createdDate: [null, []] 
    });
  }
  submitForm(): void {
    console.log("submit");
    if (!this.form.valid) {
      console.log('not valid');

      return;
    }
    // en az bir alan dolacak
    const isAnyFieldFilled = Object.values(this.form.controls).some(
      (control) => control.value !== null && control.value !== '' && control.value !== false
    );
  
    if (!isAnyFieldFilled) {
      console.log('Lütfen en az bir alanı doldurun!');
      return;
    }
    
    this.searchData = this.form.value as CustomerSearchRequest;

    console.log('Arama Verisi:', this.searchData);
  
    this.customerService.searchCustomer(this.searchData).subscribe({
      next:(response:CustomerSearchResponse)=> {
        console.log("Başarılı");
        console.log(response);
        
      }
    })
  }

  hasError(controlName: string) {
    return (
      !this.form.get(controlName)?.valid && this.form.get(controlName)?.touched
    );
  }
  
  get isFormValid() {
    return this.form.valid;
  }
  
}
