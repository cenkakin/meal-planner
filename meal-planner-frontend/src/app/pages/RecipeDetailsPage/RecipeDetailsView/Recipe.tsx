import { RecipeIngredient } from './RecipeIngredient';

export interface Recipe {
  id: string;
  name: string;
  cuisine: string;
  recipeIngredients: RecipeIngredient[];
  instructions: string[];
  recipeImages: string[];
}
