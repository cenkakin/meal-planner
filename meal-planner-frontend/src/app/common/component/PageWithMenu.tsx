import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import LeftMenuWithNavigation from './LeftMenuWithNavigation';
import { appRoutes } from '../app-routes';
import IngredientsAutoComplete from '../../pages/SearchRecipesPage/IngredientsAutoComplete';
import { DatePicker } from '@mui/x-date-pickers';
import dayjs from 'dayjs';
import { Alert, Button, Snackbar } from '@mui/material';
import BasicRecipeTable from '../../pages/SearchRecipesPage/BasicRecipeTable';
import * as React from 'react';

interface Props {
  children: React.ReactElement;
  helmetTitle: string;
  helmetName: string;
  helmetContent: string;
}

export default function PageWithMenu({
  children,
  helmetTitle,
  helmetName,
  helmetContent,
}: Props) {
  return (
    <Grid2 container justifyContent="center" marginTop={10} spacing={5}>
      <Helmet>
        <title>{helmetTitle}</title>
        <meta name={helmetName} content={helmetContent} />
      </Helmet>
      <Grid2 xs={2}>
        <LeftMenuWithNavigation routes={appRoutes} />
      </Grid2>
      <Grid2 xs={10}>{children}</Grid2>
    </Grid2>
  );
}
