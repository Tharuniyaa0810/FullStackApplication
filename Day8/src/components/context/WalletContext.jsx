// WalletContext.js
import { createContext, useContext, useState } from 'react';

const WalletContext = createContext();

export const useWallet = () => {
  return useContext(WalletContext);
};

export const WalletProvider = ({ children }) => {
  const [wallet, setWallet] = useState({
    USD: 100.0, // Initial wallet balance
    EUR: 150.0,
    GBP: 100.0,   // Initial wallet balance for GBP
    JPY: 100.0,   // Initial wallet balance for JPY
    AUD: 100.0,   // Initial wallet balance for AUD
    CAD: 100.0,   // Initial wallet balance for CAD
    INR: 100.0, 
    // Add more initial balances for other currencies
  });

  return (
    <WalletContext.Provider value={{ wallet, setWallet }}>
      {children}
    </WalletContext.Provider>
  );
};
