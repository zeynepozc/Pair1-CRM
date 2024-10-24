import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginRequest } from '../models/auth/loginRequest';
import { TokenResponse } from '../models/auth/loginResponse';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  // controllerUrl: string = `${environment.MS_V1_API_URL}/auth`;
  controllerUrl: string = 'localhost:8090/api/auth/login; // degistir
  constructor(private httpClient: HttpClient) {}

  login(loginRequest: LoginRequest): Observable<TokenResponse> {
    return this.httpClient.post<TokenResponse>(
      `${this.controllerUrl}/login`,
      loginRequest
    );
  }
}
