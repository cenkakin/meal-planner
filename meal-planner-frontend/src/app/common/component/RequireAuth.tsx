import { useLocation, Navigate } from 'react-router-dom';
import useAuth from '../hooks/useAuth';
import React, {ReactElement} from 'react';
import { Role } from '../context/AuthProvider';

type RequireAuthProps = {
  allowedRoles: (Role | null)[];
  children: ReactElement;
};
export const RequireAuth = ({ allowedRoles, children }: RequireAuthProps) => {
  const auth = useAuth();
  const location = useLocation();

  console.log(auth)

  return !!auth.token && allowedRoles.includes(auth.role) ? (
    children
  ) : !!auth.token ? (
    <Navigate to='/unauthorized' state={{ from: location }} replace />
  ) : (
    <Navigate to='/login' state={{ from: location }} replace />
  );
};
