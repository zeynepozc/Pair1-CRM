import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { CustomerService } from '../../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../models/customerSearchRequest';
import { CustomerCreateRequest } from '../../models/customerCreateRequest';
import { CustomerCreateResponse } from '../../models/customerCreateResponse';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrl: './create-customer.component.scss',
})
export class CreateCustomerComponent implements OnInit {
  form!: FormGroup;
  createData!: CustomerCreateResponse;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }
  
  buildForm(): void {
    this.form = this.formBuilder.group({
      firstName: [null, [Validators.required]],
      lastName: [null, [Validators.required]],
      middleName:[null, []],
      birthDate: [null, [Validators.required]],
      gender: [null, [Validators.required]],
      motherName: [null, [Validators.required]],
      fatherName:[null, [Validators.required]], 
      natID:[null, [Validators.required]],   
    });
  }

  submitForm() {
    console.log('Eklenecek Customer:', this.form.value);
    console.log(this.form)
    if (!this.form.valid) {
      return console.log("Not Valid");
      
    }
    this.customerService.createCustomer(this.form.value as CustomerCreateRequest).subscribe({
      next:(response: CustomerCreateResponse)=> {
        console.log(response);
        this.createData = response;
        
      }
    })
  }

  get isFormValid() {
    return this.form.valid;
  }
}






