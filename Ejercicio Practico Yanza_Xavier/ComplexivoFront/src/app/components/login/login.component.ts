import { AbstractType,Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../../models/usuario';
import { LoginService } from '../../services/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  tokenusuario: Usuario;
  user: any = {
    username: '',
    contrasena: '',
    token: '',
  };

  tkn: any;

  constructor(private usuario: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.usuario
      .login(this.user.username, this.user.contrasena)
      .subscribe((data) => {
        console.log(data);
        this.tokenusuario = data;
        localStorage.setItem('token', this.tokenusuario.token);
        this.router.navigate(['/listar']);
      });
  }

}
