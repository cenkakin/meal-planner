import React, { createContext, useState } from 'react';

export type AuthContextType = {
  email: string;
  token: string;
  role: Role;
};

export enum Role {
  ROLE_USER = 'ROLE_USER',
}

export const AuthContext = createContext<AuthContextType>(
  null as unknown as AuthContextType,
);

type AuthProviderProps = { children: React.ReactNode };
export const AuthProvider = ({ children }: AuthProviderProps) => {
  const [email] = useState('');
  const [token] = useState('');
  const [role] = useState(Role.ROLE_USER);

  const value = {
    email,
    token,
    role,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
