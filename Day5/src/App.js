import * as React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Signup from './components/Signup';
import Login from './components/Login';
import AdminDashboard from './components/AdminDashboard';
import App1 from './components/App1';
import ForgotPassword from './components/ForgotPassword';
import { useUser } from './components/context/UserContext';
import Header from './components/Header';
import Exchangerates from './components/ExchangeRates';
import Transaction from './components/Transaction';
import Users from './components/Users';


const PrivateRoute=({children})=>{
  const{isUserLoggedIn}=useUser();
  return isUserLoggedIn ?  children : <Navigate to="/login" replace/>
}
const App=()=> {
  return (
    <div>
      <Router>
        <Routes>
          
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Signup/>} />
          <Route path="/exchange-rate" element={<Exchangerates/>} />
          <Route path="/transaction" element={<Transaction/>} />
          <Route path="/users" element={<Users/>} />
          <Route path="/dashboard" element={
            <PrivateRoute>
              <App1/>
            </PrivateRoute>
          } />
          <Route path="/forgot" element={<ForgotPassword />} />
         <Route path='/about' element={
<PrivateRoute>
  <Header/>
</PrivateRoute>
         }/>

        </Routes>
      </Router>
    </div>
  );
}

export default App;
