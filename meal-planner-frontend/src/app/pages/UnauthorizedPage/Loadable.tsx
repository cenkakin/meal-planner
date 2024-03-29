import { lazyLoad } from 'utils/loadable';

export const UnauthorizedPage = lazyLoad(
  () => import('./index'),
  module => module.Unauthorized,
);
