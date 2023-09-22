import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { Provider } from 'react-redux';
import Store from './components/redux/Store';
import ForgotPassword from './components/ForgotPassword';
import { UserProvider } from './components/context/UserContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
<Provider store={Store}>
    <UserProvider>
    <App />
    </UserProvider>
    </Provider>
  
    </React.StrictMode>
 
);

