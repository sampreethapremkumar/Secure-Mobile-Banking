import React, { useState, useEffect } from 'react';
import { Box, Container, Typography, Grid, Card, CardContent, Button } from '@mui/material';
import { useAuth } from '../contexts/AuthContext';
import { useNavigate } from 'react-router-dom';

function Dashboard() {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const [accounts, setAccounts] = useState([]);

  useEffect(() => {
    if (user) {
      // TODO: Fetch user accounts from API
      // For now, using mock data
      setAccounts([
        { id: 1, accountNumber: 'ACC001001001', type: 'Checking', balance: 5000.00, currency: 'USD' },
        { id: 2, accountNumber: 'ACC001001002', type: 'Savings', balance: 15000.00, currency: 'USD' }
      ]);
    }
  }, [user]);

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  const handleTransfer = () => {
    navigate('/transfer');
  };

  const handleTransactions = () => {
    navigate('/transactions');
  };

  const handleProfile = () => {
    navigate('/profile');
  };

  const handleAdmin = () => {
    navigate('/admin');
  };

  if (!user) {
    return <div>Loading...</div>;
  }

  return (
    <Container maxWidth="lg">
      <Box sx={{ mt: 4, mb: 4 }}>
        <Box display="flex" justifyContent="space-between" alignItems="center">
          <Typography variant="h4" component="h1">
            Welcome back, {user.fullName}
          </Typography>
          <Button variant="outlined" color="secondary" onClick={handleLogout}>
            Logout
          </Button>
        </Box>
        
        <Typography variant="subtitle1" color="textSecondary" sx={{ mb: 3 }}>
          Account Overview
        </Typography>

        <Grid container spacing={3}>
          {accounts.map((account) => (
            <Grid item xs={12} md={6} key={account.id}>
              <Card>
                <CardContent>
                  <Typography variant="h6" gutterBottom>
                    {account.type} Account
                  </Typography>
                  <Typography variant="body2" color="textSecondary" gutterBottom>
                    Account Number: {account.accountNumber}
                  </Typography>
                  <Typography variant="h4" color="primary" gutterBottom>
                    {account.currency} {account.balance.toLocaleString()}
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          ))}
        </Grid>

        <Box sx={{ mt: 4 }}>
          <Typography variant="h6" gutterBottom>
            Quick Actions
          </Typography>
          <Grid container spacing={2}>
            <Grid item>
              <Button variant="contained" color="primary" onClick={handleTransfer}>
                Transfer Money
              </Button>
            </Grid>
            <Grid item>
              <Button variant="outlined" onClick={handleTransactions}>
                View Transactions
              </Button>
            </Grid>
            <Grid item>
              <Button variant="outlined" onClick={handleProfile}>
                Profile Settings
              </Button>
            </Grid>
            {user.role === 'ADMIN' && (
              <Grid item>
                <Button variant="outlined" color="secondary" onClick={handleAdmin}>
                  Admin Panel
                </Button>
              </Grid>
            )}
          </Grid>
        </Box>
      </Box>
    </Container>
  );
}

export default Dashboard;