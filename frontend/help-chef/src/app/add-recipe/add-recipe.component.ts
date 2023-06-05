import { Component, ElementRef, OnInit } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css'],
})
export class AddRecipeComponent {

  recipes: Recipe[];

  constructor(private elementRef: ElementRef, private recipeService: RecipeService, private router:Router) {}

  recipeDetails(recipeId: number){
    this.router.navigate(['recipeDetails', recipeId])
  }

  toggleNavbar(): void {
    const menu = this.elementRef.nativeElement.querySelector('.menu');
    const navbar = this.elementRef.nativeElement.querySelector('.navbar');
  
    menu.addEventListener('click', () => {
      navbar.classList.toggle('change');
    });
  }
  ngOnInit(): void {
    this.toggleNavbar();
    this.recipeService.getRecipes().subscribe((data: Recipe[]) => {
      console.log(data);
      this.recipes = data;
    });
  }
    
}
