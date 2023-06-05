import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe } from './recipe';

@Injectable({
    providedIn: 'root'
})

export class RecipeService {
    
    private baseUrl = 'http://localhost:9000/api/recipes';
    
    constructor(private http: HttpClient) { }

    getRecipes(): Observable<Recipe[]>{
        return this.http.get<Recipe[]>(`${this.baseUrl}`);
    }

    getRecipeById(recipeId: number): Observable<Recipe>{
        return this.http.get<Recipe>(`${this.baseUrl}/${recipeId}`);
    }
}