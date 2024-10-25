import { Component, inject, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { TokenResponse } from '../../../../shared/models/auth/loginResponse';
import { Router } from '@angular/router';
import { AuthService } from '../../../../shared/services/auth.service';
import { StorageService } from '../../../../shared/services/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent implements OnInit {
  form!: FormGroup;
  // Reactive Forms
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private storageService: StorageService
  ) {}
  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.form = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
      ]),
    });
  }

  submitForm() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      console.log('sasdasfasfsd');

      return;
    }
    // http isteği
    this.authService.login(this.form.value).subscribe({
      next: (response: TokenResponse) => {
        console.log('Giriş başarılı token alındı:', response);
        this.storageService.set('token', response.token);
        this.router.navigateByUrl('/customer/search-customer');
      },
    });
  }

  hasError(controlName: string) {
    return (
      !this.form.get(controlName)?.valid && this.form.get(controlName)?.touched
    );
  }

  get isFormValid() {
    return this.form.valid;
  }
}
