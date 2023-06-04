import { Ingredient } from "./ingredient";

export interface Recipe {
    recipeId: number;
    recipeName: string;
    ingredients: Ingredient[];
    description: string;
    rate: number;
    comment: {
        commentId: number;
        nick: {
            userId: number;
            email: string;
            name: string;
            surname: string;
            nick: string;
        };
        content: string;
        commentDate: string;
    };
}