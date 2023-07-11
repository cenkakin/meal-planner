import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import { useEffect, useState } from 'react';
import httpClient from '../../common/http-common';
import { useParams } from 'react-router-dom';
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
        instructions: response.instructions,
        recipeImages: response.recipeImages,
      };
      setRecipe(recipeItem);
    };
    fetchRecipe();
  }, [recipeId]);

  return (
    <Grid2
      container
      direction={'column'}
      justifyContent="center"
      alignItems="center"
      marginTop={10}
      spacing={5}
      xs={10}
    >
      <Helmet>
        <title>Recipe Details </title>
        <meta name="description" content="Discover recipes" />
      </Helmet>
      <Grid2 xs={8}>
        <h2>
          {recipe?.name}:{' '}
          {recipe?.recipeIngredients
            .map(
              ingredient =>
                (ingredient.weightInGram * ingredient.ingredient.energy) / 100,
            )
            .reduce((prelim, a) => prelim + a, 0).toFixed(0)} Calories
        </h2>
        <ImageList variant={'quilted'} cols={5} gap={8}>
          {recipe != null}  {recipe?.recipeImages.map(url => (
            <ImageListItem>
              <img
                src={url}
                alt={""}
              />
            </ImageListItem>
          ))}
        </ImageList>
      </Grid2>
      <Grid2
        xs={8}
        direction={'row'}
        container
        justifyContent="center"
        alignItems="flex-start"
      >
        <Grid2 xs={4}>
          <h3>Ingredients:</h3>
          {recipe?.recipeIngredients.map(ingredient => (
            <li key={ingredient.ingredient.id}>
              {ingredient.ingredient.name} ({ingredient.quantity} {ingredient.unit})
            </li>
          ))}
        </Grid2>
        <Grid2 xs={8}>
          <h3>Instructions:</h3>
          {recipe?.instructions.map(step => (
            <li>{step}</li>
          ))}
        </Grid2>
      </Grid2>
    </Grid2>
  );
}
