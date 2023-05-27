import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

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
