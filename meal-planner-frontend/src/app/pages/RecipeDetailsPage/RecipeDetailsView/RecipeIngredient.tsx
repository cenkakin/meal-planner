import { Ingredient } from './Ingredient';

export interface RecipeIngredient {
  ingredient: Ingredient;
  quantity: number;
  unit: string;
  weightInGram: number;
}
