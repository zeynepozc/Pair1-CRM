import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { CustomerAccountCreateRequest } from '../models/customerAccountCreateRequest';
import { CustomerAccountCreateResponse } from '../models/customerAccountCreateResponse';
import { GetCustomerAccountsByCustomerIdResponse } from '../models/getCustomerAccountsByCustomerIdResponse';

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

  getCustomerAccountsByCustomerId(
    request: number
  ): Observable<GetCustomerAccountsByCustomerIdResponse[]> {
    return this.httpClient
      .get<GetCustomerAccountsByCustomerIdResponse[]>(
        `${this.controllerUrl}/customer/${request}`
      )
      .pipe(
        map((accounts: GetCustomerAccountsByCustomerIdResponse[]) =>
          accounts.map((account: GetCustomerAccountsByCustomerIdResponse) => ({
            ...account,
            expanded: false,
          }))
        )
      );
  }
}
