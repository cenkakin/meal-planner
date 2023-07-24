import * as React from 'react';
import { useState } from 'react';
import Grid2 from '@mui/material/Unstable_Grid2';
import IngredientsAutoComplete from './IngredientsAutoComplete';
import BasicRecipeTable from './BasicRecipeTable';
import { BasicRecipeItem } from './BasicRecipeTable/BasicRecipeItem';
import { DatePicker } from '@mui/x-date-pickers';
import dayjs, { Dayjs } from 'dayjs';
import { Alert, AlertColor, Button, Snackbar } from '@mui/material';
import httpClient from '../../common/http-common';
import axios from 'axios';
import PageWithMenu from '../../common/component/PageWithMenu';

interface SaveCalenderEntryRequest {
  date: string;
  recipeId: string;
}

export function SearchRecipes(props) {
  const [basicRecipes, setBasicRecipes] = useState<Array<BasicRecipeItem>>([]);
  const [selectedDate, setSelectedDate] = useState<Dayjs>(dayjs());
  const [selectedRecipes, setSelectedRecipes] = useState<string[]>([]);
  const [snackBarOpen, setSnackBarOpen] = useState(false);
  const [severity, setSeverity] = useState<AlertColor>('success');
  const [message, setMessage] = useState<String>('');

  const userId = 'd0aaf316-21dd-433c-912e-d8fa32cbb7f9';

  function handleSelect(selectedItem: string) {
    if (selectedRecipes.includes(selectedItem)) {
      setSelectedRecipes(selectedRecipes.filter(item => item !== selectedItem));
    } else {
      setSelectedRecipes([...selectedRecipes, selectedItem]);
    }
  }

  function handleSnackBarClose(
    event?: React.SyntheticEvent | Event,
    reason?: string,
  ) {
    if (reason === 'clickaway') {
      return;
    }
    setSnackBarOpen(false);
  }

  async function saveRecipesToCalendar() {
    const entries: SaveCalenderEntryRequest[] = selectedRecipes.map(
      recipeId => {
        return {
          date: selectedDate.format('YYYY-MM-DD'),
          recipeId: recipeId,
          userId: userId,
        };
      },
    );
    try {
      setSnackBarOpen(true);
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
    <PageWithMenu
      helmetTitle={props.title}
      helmetName={props.name}
      helmetContent={props.content}
    >
      <Grid2 xs={12}>
        <Grid2 xs={12} container>
          <Grid2 xs={6}>
            <IngredientsAutoComplete
              onBasicRecipesChange={onBasicRecipesChange}
            />
          </Grid2>
          <Grid2 xs={5} container justifyContent="flex-start">
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
            <BasicRecipeTable
              recipes={basicRecipes}
              handleClick={handleSelect}
            />
          )}
          <Snackbar
            open={snackBarOpen}
            autoHideDuration={6000}
            onClose={handleSnackBarClose}
          >
            <Alert
              onClose={handleSnackBarClose}
              severity={severity}
              sx={{ width: '100%' }}
            >
              {message}
            </Alert>
          </Snackbar>
        </Grid2>
      </Grid2>
    </PageWithMenu>
  );
}
