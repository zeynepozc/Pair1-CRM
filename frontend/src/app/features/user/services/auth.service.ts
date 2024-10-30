import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginRequest } from '../../../shared/models/auth/loginRequest';
import { TokenResponse } from '../../../shared/models/auth/loginResponse';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  controllerUrl: string = `${environment.MS_V1_API_URL}/auth`;
  constructor(private httpClient: HttpClient) {}

  login(loginRequest: LoginRequest): Observable<TokenResponse> {
    return this.httpClient.post<TokenResponse>(
      `${this.controllerUrl}/login`,
      loginRequest
    );
  }
}
