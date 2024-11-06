import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { CustomerCreateAddressRequest } from '../models/customerCreateAddressRequest';
import { CustomerCreateAddressResponse } from '../models/customerCreateAddressResponse';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AddressService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/addresses`;

  constructor(private httpClient: HttpClient) {}

  createAddress(
    createRequest: CustomerCreateAddressRequest
  ): Observable<CustomerCreateAddressResponse> {
    return this.httpClient.post<CustomerCreateAddressResponse>(
      `${this.controllerUrl}`,
      createRequest
    );
  }

  getAddresses(id: number): Observable<CustomerCreateAddressResponse[]> {
    return this.httpClient.get<CustomerCreateAddressResponse[]>(
      `${this.controllerUrl}/${id}`
    );
  }
}
