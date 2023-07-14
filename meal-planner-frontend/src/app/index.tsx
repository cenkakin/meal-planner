import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import { SearchRecipesPage } from './pages/SearchRecipesPage/Loadable';
import { useTranslation } from 'react-i18next';
import { RecipeDetailsPage } from './pages/RecipeDetailsPage/Loadable';
import { CalendarPage } from './pages/CalendarPage/Loadable';
import PermanentDrawerLeft from './common/component/PermanentLeftDrawer';

export function App() {
  const { i18n } = useTranslation();
  return (
    <BrowserRouter>
      <Helmet
        titleTemplate="%s - Meal Planner"
        defaultTitle="Meal Planner"
        htmlAttributes={{ lang: i18n.language }}
      >
        <meta name="description" content="A React Boilerplate application" />
      </Helmet>
      <PermanentDrawerLeft
        routes={
          <Routes>
            <Route
              path="/"
              element={<SearchRecipesPage title="Search Recipes" />}
            />
            <Route
              path="/recipe/:recipeId"
              element={<RecipeDetailsPage title="Recipe Details" />}
            />
            <Route
              path="/calendar/:calendarId"
              element={<CalendarPage title="Calendar" />}
            />
          </Routes>
        }
      />
    </BrowserRouter>
  );
}
