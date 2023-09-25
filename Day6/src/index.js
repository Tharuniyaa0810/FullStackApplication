import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { Provider } from 'react-redux';
import Store from './components/redux/Store';
// import ForgotPassword from './components/ForgotPassword';
import { UserProvider } from './components/context/UserContext';
import { WalletProvider } from './components/context/WalletContext';
import FeedbackPage from './components/Feedback';
import { FeedbackProvider } from './components/context/FeedbackContext';
//import CurrencyConverter from './components/CurrencyExchange';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
    <Provider store={Store}>
      <WalletProvider>
    <UserProvider>
    <FeedbackProvider>
      <App />
    </FeedbackProvider>
    </UserProvider>
    </WalletProvider>
    </Provider> 


    </React.StrictMode>
 
);

