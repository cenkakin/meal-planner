import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import { SearchRecipesPage } from './pages/SearchRecipesPage/Loadable';
import { useTranslation } from 'react-i18next';
import { RecipeDetailsPage } from './pages/RecipeDetailsPage/Loadable';
import { CalendarPage } from './pages/CalendarPage/Loadable';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers';
import 'dayjs/locale/de';
import { LoginPage } from './pages/LoginPage/Loadable';
import { appRoutes } from './common/app-routes';

export function App() {
  const { i18n } = useTranslation();

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs} adapterLocale="de">
      <BrowserRouter>
        <Helmet
          titleTemplate="%s - Meal Planner"
          defaultTitle="Meal Planner"
          htmlAttributes={{ lang: i18n.language }}
        >
          <meta name="description" content="A React Boilerplate application" />
        </Helmet>
        <Routes>
          {appRoutes.map(route => (
            <Route path={route.path} element={route.element} />
          ))}
        </Routes>
      </BrowserRouter>
    </LocalizationProvider>
  );
}
