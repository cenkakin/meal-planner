import Autocomplete from '@mui/material/Autocomplete';
import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { Button, TextField } from '@mui/material';
import { SyntheticEvent, useEffect, useState } from 'react';
import axios from 'axios';
import BasicRecipeTable from '../../common/components/BasicRecipeTable';
import Grid2 from '@mui/material/Unstable_Grid2';

interface IngredientAutocompleteItem {
  id: string;
  name: string;
}

interface BasicRecipeItem {
  id: string;
  name: string;
  cuisine: string;
}

export function SearchRecipes() {
  const [ingredients, setIngredients] = useState<
    readonly IngredientAutocompleteItem[]
  >([]);
  const [basicRecipes, setBasicRecipes] = useState<readonly BasicRecipeItem[]>(
    [],
  );
  const [ingredientsSelection, setIngredientsSelection] = useState<
    IngredientAutocompleteItem[]
  >([]);
  const [open, setOpen] = React.useState(false);
  const loading = open && ingredients.length === 0;

  useEffect(() => {
    let active = true;

    if (!loading) {
      return undefined;
    }

    (async () => {
      let { data: response } = await axios.get(
        'http://localhost:8080/v1/ingredient',
      );

      if (active) {
        setIngredients(
          response.ingredients.map(ingredient => {
            let ingredientAutocompleteItem: IngredientAutocompleteItem = {
              name: ingredient.name,
              id: ingredient.id,
            };
            return ingredientAutocompleteItem;
          }),
        );
      }
    })();

    return () => {
      active = false;
    };
  }, [loading]);

  function handleSelection(
    e: SyntheticEvent,
    newValue: IngredientAutocompleteItem[],
  ) {
    setIngredientsSelection(newValue);
  }

  async function handleSearchRecipe() {
    await axios
      .get(
        'http://localhost:8080/v1/recipe/search?ingredientIds=' +
          ingredientsSelection.map(i => i.id),
      )
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
          <Autocomplete
            multiple
            limitTags={4}
            id="tags-outlined"
            open={open}
            onOpen={() => {
              setOpen(true);
            }}
            onClose={() => {
              setOpen(false);
            }}
            value={ingredientsSelection}
            onChange={handleSelection}
            options={ingredients}
            getOptionLabel={option => option.name}
            filterSelectedOptions
            loading={loading}
            renderInput={params => (
              <TextField
                {...params}
                label="Select ingredients"
                placeholder="Ingredients"
              />
            )}
            sx={{ width: '500px' }}
          />
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
