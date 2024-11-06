import { Router } from '@angular/router';
import { StorageService } from './../../services/storage.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  constructor(private storageService: StorageService, private router: Router) {}

  logout() {
    this.storageService.clear();
    this.router.navigateByUrl('/user/login');
  }
}
