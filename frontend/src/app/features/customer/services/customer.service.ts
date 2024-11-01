import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { CustomerSearchRequest } from '../models/customerSearchRequest';
import { Observable } from 'rxjs';
import { CustomerSearchResponse } from '../models/customerSearchResponse';
import { CustomerCreateRequest } from '../models/customerCreateRequest';
import { CustomerCreateResponse } from '../models/customerCreateResponse';
import { CustomerCreateAddressRequest } from '../models/customerCreateAddressRequest';
import { CustomerCreateAddressResponse } from '../models/customerCreateAddressResponse';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/individualcustomers`;
  addressControllerUrl: string = `${environment.MS_V1_API_URL}/addresses`;
  
  constructor(private httpClient: HttpClient) {}

  searchCustomer(
    searchRequest: CustomerSearchRequest
  ): Observable<CustomerSearchResponse[]> {
    return this.httpClient.post<CustomerSearchResponse[]>(
      `${this.controllerUrl}/search`,
      searchRequest
    );
  }

  createCustomer(
    createRequest: CustomerCreateRequest
  ): Observable<CustomerCreateResponse> {
    return this.httpClient.post<CustomerCreateResponse>(
      `${this.controllerUrl}`,
      createRequest
    );
  }

  createAddress(
    createRequest: CustomerCreateAddressRequest
  ): Observable<CustomerCreateAddressResponse>{
    return this.httpClient.post<CustomerCreateAddressResponse>(
      `${this.addressControllerUrl}`,
      createRequest
    );
  }
}
