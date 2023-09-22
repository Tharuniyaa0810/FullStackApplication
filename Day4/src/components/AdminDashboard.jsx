import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { selectUser } from './redux/UserSlice';
import '../assets/css/AdminDashboard.css';
import logo from '../assets/logo.png';

const Sidebar = () => {
  return (
    <div className="sidebar">
      <div className="logo-and-name">
        <img src={logo} alt="Logo" />
        <h2>ForexFlare</h2>
      </div>

      {/* Sidebar content */}
      <ul>
        <li>Dashboard</li>
        <li>Exchange Rates</li>
        <li>Transactions</li>
        <li>Settings</li>
      </ul>
    </div>
  );
};

const Header = ({ userCount, transactionCount }) => {
  const user = useSelector(selectUser);
  const username = user.user && user.user.username ? user.user.username : 'Guest';

  return (
    <div className="header">
      {/* Header content */}
      <p>Welcome, {username}!</p>
    </div>
  );
};

const UserCount = ({ userCount }) => {
  return (
    <div className="user-count">
      <h2>User Count</h2>
      <p>Total Users: {userCount}</p>
    </div>
  );
};

const TransactionCount = ({ transactionCount }) => {
  return (
    <div className="transaction-count">
      <h2>Transaction Count</h2>
      <p>Total Transactions: {transactionCount}</p>
    </div>
  );
};

const AdminDashboard = () => {
  const [userCount, setUserCount] = useState(0);
  const [transactionCount, setTransactionCount] = useState(0);

  useEffect(() => {
    // Simulated user count and transaction count (replace with actual data)
    setUserCount(100);
    setTransactionCount(500);
  }, []);
  return (
    <div className="admin-dashboard">
      <Sidebar />
      <div className="main-content">
        <Header userCount={userCount} transactionCount={transactionCount} />
        <div className="dashboard-content">
          <div className="dashboard-stats-box">
            <div className="dashboard-stats">
              <div className="user-count">
                <h2>User Count</h2>
                <p>Total Users: {userCount}</p>
              </div>
            </div>
          </div>
          <div className="dashboard-stats-box">
            <div className="dashboard-stats">
              <div className="transaction-count">
                <h2>Transaction Count</h2>
                <p>Total Transactions: {transactionCount}</p>
              </div>
            </div>
          </div>
          {/* Your other main content goes here */}
        </div>
      </div>
    </div>
  );
};

export default AdminDashboard;
