import * as React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Signup from './components/Signup';
import Login from './components/Login';
// import AdminDashboard from './components/AdminDashboard';
import App1 from './components/App1';
import ForgotPassword from './components/ForgotPassword';
import { useUser } from './components/context/UserContext';
import Header from './components/Header';
import Exchangerates from './components/ExchangeRates';
import Transaction from './components/Transaction';
import Users from './components/Users';
import PrivacyPolicy from './components/PrivacyPolicy';
import TermsAndConditions from './components/TermsAndConditions';
// import FAQ from './components/FAQ';
import FAQPage from './components/FAQ';
import CurrencyConvertor from './components/CurrencyConvertor';
import PaymentPage from './components/PaymentPage';
import FeedbackPage from './components/Feedback';
import AdminFeedbacks from './components/AdminFeedbacks';
import Landing from './components/Landing';
// import Content from './components/Content';
import Chart from './components/Chart';
import ContactUs from './components/Contact';



const PrivateRoute=({children})=>{
  const{isUserLoggedIn}=useUser();
  return isUserLoggedIn ?  children : <Navigate to="/login" replace/>
}
const App=()=> {
  return (
    <div>
      <Router>
        <Routes>
          
          <Route path="/landing" element={<Landing />} />
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Signup/>} />
          <Route path="/exchange-rate" element={<Exchangerates/>} />
          <Route path="/transaction" element={<Transaction/>} />
          <Route path="/users" element={<Users/>} />
          <Route path="/privacy-policy" element={<PrivacyPolicy/>} />
          <Route path="/terms-and-conditions" element={<TermsAndConditions/>} />
          <Route path="/faq" element={<FAQPage/>} />
          <Route path="/convertor" element={<CurrencyConvertor/>} />
          <Route path="/payment" element={<PaymentPage/>} />
          <Route path="/review" element={<FeedbackPage/>} />
          <Route path="/feedbacks" element={<AdminFeedbacks/>} />
          <Route path="/content" element={<Chart/>} />
          <Route path="/contactus" element={<ContactUs/>} />
          <Route path="/dashboard" element={
          
              <App1/>
           
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
