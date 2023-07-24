import * as React from 'react';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import RestaurantIcon from '@mui/icons-material/Restaurant';
import CalendarIcon from '@mui/icons-material/CalendarToday';
import { useNavigate } from 'react-router-dom';
import { Avatar, IconButton, Tooltip } from '@mui/material';
import { CalendarToday } from '@mui/icons-material';

const drawerWidth = 240;

export default function LeftMenuWithNavigation(props) {
  const navigate = useNavigate();

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ zIndex: theme => theme.zIndex.drawer + 1, bgcolor: '#399BF3' }}
      >
        <Toolbar sx={{ justifyContent: 'space-between' }}>
          <Typography variant="h6" noWrap component="div">
            Meal Planner
          </Typography>
          <Box sx={{ flexGrow: 0 }}>
            <Tooltip title="Account settings">
              <IconButton onClick={() => {}} sx={{ p: 0 }}>
                <Avatar alt="Cenk Serkan" src="" />
              </IconButton>
            </Tooltip>
          </Box>
        </Toolbar>
      </AppBar>
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
            marginTop: 10,
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <List>
          {props.routes.map(
            route =>
              route.render && (
                <ListItem key={route.key} disablePadding>
                  <ListItemButton onClick={() => navigate(route.path)}>
                    <ListItemIcon>{route.icon}</ListItemIcon>
                    <ListItemText primary={route.title} />
                  </ListItemButton>
                </ListItem>
              ),
          )}
        </List>
      </Drawer>
    </Box>
  );
}
