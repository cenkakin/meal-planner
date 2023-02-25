import * as React from 'react';
import { useState } from 'react';
import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import IngredientsAutoComplete from './IngredientsAutoComplete';
import BasicRecipeTable from './BasicRecipeTable';
import { BasicRecipeItem } from './BasicRecipeTable/BasicRecipeItem';

export function SearchRecipes() {
  const [basicRecipes, setBasicRecipes] = useState<readonly BasicRecipeItem[]>(
    [],
  );

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
    <Grid2
      container
      direction={'column'}
      justifyContent="center"
      alignItems="center"
      marginTop={10}
      spacing={5}
    >
      <Helmet>
        <title>Search Recipes</title>
        <meta name="description" content="Find your recipes" />
      </Helmet>
      <Grid2 xs={8}>
        <IngredientsAutoComplete onBasicRecipesChange={onBasicRecipesChange} />
      </Grid2>
      <Grid2 xs={8}>
        {basicRecipes.length > 0 && (
          <BasicRecipeTable inputData={basicRecipes} />
        )}
      </Grid2>
    </Grid2>
  );
}
