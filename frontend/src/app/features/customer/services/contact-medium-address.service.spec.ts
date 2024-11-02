import { TestBed } from '@angular/core/testing';

import { ContactMediumAddressService } from './contact-medium-address.service';

describe('ContactMediumAddressService', () => {
  let service: ContactMediumAddressService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactMediumAddressService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
