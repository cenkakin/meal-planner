import axios from 'axios';

export default axios.create({
  baseURL: '/v1',
  withCredentials: true,
});
