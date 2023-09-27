import {configureStore} from '@reduxjs/toolkit';
import { UserSlice } from './UserSlice';
import WalletSlice from './WalletSlice';
const persistedWalletState = JSON.parse(localStorage.getItem('walletState'));

export default configureStore(
    {
        reducer:{
          user:UserSlice.reducer,
          wallet: WalletSlice.reducer,
          preloadedState: {
            wallet: persistedWalletState || WalletSlice.initialState,
          },
        }
    }
)