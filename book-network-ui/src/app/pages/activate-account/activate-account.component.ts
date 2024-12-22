import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/services/authentication.service";

@Component({
  selector: 'app-activate-account',
  templateUrl: './activate-account.component.html',
  styleUrls: ['./activate-account.component.scss']
})
export class ActivateAccountComponent {


  message: string = '';
  isOkay = true;
  isSubmitted = false;

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) {

  }

  onCodeCompleted(token: string) {
    this.confirmAccount(token);
  }

  redirectToLogin() {
    this.router.navigate(['login']);
  }

  private confirmAccount(token: string) {
    this.authService.activateAccount({
      token
    }).subscribe({
      next: () => {
        this.message = "Your account has been successfully activated.\nNow you can proceed to login";
        this.isSubmitted = true;
        this.isOkay = true;
      },
      error: () => {
        this.message = "Token has been expired.";
        this.isSubmitted = true;
        this.isOkay = false;
      }
    })
  }
}
