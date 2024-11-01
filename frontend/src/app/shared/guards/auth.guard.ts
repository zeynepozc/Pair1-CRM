import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { StorageService } from '../services/storage.service';

export const authGuard: CanActivateFn = (route, state) => {

  console.log('Guard kontrolü yapılıyor..');
  const router = inject(Router);
  const storageService = inject(StorageService);
  //token validasyonu yap
  const token = storageService.get('token');
  if (!token) {
    router.navigateByUrl('/user/login');
    return false;
  }
  return true;
};
