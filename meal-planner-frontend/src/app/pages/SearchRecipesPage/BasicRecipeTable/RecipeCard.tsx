import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import {
  Button,
  CardActions,
  CardHeader,
  Chip,
  Divider,
  IconButton,
  Stack,
} from '@mui/material';
import Carousel from 'nuka-carousel';
import { useNavigate } from 'react-router-dom';
import { FSALights } from './FSALights';
import Grid2 from '@mui/material/Unstable_Grid2';
import PlaceholderImage from '../../../assets/recipe-placeholder.jpg';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';

interface Props {
  id: string;
  title: string;
  imageUrls: Array<string>;
  fsaLights: FSALights;
}

function getColor(light: string): 'fsaGreen' | 'fsaRed' | 'fsaOrange' {
  // @ts-ignore
  return `fsa${light[0].toUpperCase()}${light.slice(1)}`;
}

export default function RecipeCard({ id, title, imageUrls, fsaLights }: Props) {
  const navigate = useNavigate();

  function renderImages() {
    if (imageUrls && imageUrls.length > 1) {
      return (
        <Carousel
          renderCenterLeftControls={({ previousDisabled, previousSlide }) => (
            <IconButton onClick={previousSlide} disabled={previousDisabled}>
              <ChevronLeftIcon />
            </IconButton>
          )}
          renderCenterRightControls={({ nextDisabled, nextSlide }) => (
            <IconButton onClick={nextSlide} disabled={nextDisabled}>
              <ChevronRightIcon />
            </IconButton>
          )}
        >
          {imageUrls.slice(0, 7).map((url, i) => (
            <CardMedia component="img" height="140" image={url} key={i} />
          ))}
        </Carousel>
      );
    } else if (imageUrls && imageUrls.length === 1) {
      return <CardMedia height="140" component="img" image={imageUrls[0]} />;
    } else {
      return (
        <CardMedia height="140" component="img" image={PlaceholderImage} />
      );
    }
  }

  return (
    <Card sx={{ height: '100%', width: '100%' }} key={id}>
      <CardHeader
        sx={{ textAlign: 'center' }}
        title={title}
        titleTypographyProps={{
          paragraph: true,
          noWrap: true,
          variant: 'body1',
        }}
      />
      <CardContent>
        <Grid2 container spacing={2} direction={'column'}>
          <Grid2 sx={{ boxShadow: 2, marginBottom: 2 }}>{renderImages()}</Grid2>
          <Stack
            direction="row"
            spacing={1}
            divider={<Divider orientation="vertical" flexItem />}
          >
            <Chip size="small" label="Fat" color={getColor(fsaLights.fsaFat)} />
            <Chip
              size="small"
              label="Sat. Fat"
              color={getColor(fsaLights.fsaSaturated)}
            />
            <Chip
              size="small"
              label="Sugar"
              color={getColor(fsaLights.fsaSugar)}
            />
            <Chip
              size="small"
              label="Salt"
              color={getColor(fsaLights.fsaSalt)}
            />
          </Stack>
        </Grid2>
      </CardContent>
      <CardActions>
        <Button onClick={() => navigate(`recipe/${id}`)} size="small">
          See More
        </Button>
      </CardActions>
    </Card>
  );
}
