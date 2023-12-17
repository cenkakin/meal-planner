import { LoginPage } from '../pages/LoginPage/Loadable';
import React, { ReactElement } from 'react';
import { SearchRecipesPage } from '../pages/SearchRecipesPage/Loadable';
import { RecipeDetailsPage } from '../pages/RecipeDetailsPage/Loadable';
import { CalendarPage } from '../pages/CalendarPage/Loadable';
import { IconTypeMap } from '@mui/material';
import RestaurantIcon from '@mui/icons-material/Restaurant';
import CalendarIcon from '@mui/icons-material/CalendarToday';

export const appRoutes: RouteDetails[] = [
  {
    path: '/',
    title: 'Search Recipes',
    key: 'searchRecipe',
    element: (
      <SearchRecipesPage
        title="Search Recipes"
        name="description"
        content="Search best recipes"
      />
    ),
    render: true,
    icon: <RestaurantIcon />,
  },
  {
    path: '/login',
    title: 'Login',
    key: 'login',
    element: <LoginPage title="Login" />,
    render: false,
  },
  {
    path: '/recipe/:recipeId',
    title: 'Recipe Details',
    key: 'recipeDetails',
    element: (
      <RecipeDetailsPage
        title="Recipe Details"
        name="description"
        content="Details"
      />
    ),
    render: false,
  },
  {
    path: '/calendar/:calendarId',
    title: 'Calendar',
    key: 'calendar',
    element: (
      <CalendarPage
        title="Calendar"
        name="description"
        content="Your meal calendar"
      />
    ),
    render: true,
    icon: <CalendarIcon />,
  },
];

interface RouteDetails {
  path: string;
  title: string;
  key: string;
  element: ReactElement;
  render: boolean;
  icon?: ReactElement;
}
