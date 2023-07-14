import * as React from 'react';
import { useState } from 'react';
import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import IngredientsAutoComplete from './IngredientsAutoComplete';
import BasicRecipeTable from './BasicRecipeTable';
import { BasicRecipeItem } from './BasicRecipeTable/BasicRecipeItem';

export function SearchRecipes(props) {
  const [basicRecipes, setBasicRecipes] = useState<Array<BasicRecipeItem>>([]);

  async function onBasicRecipesChange(recipes) {
    setBasicRecipes(
      recipes.map(r => {
        return {
          title: r.title,
          id: r.id,
          recipeImages: r.recipeImages,
          fsaLights: r.fsaLights,
        };
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
        <title>{props.title}</title>
        <meta name="description" content="Find your recipes" />
      </Helmet>
      <Grid2 xs={4}>
        <IngredientsAutoComplete onBasicRecipesChange={onBasicRecipesChange} />
      </Grid2>
      <Grid2 xs={10}>
        {basicRecipes.length > 0 && <BasicRecipeTable recipes={basicRecipes} />}
      </Grid2>
    </Grid2>
  );
}
