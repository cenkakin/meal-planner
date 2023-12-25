import * as React from 'react';
import { SyntheticEvent, useEffect, useState } from 'react';
import { IngredientAutocompleteItem } from './IngredientAutocompleteItem';
import { InputAdornment, TextField } from '@mui/material';
import Autocomplete from '@mui/material/Autocomplete';
import SearchRecipesButton from './SearchRecipesButton';
import useAxios from '../../../common/hooks/useAxios';

export default function IngredientsAutoComplete({ onBasicRecipesChange }) {
  const [ingredients, setIngredients] = useState<
    readonly IngredientAutocompleteItem[]
  >([]);

  const [ingredientIds, setIngredientIds] = useState<readonly String[]>([]);

  const [open, setOpen] = React.useState(false);

  const loading = open && ingredients.length === 0;

  const httpClient = useAxios();

  function onIngredientSelection(
    e: SyntheticEvent,
    newValue: IngredientAutocompleteItem[],
  ) {
    const ingredientIds = newValue.map(ing => ing.id);
    setIngredientIds(ingredientIds);
  }

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
      limitTags={7}
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
          InputProps={{
            ...params.InputProps,
            endAdornment: (
              <InputAdornment position="end">
                <SearchRecipesButton
                  ingredientIds={ingredientIds}
                  onBasicRecipesChange={onBasicRecipesChange}
                />
              </InputAdornment>
            ),
          }}
        />
      )}
    />
  );
}
