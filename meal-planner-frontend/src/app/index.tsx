import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import { SearchRecipesPage } from './pages/SearchRecipesPage/Loadable';
import { useTranslation } from 'react-i18next';
import { RecipeDetailsPage } from './pages/RecipeDetailsPage/Loadable';

export function App() {
  const { i18n } = useTranslation();
  return (
    <BrowserRouter>
      <Helmet
        titleTemplate="%s - React Boilerplate"
        defaultTitle="React Boilerplate"
        htmlAttributes={{ lang: i18n.language }}
      >
        <meta name="description" content="A React Boilerplate application" />
      </Helmet>
      <Routes>
        <Route path="/" element={<SearchRecipesPage />} />
        <Route path="/recipe/:recipeId" element={<RecipeDetailsPage />} />
      </Routes>
    </BrowserRouter>
  );
}
