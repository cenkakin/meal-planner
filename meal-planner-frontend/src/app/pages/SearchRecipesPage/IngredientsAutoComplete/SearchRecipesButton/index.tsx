import * as React from 'react';
import httpClient from '../../../../common/http-common';
import SearchIcon from '@mui/icons-material/Search';
import { IconButton } from '@mui/material';

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
    <IconButton onClick={handleSearchRecipe}>
      <SearchIcon />
    </IconButton>
  );
}
