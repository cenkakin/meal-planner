import * as React from 'react';
import { SyntheticEvent, useState } from 'react';
import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import { IngredientAutocompleteItem } from './IngredientsAutoComplete/IngredientAutocompleteItem';
import IngredientsAutoComplete from './IngredientsAutoComplete';
import BasicRecipeTable from './BasicRecipeTable';
import { BasicRecipeItem } from './BasicRecipeTable/BasicRecipeItem';
import SearchRecipesButton from './SearchRecipesButton';

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

  async function onBasicRecipesChange(recipes) {
    setBasicRecipes(
      recipes.map(r => {
        let basicRecipeItem: BasicRecipeItem = {
          name: r.name,
          id: r.id,
          cuisine: r.cuisine,
        };
        return basicRecipeItem;
      }),
    );
  }

  return (
    <Grid2 container direction={'column'} style={{ paddingTop: 20 }}>
      <Helmet>
        <title>Search Recipes</title>
        <meta name="description" content="Find your recipes" />
      </Helmet>
      <Grid2 container direction={'row'}>
        <Grid2>
          <IngredientsAutoComplete
            onIngredientSelection={onIngredientSelection}
          />
        </Grid2>
        <Grid2>
          <SearchRecipesButton
            ingredientIds={ingredientIds}
            onBasicRecipesChange={onBasicRecipesChange}
          />
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
