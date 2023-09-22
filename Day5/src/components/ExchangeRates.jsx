import React, { useState } from "react";
import Header from "./Header";
import Sidebar from "./Sidebar";
import '../assets/css/ExchangeRates.css'; 
import Footer from "./Footer";

const Exchangerates = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);
  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };

 
  const exchangeRates = [
    { currency: "USD", rate: 1.23 },
    { currency: "EUR", rate: 1.0 },
    { currency: "GBP", rate: 0.88 },
    { currency: "JPY", rate: 128.42 },
  ];

  return (
    <div className="grid-container">
      <Header OpenSidebar={OpenSidebar} />
      <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar} />
      
      <div className="exchange-rates">
        {exchangeRates.map((rate, index) => (
          <div className="exchange-rate" key={index}>
            <div className="exchange-rate-icon">{rate.currency}</div>
            <div className="exchange-rate-value">{rate.rate}</div>
          </div>
        ))}
      </div>
      <Footer />
    </div>
  );
};

export default Exchangerates;
