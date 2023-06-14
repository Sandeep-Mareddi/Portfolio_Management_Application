import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ShareDetailsService } from '../../service/share-details.service';
import { UserData } from '../../ModelClass/userdata';
import { LoginServiceService } from 'src/app/service/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginForm = new FormGroup({});
  public errorMessage = '';
  constructor(private _loginFormBuilder: FormBuilder,
    private loginService: LoginServiceService,
    private _router: Router) {
  }

  ngOnInit(): void {
    this.loginForm = this._loginFormBuilder.group(
      {
        userid: ['', Validators.required],
        upassword: ['', Validators.required]
      }
    )
  }
  public loginUser(data: UserData) {
    // console.log('from login componenet ', data);
    this.loginService.loginUser(data).subscribe((response) => {
      // console.log(response);
      localStorage.setItem('token', response.authToken);
      localStorage.setItem('userid', response.userid);
      // console.log(localStorage.getItem('token'));
      console.log("User Logged IN Successfully!!!")
      this.redirectToNext();
    }, (error) => {
      console.log('error', error);
      this.errorMessage = error.error.message;
    });
  }

  redirectToNext() {
    this._router.navigate(['/home'])
  }


}

