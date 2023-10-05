import React, { useState } from "react";
import Header from "./Header";
import Sidebar from "./Sidebar";
import '../assets/css/App.css'; 
import Footer from "./Footer";

const Exchangerates = () => {
  

  const exchangeRates = {
    USD: { symbol: "$", rate: 1.0 },
  EUR: { symbol: "€", rate: 0.94 },
  GBP: { symbol: "£", rate: 0.73 },
  JPY: { symbol: "¥", rate: 110.46 },
  AUD: { symbol: "A$", rate: 1.34 },
  CAD: { symbol: "C$", rate: 1.26 },
  INR: { symbol: "₹", rate: 83.11 },
  };

  return (
    <div className="exchange-container">
      
      <div className="exchange-rates">
        <h2>Currency Exchange Rates</h2>
        <div className="exchange-rate-cards">
          {Object.keys(exchangeRates).map((currency) => (
            <div className="exchange-rate-card" key={currency}>
              <div className="card-header">
                <div className="currency-symbol">{exchangeRates[currency].symbol}</div>
                <div className="currency-name">{currency}</div>
              </div>
              <div className="exchange-rate-value">{exchangeRates[currency].rate}</div>
            </div>
          ))}
        </div>
      </div>
  
    </div>
  );
};

export default Exchangerates;
