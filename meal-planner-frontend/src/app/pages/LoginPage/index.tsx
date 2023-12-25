import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import Link from '@mui/material/Link';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { Alert, AlertColor, Container, Snackbar } from '@mui/material';
import React, { useState } from 'react';
import Grid2 from '@mui/material/Unstable_Grid2';
import { Helmet } from 'react-helmet-async';
import Form, { FormType } from './Form';
import FormModal from './Form/FormModal';
import { useNavigate } from 'react-router-dom';
import httpClient from '../../common/http-common';
import { UserDetails } from './LoginView/UserDetails';
import axios from 'axios';
import { Role } from '../../common/context/AuthProvider';
import useAuth from '../../common/hooks/useAuth';

export function Login(props) {
  const [modalOpen, setModelOpen] = useState(false);
  const [snackBarOpen, setSnackBarOpen] = useState(false);
  const [severity, setSeverity] = useState<AlertColor>('success');
  const [message, setMessage] = useState<String>('');
  const auth = useAuth();

  const navigate = useNavigate();

  async function login(email, password) {
    const user: UserDetails = {
      email: email,
      password: password,
    };

    try {
      setSnackBarOpen(true);
      const { status, data } = await httpClient.post('/auth/login', user);
      if (status == 200) {
        auth.email = 'user.email';
        auth.token = data;
        auth.role = Role.ROLE_USER;
        navigate(`/`);
      }
    } catch (error) {
      if (axios.isAxiosError(error)) {
        setSeverity('error');
        setMessage(error.response?.data.detail);
      }
    }
  }

  async function register(userName, password, email) {
    const user: UserDetails = {
      userName: userName,
      password: password,
      email: email,
    };

    try {
      setSnackBarOpen(true);
      const { status, data } = await httpClient.post('/auth/register', user);
      if (status == 200) {
        auth.email = user.email;
        auth.token = data;
        auth.role = Role.ROLE_USER;
        setSeverity('success');
        setMessage('User registered');
        setModelOpen(false);
      }
    } catch (error) {
      if (axios.isAxiosError(error)) {
        setSeverity('error');
        setMessage(error.response?.data.detail);
      }
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

  const handleSubmitLogin = event => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);

    login(data.get('userName'), data.get('password'));
  };

  const handleSubmitRegister = event => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);

    register(data.get('userName'), data.get('password'), data.get('email'));
  };

  return (
    <Container component="main" maxWidth="lg">
      <Helmet>
        <title>{props.title}</title>
        <meta name="description" content="Discover recipes" />
      </Helmet>
      <Box
        sx={{
          marginTop: 8,
        }}
      >
        <Grid2 container>
          <CssBaseline />
          <Grid2
            sm={4}
            md={7}
            sx={{
              backgroundImage: 'url(https://source.unsplash.com/random)',
              backgroundRepeat: 'no-repeat',
              backgroundColor: 'background.main',
              backgroundSize: 'cover',
              backgroundPosition: 'center',
            }}
          />
          <Grid2 xs={12} sm={8} md={5}>
            <Form
              handleSubmit={handleSubmitLogin}
              title={'Sign in'}
              buttonText={'SIGN IN'}
              formType={FormType.LOGIN}
            >
              <Grid container>
                <Grid item xs>
                  <Link href="#" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Button onClick={() => setModelOpen(true)}>
                    {'Sign Up'}
                  </Button>
                </Grid>
              </Grid>
            </Form>
            <FormModal isOpen={modalOpen} setModalState={setModelOpen}>
              <Form
                title={'Sign up'}
                buttonText={'Sign up'}
                handleSubmit={handleSubmitRegister}
                formType={FormType.REGISTER}
              ></Form>
            </FormModal>
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
      </Box>
    </Container>
  );
}
