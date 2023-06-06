import { Component, ElementRef } from '@angular/core';
import { RecipeService } from '../recipe.service';
import { Recipe } from '../recipe';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent {

  recipeById: Recipe;
  recipeId: number;

  constructor(private elementRef: ElementRef, private route: ActivatedRoute, private recipeService: RecipeService) {}

  toggleNavbar(): void {
    const menu = this.elementRef.nativeElement.querySelector('.menu');
    const navbar = this.elementRef.nativeElement.querySelector('.navbar');
  
    menu.addEventListener('click', () => {
      navbar.classList.toggle('change');
    });
  }
  ngOnInit(): void {
    this.toggleNavbar();
    
    this.recipeId = this.route.snapshot.params['recipeId'];
    this.recipeById = new Recipe();
    this.recipeService.getRecipeById(this.recipeId).subscribe(data => {
      this.recipeById = data;
    })
  }

}
