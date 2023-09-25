import React from 'react';
import { useSelector } from 'react-redux'; // Import the useSelector hook from react-redux
import '../assets/css/WalletAdmin.css'; // Import the CSS file

function WalletAdmin() {
  // Access wallet data from the Redux store
  const wallet = useSelector((state) => state.wallet.adminWallets);

  return (
    <div className="wallet-admin-container">
      <h1 className="wallet-admin-heading">Wallet Balances</h1>
      <ul className="wallet-admin-list">
        {Object.entries(wallet).map(([currency, balance]) => (
          <li key={currency} className="wallet-admin-item">
            <span className={`currency-label ${currency.toLowerCase()}-admin`}>
              {currency} Admin:
            </span>{' '}
            {balance}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default WalletAdmin;
