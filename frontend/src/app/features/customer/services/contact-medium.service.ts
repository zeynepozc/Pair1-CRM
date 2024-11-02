import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomerCreateContactMediumRequest } from '../models/customerCreateContactMediumRequest';
import { CustomerCreateContactMediumResponse } from '../models/customerCreateContactMediumResponse';
import { IsContactMediumExistsWithEmailRequest } from '../models/isContactMediumExistsWithEmailRequest';
import { IsContactMediumExistsWithEmailResponse } from '../models/isContactMediumExistsWithEmailResponse';
import { IsContactMediumExistsWithMobilePhoneRequest } from '../models/isContactMediumExistsWithMobilePhone';
import { IsContactMediumExistsWithMobilePhoneResponse } from '../models/isContactMediumExistsWithMobilePhoneResponse';

@Injectable({
  providedIn: 'root'
})
export class ContactMediumService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/contactmediums`;
  
  constructor(private httpClient: HttpClient) {}

  createContactMedium(
    createRequest: CustomerCreateContactMediumRequest
  ): Observable<CustomerCreateContactMediumResponse>{
    return this.httpClient.post<CustomerCreateContactMediumResponse>(
      `${this.controllerUrl}`,
      createRequest
    );
  }

  isContactMediumExistsWithEmail(
    request: IsContactMediumExistsWithEmailRequest
  ): Observable<IsContactMediumExistsWithEmailResponse>{
    return this.httpClient.post<IsContactMediumExistsWithEmailResponse>(
      `${this.controllerUrl}/isContactMediumExistsWithEmail`,
      request
    );
  }

  isContactMediumExistsWithMobilePhone(
    request: IsContactMediumExistsWithMobilePhoneRequest
  ): Observable<IsContactMediumExistsWithMobilePhoneResponse>{
    return this.httpClient.post<IsContactMediumExistsWithMobilePhoneResponse>(
      `${this.controllerUrl}/isContactMediumExistsWithMobilePhone`,
      request
    );
  }
}
