import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
} from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { CustomerSearchRequest } from '../../models/customerSearchRequest';
import { CustomerCreateRequest } from '../../models/customerCreateRequest';
import { CustomerCreateResponse } from '../../models/customerCreateResponse';
import { IsCustomerExistsWithNatIDRequest } from '../../models/isCustomerExistsWithNatIDRequest';
import { IsCustomerExistsWithNatIDResponse } from '../../models/isCustomerExistsWithNatIDResponse';
import { StorageService } from '../../../../shared/services/storage.service';

@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrl: './customer-info.component.scss'
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
      natID: [null, [Validators.required]],
    });
  }

  submitForm() {
    console.log('Eklenecek Customer:', this.form.value);
    console.log(this.form);
    if (!this.form.valid) {
      return console.log('Not Valid');
    }
    this.customerService
      .createCustomer(this.form.value as CustomerCreateRequest)
      .subscribe({
        next: (response: CustomerCreateResponse) => {
          console.log(response);
          this.storageService.set('customerId', response.id);
          this.createData = response;
        },
      });
  }

  checkNatID(){
    if (!this.form.get('natID')?.valid) {
      return console.log('NatID empty');
    } 

    const natID = this.form.get('natID')?.value;
    const request: IsCustomerExistsWithNatIDRequest = { natID };

    this.customerService
      .isCustomerExistsWithNatID(request)
      .subscribe({
        next: (response: IsCustomerExistsWithNatIDResponse) => {
          console.log(response);
          this.natIDExists = response.isExists;
        },
      });
  }

  get isFormValid() {
    return this.form.valid;
  }

}
