// PaymentPage.js
import React from 'react';
import { Link } from 'react-router-dom';
import { useWallet } from './context/WalletContext';
import '../assets/css/App.css'
function PaymentPage() {
  const { wallet } = useWallet();

  return (
    <div className="wallet-container">
      <h2 className="wallet-title">Payment Page</h2>
      <h3 className="wallet-subtitle">Multi-Currency Wallet</h3>
      <ul className="wallet-list">
        {Object.keys(wallet).map((currency) => (
          <li className="wallet-item" key={currency}>
            <span className="currency-label">{currency}:</span>
            <span className="currency-amount">{wallet[currency].toFixed(2)}</span>
          </li>
        ))}
      </ul>
      <Link to="/convertor" className="back-link">
        Back to Home
      </Link>
    </div>
  );
}

export default PaymentPage;

