import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  // lang: string = 'en';
  // constructor(private translateService: TranslateService) {}
  // ngOnInit() {
  //   this.lang =
  //     this.translateService.currentLang ||
  //     this.translateService.defaultLang ||
  //     'en';
  //   this.translateService.use(this.lang);
  // }
  // changeLang() {
  //   if (this.lang) {
  //     this.translateService.use(this.lang);
  //   }
  // }
}
