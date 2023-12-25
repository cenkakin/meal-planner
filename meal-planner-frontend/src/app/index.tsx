import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

import { useTranslation } from 'react-i18next';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers';
import 'dayjs/locale/de';
import { appRoutes } from './common/app-routes';
import { RequireAuth } from './common/component/RequireAuth';
import { Role } from './common/context/AuthProvider';

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
          {appRoutes.map(route =>
            route.requiresAuth ? (
                <Route path={route.path} element={
                  <RequireAuth allowedRoles={[Role.ROLE_USER]} children={route.element}/>
                } />
            ) : (
              <Route path={route.path} element={route.element} />
            ),
          )}
        </Routes>
      </BrowserRouter>
    </LocalizationProvider>
  );
}
