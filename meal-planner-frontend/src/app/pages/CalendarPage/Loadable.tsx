import { lazyLoad } from 'utils/loadable';

export const CalendarPage = lazyLoad(
  () => import('./index'),
  module => module.Calendar,
);
