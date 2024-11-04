import { TestBed } from '@angular/core/testing';

import { CustomerAccountService } from './customer-account.service';

describe('CustomerAccountService', () => {
  let service: CustomerAccountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerAccountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
