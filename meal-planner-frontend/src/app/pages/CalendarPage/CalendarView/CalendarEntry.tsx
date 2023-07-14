import { Recipe } from '../../RecipeDetailsPage/RecipeDetailsView/Recipe';

export interface CalendarEntry {
  date: string;
  entries: [Recipe];
}
