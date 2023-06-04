import { Ingredient } from "./ingredient";

export interface Recipe {
    recipeId: number;
    recipeName: string;
    ingredients: Ingredient[];
    description: string;
    rate: number;
    commentId: number;
}