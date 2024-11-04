import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  lang!: string;
  constructor(private translateService: TranslateService) {}

  ngOnInit() {
    this.lang =
      this.translateService.currentLang || this.translateService.defaultLang;
  }

  changeLang() {
    this.translateService.use(this.lang);
  }
}
