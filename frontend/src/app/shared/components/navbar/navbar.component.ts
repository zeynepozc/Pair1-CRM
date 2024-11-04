import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  // lang: string = 'en'; // Varsayılan dil
  // constructor(private translateService: TranslateService) {}
  // ngOnInit() {
  //   // Eğer geçerli bir dil ayarı varsa onu kullan, yoksa varsayılanı ('en') kullan
  //   this.lang =
  //     this.translateService.currentLang ||
  //     this.translateService.defaultLang ||
  //     'en';
  //   // Dil ayarını TranslateService içinde kullan
  //   this.translateService.use(this.lang);
  // }
  // changeLang() {
  //   // Kullanıcı dili değiştirdiğinde yeni dili kullan
  //   if (this.lang) {
  //     this.translateService.use(this.lang);
  //   }
  // }
}
