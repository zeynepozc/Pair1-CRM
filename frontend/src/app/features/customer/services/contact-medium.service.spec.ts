import { TestBed } from '@angular/core/testing';

import { ContactMediumService } from './contact-medium.service';

describe('ContactMediumService', () => {
  let service: ContactMediumService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactMediumService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
