import * as React from 'react';
import { useState } from 'react';
import { Helmet } from 'react-helmet-async';
import Grid2 from '@mui/material/Unstable_Grid2';
import IngredientsAutoComplete from './IngredientsAutoComplete';
import BasicRecipeTable from './BasicRecipeTable';
import { BasicRecipeItem } from './BasicRecipeTable/BasicRecipeItem';
import { DatePicker } from '@mui/x-date-pickers';
import dayjs, { Dayjs } from 'dayjs';
import { Alert, AlertColor, Button, Snackbar } from '@mui/material';
import httpClient from '../../common/http-common';
import axios from 'axios';

interface SaveCalenderEntryRequest {
  date: string;
  recipeId: string;
}

export function SearchRecipes(props) {
  const [basicRecipes, setBasicRecipes] = useState<Array<BasicRecipeItem>>([]);
  const [selectedDate, setSelectedDate] = useState<Dayjs>(dayjs());
  const [selectedRecipes, setSelectedRecipes] = useState<string[]>([]);
  const [open, setOpen] = useState(false);
  const [severity, setSeverity] = useState<AlertColor>('success');
  const [message, setMessage] = useState<String>('');

  function handleSelect(selectedItem: string) {
    if (selectedRecipes.includes(selectedItem)) {
      setSelectedRecipes(selectedRecipes.filter(item => item !== selectedItem));
    } else {
      setSelectedRecipes([...selectedRecipes, selectedItem]);
    }
  }

  function handleClose(event?: React.SyntheticEvent | Event, reason?: string) {
    if (reason === 'clickaway') {
      return;
    }
    setOpen(false);
  }

  async function saveRecipesToCalendar() {
    const entries: SaveCalenderEntryRequest[] = selectedRecipes.map(
      recipeId => {
        return {
          date: selectedDate.format('YYYY-MM-DD'),
          recipeId: recipeId,
        };
      },
    );
    try {
      setOpen(true);
      const { status } = await httpClient.post('/calendar', {
        entries: entries,
      });
      if (status == 200) {
        setSeverity('success');
        setMessage('Recipes saved!');
      }
    } catch (error) {
      if (axios.isAxiosError(error)) {
        setSeverity('error');
        setMessage(error.response?.data.detail);
      }
    }
  }

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
      <Grid2 xs={10} container>
        <Grid2 xs={6}>
          <IngredientsAutoComplete
            onBasicRecipesChange={onBasicRecipesChange}
          />
        </Grid2>
        <Grid2 xs={4} container justifyContent="flex-start">
          <Grid2 xs={6}>
            <DatePicker
              value={selectedDate}
              onChange={newValue => setSelectedDate(dayjs(newValue))}
            />
          </Grid2>
          <Grid2 xs={5}>
            {selectedRecipes.length > 0 && (
              <Button
                size="large"
                variant="contained"
                color="fsaGreen"
                sx={{ height: '100%' }}
                onClick={saveRecipesToCalendar}
              >
                Save Recipes
              </Button>
            )}
          </Grid2>
        </Grid2>
      </Grid2>
      <Grid2 xs={10}>
        {basicRecipes.length > 0 && (
          <BasicRecipeTable recipes={basicRecipes} handleClick={handleSelect} />
        )}
        <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
          <Alert
            onClose={handleClose}
            severity={severity}
            sx={{ width: '100%' }}
          >
            {message}
          </Alert>
        </Snackbar>
      </Grid2>
    </Grid2>
  );
}
