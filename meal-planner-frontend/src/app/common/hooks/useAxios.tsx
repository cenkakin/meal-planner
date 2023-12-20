import axios from '../http-common';
import { useEffect } from 'react';
import useAuth from './useAuth';

export default function useAxios() {
  const auth = useAuth();

  useEffect(() => {
    const requestIntercept = axios.interceptors.request.use(
      config => {
        if (!config.headers['Authorization']) {
          config.headers['Authorization'] = `Bearer ${auth.token}`;
        }
        return config;
      },
      error => Promise.reject(error),
    );

    return () => {
      axios.interceptors.request.eject(requestIntercept);
    };
  }, [auth]);

  return axios;
}
