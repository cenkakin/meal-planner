import { lazyLoad } from 'utils/loadable';

export const RecipeDetailsPage = lazyLoad(
  () => import('./index'),
  module => module.RecipeDetails,
);
