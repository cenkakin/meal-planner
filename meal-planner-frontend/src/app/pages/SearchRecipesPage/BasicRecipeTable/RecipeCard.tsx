import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';
import { useNavigate } from 'react-router-dom';

export default function RecipeCard({ id, title, imageUrl }) {
  const navigate = useNavigate();

  return (
    <Card sx={{ height: '100%', width: '100%' }} key={id}>
      <CardActionArea
        sx={{ height: '100%' }}
        onClick={() => navigate(`recipe/id/${id}`)}
      >
        <CardMedia component="img" height="140" image={imageUrl} />
        <CardContent>
          <Typography gutterBottom variant="body1" component="div">
            {title}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}
