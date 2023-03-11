import { createTheme } from '@mui/material/styles';
import { red } from '@mui/material/colors';

declare module '@mui/material/styles' {
  interface Palette {
    fsaGreen: Palette['primary'];
    fsaOrange: Palette['primary'];
    fsaRed: Palette['primary'];
  }

  interface PaletteOptions {
    fsaGreen?: PaletteOptions['primary'];
    fsaOrange?: PaletteOptions['primary'];
    fsaRed?: PaletteOptions['primary'];
  }
}
// A custom theme for this app
const theme = createTheme({
  palette: {
    primary: {
      main: '#19857b',
    },
    secondary: {
      main: '#eff6f6',
    },
    error: {
      main: red.A400,
    },
    fsaGreen: {
      main: '#66bb6a',
      contrastText: '#fff',
    },
    fsaOrange: {
      main: '#ffb74d',
      contrastText: '#fff',
    },
    fsaRed: {
      main: '#d32f2f',
      contrastText: '#fff',
    },
  },
});

declare module '@mui/material/Chip' {
  interface ChipPropsColorOverrides {
    fsaRed: true;
    fsaGreen: true;
    fsaOrange: true;
  }
}
export default theme;
