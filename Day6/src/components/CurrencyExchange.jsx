import React, { useState } from 'react';
import '../assets/css/CurrencyExchange.css'


function CurrencyConverter() {
  const [amount, setAmount] = useState(1);
  const [fromCurrency, setFromCurrency] = useState('USD');
  const [toCurrency, setToCurrency] = useState('EUR');
  const [exchangeRates] = useState({
    USD: 1.0,
    EUR: 0.85,
    GBP: 0.72,
    JPY: 110.34,
    INR: 73.5, // 1 USD = 73.5 INR (example rate)
    // Add more currencies and rates as needed
  });
  const [convertedAmount, setConvertedAmount] = useState(0);

  const handleAmountChange = (e) => {
    setAmount(e.target.value);
  };

  const handleFromCurrencyChange = (e) => {
    setFromCurrency(e.target.value);
  };

  const handleToCurrencyChange = (e) => {
    setToCurrency(e.target.value);
  };

  const convertCurrency = () => {
    const converted = (amount * exchangeRates[toCurrency]).toFixed(2);
    setConvertedAmount(converted);
  };

  return (
    <div>
      <h1>Currency Converter</h1>
      <div>
        <input type="number" value={amount} onChange={handleAmountChange} />
        <select value={fromCurrency} onChange={handleFromCurrencyChange}>
          <option value="USD">USD</option>
          <option value="EUR">EUR</option>
          <option value="GBP">GBP</option>
          <option value="JPY">JPY</option>
          <option value="INR">INR</option>
          {/* Add more currency options */}
        </select>
      </div>
      <div>
        <p>Equals</p>
        <p>{convertedAmount} {toCurrency}</p>
      </div>
      <div>
        <select value={toCurrency} onChange={handleToCurrencyChange}>
          <option value="USD">USD</option>
          <option value="EUR">EUR</option>
          <option value="GBP">GBP</option>
          <option value="JPY">JPY</option>
          <option value="INR">INR</option>
          {/* Add more currency options */}
        </select>
      </div>
      <button onClick={convertCurrency}>Convert</button>
    </div>
  );
}

export default CurrencyConverter;

