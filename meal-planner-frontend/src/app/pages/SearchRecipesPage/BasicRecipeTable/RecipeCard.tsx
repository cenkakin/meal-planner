import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import Carousel from 'nuka-carousel';
import { useNavigate } from 'react-router-dom';

export default function RecipeCard({ id, title, imageUrls }) {
  const navigate = useNavigate();

  return (
    <Card sx={{ height: '100%', width: '100%' }} key={id}>
      <CardActionArea
        onClick={() => navigate(`recipe/id/${id}`)}
      >
        <CardContent>
          <Typography  variant="body1" component="div" noWrap={true}>
            {title}
          </Typography>
        </CardContent>
      </CardActionArea>
          <CardContent>
              <Carousel
                  renderCenterLeftControls={null}
                  renderCenterRightControls={null}
              >
                  {imageUrls.map(url => {
                      return <CardMedia
                          component="img"
                          height="140"
                          image={url}
                      />
                  })}
              </Carousel>
          </CardContent>
    </Card>
  );
}
