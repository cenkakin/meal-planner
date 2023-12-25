import * as React from 'react';
import { useEffect, useState } from 'react';
import Grid2 from '@mui/material/Unstable_Grid2';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import { useParams } from 'react-router-dom';
import { Recipe } from './RecipeDetailsView/Recipe';
import PageWithMenu from '../../common/component/PageWithMenu';
import useAxios from '../../common/hooks/useAxios';

export function RecipeDetails(props) {
  const [recipe, setRecipe] = useState<Recipe>();
  const { recipeId } = useParams();
  const httpClient = useAxios();

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
    <PageWithMenu
      helmetTitle={props.title}
      helmetName={props.name}
      helmetContent={props.content}
    >
      <Grid2 xs={12}>
        <Grid2 xs={8}>
          <h2>
            {recipe?.name}:{' '}
            {recipe?.recipeIngredients
              .map(
                ingredient =>
                  (ingredient.weightInGram * ingredient.ingredient.energy) /
                  100,
              )
              .reduce((prelim, a) => prelim + a, 0)
              .toFixed(0)}{' '}
            Calories
          </h2>
          <ImageList variant={'quilted'} cols={5} gap={8}>
            {recipe != null}{' '}
            {recipe?.recipeImages.map(url => (
              <ImageListItem>
                <img src={url} alt={''} />
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
                {ingredient.ingredient.name} ({ingredient.quantity}{' '}
                {ingredient.unit})
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
    </PageWithMenu>
  );
}
