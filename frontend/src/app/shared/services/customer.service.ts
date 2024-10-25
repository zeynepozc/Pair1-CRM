import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { CustomerSearchRequest } from '../../features/customer/models/customerSearchRequest';
import { Observable } from 'rxjs';
import { CustomerSearchResponse } from '../../features/customer/models/customerSearchResponse';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/individualcustomer`;
  constructor(private httpClient: HttpClient) {}

  searchCustomer(searchRequest: CustomerSearchRequest): Observable<CustomerSearchResponse> {
    return this.httpClient.post<CustomerSearchResponse>(
      `${this.controllerUrl}/search`,
      searchRequest
    );
  }
}
