import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { Button } from '@mui/material';
import { SyntheticEvent, useState } from 'react';
import httpClient from '../../common/http-common';
import BasicRecipeTable from '../../common/components/BasicRecipeTable';
import Grid2 from '@mui/material/Unstable_Grid2';
import { IngredientAutocompleteItem } from './IngredientsAutoComplete/IngredientAutocompleteItem';
import IngredientsAutoComplete from './IngredientsAutoComplete';

interface BasicRecipeItem {
  id: string;
  name: string;
  cuisine: string;
}

export function SearchRecipes() {
  const [ingredientIds, setIngredientIds] = useState<readonly String[]>([]);
  const [basicRecipes, setBasicRecipes] = useState<readonly BasicRecipeItem[]>(
    [],
  );

  function onIngredientSelection(
    e: SyntheticEvent,
    newValue: IngredientAutocompleteItem[],
  ) {
    const ingredientIds = newValue.map(ing => ing.id);
    setIngredientIds(ingredientIds);
  }

  async function handleSearchRecipe() {
    await httpClient
      .get('/recipe/search?ingredientIds=' + ingredientIds)
      .then(response =>
        setBasicRecipes(
          response.data.recipes.map(basicRecipe => {
            let basicRecipeItem: BasicRecipeItem = {
              name: basicRecipe.name,
              id: basicRecipe.id,
              cuisine: basicRecipe.cuisine,
            };
            return basicRecipeItem;
          }),
        ),
      )
      .catch(e => {
        throw e;
      });
  }

  return (
    <Grid2 container direction={'column'} style={{ paddingTop: 20 }}>
      <Helmet>
        <title>Search Recipes</title>
        <meta name="description" content="Find your recipes" />
      </Helmet>
      <Grid2 container direction={'row'}>
        <Grid2>
          <IngredientsAutoComplete onIngredientSelection={onIngredientSelection}/>
        </Grid2>
        <Grid2>
          <Button variant="contained" onClick={handleSearchRecipe}>
            Search
          </Button>
        </Grid2>
      </Grid2>
      <Grid2>
        {basicRecipes.length > 0 && (
          <BasicRecipeTable inputData={basicRecipes} />
        )}
      </Grid2>
    </Grid2>
  );
}
