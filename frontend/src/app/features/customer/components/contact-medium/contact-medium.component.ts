import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ContactMediumService } from '../../services/contact-medium.service';
import { CustomerCreateContactMediumRequest } from '../../models/customerCreateContactMediumRequest';
import { CustomerCreateContactMediumResponse } from '../../models/customerCreateContactMediumResponse';
import { IsContactMediumExistsWithEmailRequest } from '../../models/isContactMediumExistsWithEmailRequest';
import { IsContactMediumExistsWithEmailResponse } from '../../models/isContactMediumExistsWithEmailResponse';
import { IsContactMediumExistsWithMobilePhoneRequest } from '../../models/isContactMediumExistsWithMobilePhone';
import { IsContactMediumExistsWithMobilePhoneResponse } from '../../models/isContactMediumExistsWithMobilePhoneResponse';
import { StorageService } from '../../../../shared/services/storage.service';
import { ContactMediumAddressCreateRequest } from '../../models/contactMediumAddressCreateRequest';
import { ContactMediumAddressService } from '../../services/contact-medium-address.service';

@Component({
  selector: 'app-contact-medium',
  templateUrl: './contact-medium.component.html',
  styleUrl: './contact-medium.component.scss',
})
export class ContactMediumComponent {
  form!: FormGroup;
  customerId: string | null = null;
  emailExist!: Boolean;
  mobilePhoneExist!: Boolean;
  addedContactMedium!: CustomerCreateContactMediumResponse;

  constructor(
    private formBuilder: FormBuilder,
    private contactMediumService: ContactMediumService,
    private storageService: StorageService,
    private contactMediumAddressService: ContactMediumAddressService
  ) {}

  ngOnInit(): void {
    this.customerId = this.storageService.get('customerId');

    this.buildForm();
  }

  buildForm(): void {
    this.form = this.formBuilder.group({
      email: [null, [Validators.email, Validators.required]],
      mobilePhone: [
        null,
        [
          Validators.pattern(/^(\+?\d{1,3})?[-.\s]?\d{10}$/),
          Validators.required,
        ],
      ],
      homePhone: [null, []],
      fax: [null, []],
      customerId: [this.customerId, []],
    });
  }

  checkEmail() {
    if (!this.form.get('email')?.valid) {
      return;
    }

    const email = this.form.get('email')?.value;
    const request: IsContactMediumExistsWithEmailRequest = { email };

    this.contactMediumService
      .isContactMediumExistsWithEmail(request)
      .subscribe({
        next: (response: IsContactMediumExistsWithEmailResponse) => {
          this.emailExist = response.exists;
        },
      });
  }

  checkMobilePhone() {
    if (!this.form.get('mobilePhone')?.valid) {
      return;
    }
    const mobilePhone = this.form.get('mobilePhone')?.value;
    const request: IsContactMediumExistsWithMobilePhoneRequest = {
      mobilePhone,
    };

    this.contactMediumService
      .isContactMediumExistsWithMobilePhone(request)
      .subscribe({
        next: (response: IsContactMediumExistsWithMobilePhoneResponse) => {
          this.mobilePhoneExist = response.exists;
        },
      });
  }

  submitForm() {
    if (!this.form.valid) {
      return;
    }
    this.contactMediumService
      .createContactMedium(
        this.form.value as CustomerCreateContactMediumRequest
      )
      .subscribe({
        next: (response: CustomerCreateContactMediumResponse) => {
          this.addedContactMedium = response;
          this.addContactMediumAddresses();
        },
      });
  }

  addContactMediumAddresses() {
    const storedAddresses = localStorage.getItem('addresses');
    const addresses: { id: number; primaryAddress: boolean }[] = storedAddresses
      ? JSON.parse(storedAddresses)
      : [];

    const requests: ContactMediumAddressCreateRequest[] = addresses.map(
      (address) => ({
        contactMediumId: this.addedContactMedium.id,
        contactAddressId: address.id,
        primaryAddress: address.primaryAddress,
      })
    );

    requests.forEach((request) => {
      this.contactMediumAddressService
        .createContactMediumAddress(request)
        .subscribe({
          next: (response) => {
          },
        });
    });
    this.storageService.remove('addresses');
  }
}
