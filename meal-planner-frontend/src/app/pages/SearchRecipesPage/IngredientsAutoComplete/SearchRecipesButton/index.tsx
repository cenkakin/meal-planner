import * as React from 'react';
import SearchIcon from '@mui/icons-material/Search';
import { IconButton } from '@mui/material';
import useAxios from '../../../../common/hooks/useAxios';

export default function SearchRecipesButton({
  ingredientIds,
  onBasicRecipesChange,
}) {
  const httpClient = useAxios();
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
