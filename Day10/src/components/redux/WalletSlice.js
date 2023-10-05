// walletSlice.js
import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  userWallets: {}, // User-specific wallet balances
  adminWallets: {}, // Admin-specific wallet balances
};

const walletSlice = createSlice({
  name: 'wallet',
  initialState,
  reducers: {
    deductFromWallet(state, action) {
      const { userId, currency, amount } = action.payload;
      state.userWallets[userId][currency] -= amount;
    },
    increaseWallet(state, action) {
      const { userId, currency, amount } = action.payload;
      state.userWallets[userId][currency] += amount;
    },
    deductFromAdminWallet(state, action) {
      const { currency, amount } = action.payload;
      state.adminWallets[currency] -= amount;
    },
    increaseAdminWallet(state, action) {
      const { currency, amount } = action.payload;
      state.adminWallets[currency] += amount;
    },
    saveWalletToLocalStorage(state) {
        localStorage.setItem('walletState', JSON.stringify(state));
      },
  },
});

export const {
  deductFromWallet,
  increaseWallet,
  deductFromAdminWallet,
  increaseAdminWallet,
} = walletSlice.actions;

export default walletSlice.reducer;
