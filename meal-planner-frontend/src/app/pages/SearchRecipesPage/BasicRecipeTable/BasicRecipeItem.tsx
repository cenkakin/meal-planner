import { FSALights } from './FSALights';

export interface BasicRecipeItem {
  id: string;
  recipeImages: Array<string>;
  title: string;
  fsaLights: FSALights;
}
