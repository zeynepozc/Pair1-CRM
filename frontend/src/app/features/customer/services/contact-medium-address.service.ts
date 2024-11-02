import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { ContactMediumAddressCreateRequest } from '../models/contactMediumAddressCreateRequest';
import { ContactMediumAddressCreateResponse } from '../models/contactMediumAddressCreateResponse';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ContactMediumAddressService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/contactmediumaddresses`;

  constructor(private httpClient: HttpClient) {}


  createContactMediumAddress(
    createRequest: ContactMediumAddressCreateRequest
  ): Observable<ContactMediumAddressCreateResponse>{
    return this.httpClient.post<ContactMediumAddressCreateResponse>(
      `${this.controllerUrl}`,
      createRequest
    );
  }
}
