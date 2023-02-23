import * as React from 'react';
import { Button } from '@mui/material';
import httpClient from '../../../common/http-common';

export default function SearchRecipesButton({
  ingredientIds,
  onBasicRecipesChange,
}) {
  async function handleSearchRecipe() {
    await httpClient
      .get('/recipe/search?ingredientIds=' + ingredientIds)
      .then(response => onBasicRecipesChange(response.data.recipes))
      .catch(e => {
        throw e;
      });
  }

  return (
    <Button variant="contained" onClick={handleSearchRecipe}>
      Search
    </Button>
  );
}
