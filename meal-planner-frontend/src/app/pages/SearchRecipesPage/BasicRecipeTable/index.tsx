import * as React from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import { useNavigate } from 'react-router-dom';

interface Column {
  key: 'id' | 'name' | 'cuisine' | 'photo' | 'summary';
  label: string;
  minWidth?: number;

  align?: 'left' | 'center' | 'right';
  render?: (value: any) => any;
}

const columns: readonly Column[] = [
  {
    key: 'photo',
    label: '',
    minWidth: 200,
    align: 'center',
    render: photoUrl =>
      photoUrl && <img src={photoUrl} alt="" height="100" width="100" />,
  },
  { key: 'name', label: 'Name', minWidth: 50 },
  { key: 'cuisine', label: 'Cuisine', minWidth: 50 },
  { key: 'summary', label: '', minWidth: 200 },
];
export default function RecipeTable({ inputData }) {
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);
  const rows = inputData;
  const navigate = useNavigate();

  const handleChangePage = (event: unknown, newPage: number) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (
    event: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  };

  return (
    <Paper sx={{ width: '100%', overflow: 'hidden' }}>
      <TableContainer>
        <Table stickyHeader aria-label="sticky table">
          <TableHead>
            <TableRow>
              {columns.map(column => (
                <TableCell
                  key={column.key}
                  align="left"
                  style={{ minWidth: column.minWidth }}
                >
                  {column.label}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rows
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map(row => {
                return (
                  <TableRow
                    hover
                    role="checkbox"
                    tabIndex={-1}
                    key={row.id}
                    onClick={() => navigate(`recipe/id/${row.id}`)}
                  >
                    {columns.map(column => {
                      const value = row[column.key];
                      return (
                        <TableCell key={column.key} align={column.align}>
                          {column.render ? column.render(value) : value}
                        </TableCell>
                      );
                    })}
                  </TableRow>
                );
              })}
          </TableBody>
        </Table>
      </TableContainer>
      <TablePagination
        rowsPerPageOptions={[10, 25, 100]}
        component="div"
        count={rows.length}
        rowsPerPage={rowsPerPage}
        page={page}
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </Paper>
  );
}
