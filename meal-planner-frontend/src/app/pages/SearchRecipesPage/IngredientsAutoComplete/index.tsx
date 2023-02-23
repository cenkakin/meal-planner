import * as React from 'react';
import { useEffect, useState } from 'react';
import { IngredientAutocompleteItem } from './IngredientAutocompleteItem';
import { TextField } from '@mui/material';
import Autocomplete from '@mui/material/Autocomplete';
import httpClient from '../../../common/http-common';

export default function IngredientsAutoComplete({ onIngredientSelection }) {
  const [ingredients, setIngredients] = useState<
    readonly IngredientAutocompleteItem[]
  >([]);

  const [open, setOpen] = React.useState(false);

  const loading = open && ingredients.length === 0;

  useEffect(() => {
    let active = true;

    if (!loading) {
      return undefined;
    }

    (async () => {
      let { data: response } = await httpClient.get('/ingredient');

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

  return (
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
      onChange={onIngredientSelection}
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
  );
}
