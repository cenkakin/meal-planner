import { lazyLoad } from 'utils/loadable';

export const SearchRecipesPage = lazyLoad(
  () => import('./index'),
  module => module.SearchRecipes,
);
