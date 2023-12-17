import React, { Component } from 'react';
import { Fade, Modal } from '@mui/material';
import Grid2 from '@mui/material/Unstable_Grid2';

interface Props {
  children?: any;
  isOpen: boolean;
  setModalState: (event: any) => void;
}

export default function FormModal({ children, isOpen, setModalState }: Props) {
  return (
    <Modal
      open={isOpen}
      onClose={() => setModalState(false)}
      closeAfterTransition
      slotProps={{
        backdrop: {
          style: {
            backdropFilter: 'blur(4px)',
            backgroundColor: 'transparent',
          },
        },
      }}
      sx={{
        left: '50%',
        width: 400,
        height: 400,
        marginTop: 10,
        backgroundColor: 'background.default',
        alignItems: 'center',
        display: 'flex',
      }}
    >
      <Fade in={isOpen}>
        <Grid2
          sx={{
            borderRadius: 2,
            paddingTop: 0,
          }}
        >
          {children}
        </Grid2>
      </Fade>
    </Modal>
  );
}
