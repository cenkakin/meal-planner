import Autocomplete from '@mui/material/Autocomplete';
import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { TextField } from '@mui/material';

const options = [
  { label: 'Apple', id: 1 },
  { label: 'Orange', id: 2 },
];

export function SearchRecipes() {
  return (
    <>
      <Helmet>
        <title>Search Recipes</title>
        <meta name="description" content="Find your recipes" />
      </Helmet>
      <Autocomplete
        disablePortal
        id="combo-box-demo"
        options={options}
        sx={{ width: 300 }}
        renderInput={params => <TextField {...params} label="Ingredient" />}
      />
    </>
  );
}
