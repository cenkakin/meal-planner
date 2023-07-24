import * as React from 'react';
import { useEffect, useState } from 'react';
import httpClient from '../../common/http-common';
import { CalendarEntry } from './CalendarView/CalendarEntry';
import {
  List,
  ListItem,
  ListItemText,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from '@mui/material';
import Paper from '@mui/material/Paper';
import { useNavigate } from 'react-router-dom';
import PageWithMenu from '../../common/component/PageWithMenu';

export function Calendar(props) {
  const [calendar, setCalendar] = useState<CalendarEntry[]>();
  const calendarId = '73f6af82-ab5f-40da-9873-f9dc88129607';
  const navigate = useNavigate();

  useEffect(() => {
    const fetchCalendar = async () => {
      const { data: response } = await httpClient.get(
        '/calendar/' + calendarId,
      );
      const calendarPlain = response.calendar;

      await Promise.all(
        calendarPlain.map(async entry => {
          const { data: response } = await httpClient.get(
            '/recipe/' + entry.recipeId,
          );
          const recipe = {
            id: response.id,
            name: response.name,
            cuisine: response.cuisine,
            recipeIngredients: response.recipeIngredients,
            instructions: response.instructions,
            recipeImages: response.recipeImages,
          };

          return {
            date: entry.date,
            recipe: recipe,
          };
        }),
      ).then(response => setCalendar(response as CalendarEntry[]));
    };
    fetchCalendar();
  }, [calendarId]);

  function calculateTotalCalories(recipes) {
    return (
      recipes
        .map(
          recipe =>
            recipe.recipeIngredients
              .map(
                ingredient =>
                  (ingredient.weightInGram * ingredient.ingredient.energy) /
                  100,
              )
              .reduce((prelim, a) => prelim + a, 0),
          // .toFixed(0)
        )
        .reduce((prelim, a) => prelim + a, 0)
        .toFixed(0) + ' Cal'
    );
  }

  function createMealList(recipes) {
    return (
      <List>
        {recipes.map(recipe => (
          <ListItem
            key={recipe.id}
            onClick={() => navigate(`../recipe/${recipe.id}`)}
          >
            <ListItemText
              primary={recipe.name}
              secondary={calculateTotalCalories([recipe])}
            />
          </ListItem>
        ))}
      </List>
    );
  }

  return (
    <PageWithMenu
      helmetTitle={props.title}
      helmetName={props.name}
      helmetContent={props.content}
    >
      <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell width="25%" align="left">
                Date
              </TableCell>
              <TableCell width="50%" align="left">
                Meals
              </TableCell>
              <TableCell width="25%" align="left">
                Total Calories
              </TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {Array.from(new Set<string>(calendar?.map(x => x.date))).map(
              date => (
                <TableRow>
                  <TableCell width="25%" align="left">
                    {date}
                  </TableCell>
                  <TableCell width="50%" align="left">
                    {createMealList(
                      calendar
                        ?.filter(entry => entry.date == date)
                        .flatMap(entry => entry.recipe),
                    )}
                  </TableCell>
                  <TableCell width="25%" align="left">
                    {calculateTotalCalories(
                      calendar
                        ?.filter(entry => entry.date == date)
                        .flatMap(entry => entry.recipe),
                    )}
                  </TableCell>
                </TableRow>
              ),
            )}
          </TableBody>
        </Table>
      </TableContainer>
    </PageWithMenu>
  );
}
