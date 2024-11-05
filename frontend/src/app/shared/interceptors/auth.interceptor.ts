import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { finalize, catchError } from 'rxjs';
import { StorageService } from '../services/storage.service';
import { TranslateService } from '@ngx-translate/core';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const storageService = inject(StorageService);
  const translateService = inject(TranslateService);

  req = req.clone({
    setHeaders: {
      Authorization: `Bearer ${storageService.get('token')}`,
      //'Accept-Language':
        //translateService.currentLang || translateService.defaultLang,
    },
  });

  return next(req).pipe(
    finalize(() => {
    }),
    catchError((err) => {
      throw err.error.message;
    })
  );
};
