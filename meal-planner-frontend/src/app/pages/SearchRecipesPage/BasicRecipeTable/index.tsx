import React, { useEffect, useState } from 'react';
import Paper from '@mui/material/Paper';
import RecipeCard from './RecipeCard';
import Grid2 from '@mui/material/Unstable_Grid2';
import InfiniteScroll from 'react-infinite-scroller';
import { BasicRecipeItem } from './BasicRecipeItem';

interface Props {
  recipes: Array<BasicRecipeItem>;
}

const ITEMS_PER_PAGE = 30;

export default function RecipeTable({ recipes }: Props) {
  const [page, setPage] = useState(0);
  const [items, setItems] = useState<BasicRecipeItem[]>([]);

  useEffect(() => {
    setItems(recipes.slice(0, ITEMS_PER_PAGE));
  }, [recipes]);

  let hasMore = items.length + ITEMS_PER_PAGE <= recipes.length;

  function recipeCards() {
    return items.map(recipe => (
      <Grid2 key={recipe.id} xs={4}>
        <RecipeCard
          id={recipe.id}
          title={recipe.title}
          imageUrl={
            recipe.recipeImages &&
            recipe.recipeImages.length &&
            recipe.recipeImages[0]
          }
        />
      </Grid2>
    ));
  }

  function loadFunction() {
    return () => {
      const currentItems = recipes.slice(0, (page + 1) * ITEMS_PER_PAGE);
      setItems(currentItems);
      setPage(page + 1);
    };
  }

  return (
    <Paper sx={{ width: '100%', overflow: 'hidden' }}>
      <InfiniteScroll
        initialLoad={false}
        pageStart={0}
        loadMore={loadFunction()}
        hasMore={hasMore}
        loader={
          <div className="loader" key={0}>
            Loading ...
          </div>
        }
      >
        <Grid2 container spacing={2}>
          {recipeCards()}
        </Grid2>
      </InfiniteScroll>
    </Paper>
  );
}
