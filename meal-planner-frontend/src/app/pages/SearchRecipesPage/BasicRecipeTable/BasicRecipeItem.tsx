import { FSALights } from './FSALights';

export interface BasicRecipeItem {
  id: string;
  recipeImages: string[];
  title: string;
  fsaLights: FSALights;
}
