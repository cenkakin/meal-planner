import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import { useEffect, useState } from 'react';
import httpClient from '../../common/http-common';
import { useLocation, useParams } from 'react-router-dom';
import { Recipe } from './RecipeDetailsView/Recipe';

export function RecipeDetails() {
  const [recipe, setRecipe] = useState<Recipe>();
  const { recipeId } = useParams();

  useEffect(() => {
    const fetchRecipe = async () => {
      const { data: response } = await httpClient.get('/recipe/' + recipeId);
      const recipeItem: Recipe = {
        id: response.id,
        name: response.name,
        cuisine: response.cuisine,
        recipeIngredients: response.recipeIngredients,
      };
      setRecipe(recipeItem);
    };
    fetchRecipe();
  }, []);

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
        <title>Recipe Details</title>
        <meta name="description" content="Discover recipes" />
      </Helmet>
      <Grid2 xs={8}>
        {recipe?.name}
        {recipe?.recipeIngredients.map(ingredient => (
          <li key={ingredient.ingredient.id}>
            {ingredient.ingredient.name} - {ingredient.quantity} -{' '}
            {ingredient.ingredient.unit}
          </li>
        ))}
      </Grid2>
    </Grid2>
  );
}
