import { Component, ElementRef } from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private elementRef: ElementRef) {}

  toggleNavbar(): void {
    const menu = this.elementRef.nativeElement.querySelector('.menu');
    const navbar = this.elementRef.nativeElement.querySelector('.navbar');
  
    menu.addEventListener('click', () => {
      navbar.classList.toggle('change');
    });
  }
  ngOnInit(): void {
    this.toggleNavbar();
  }
    
}
