import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CustomerAccountCreateRequest } from '../models/customerAccountcreateRequest';
import { CustomerAccountCreateResponse } from '../models/customerAccountcreateResponse';

@Injectable({
  providedIn: 'root',
})
export class CustomerAccountService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/customeraccounts`;

  constructor(private httpClient: HttpClient) {}

  createCustomerAccount(
    createRequest: CustomerAccountCreateRequest
  ): Observable<CustomerAccountCreateResponse> {
    return this.httpClient.post<CustomerAccountCreateResponse>(
      `${this.controllerUrl}`,
      createRequest
    );
  }
}
