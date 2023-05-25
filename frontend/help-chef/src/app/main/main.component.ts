import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
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

