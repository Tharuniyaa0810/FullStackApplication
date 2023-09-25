import React, { useEffect, useState } from 'react';
import '../assets/css/App.css'
import CurrencyExchangeIcon from '@mui/icons-material/CurrencyExchange';
import { useNavigate } from 'react-router-dom';
import { useWallet } from './context/WalletContext';


const exchangeRates = {
  USD: {
    EUR: 0.94,
    GBP: 0.73,
    JPY: 110.46,
    AUD: 1.34,
    CAD: 1.26,
    INR: 83.11,
    // Include pairings with other currencies here
  },
  EUR: {
    USD: 1.06,
    GBP: 0.88,
    JPY: 123.45,
    AUD: 1.41,
    CAD: 1.33,
    INR: 86.72,
    // Include pairings with other currencies here
  },
  GBP: {
    USD: 1.37,
    EUR: 1.14,
    JPY: 142.57,
    AUD: 1.61,
    CAD: 1.51,
    INR: 98.42,
    // Include pairings with other currencies here
  },
  JPY: {
    USD: 0.0091,
    EUR: 0.0081,
    GBP: 0.0070,
    AUD: 0.0114,
    CAD: 0.0107,
    INR: 0.6495,
    // Include pairings with other currencies here
  },
  AUD: {
    USD: 0.7463,
    EUR: 0.7092,
    GBP: 0.6211,
    JPY: 87.57,
    CAD: 0.9398,
    INR: 51.78,
    // Include pairings with other currencies here
  },
  CAD: {
    USD: 0.7937,
    EUR: 0.7519,
    GBP: 0.6629,
    JPY: 93.52,
    AUD: 1.0631,
    INR: 55.94,
    // Include pairings with other currencies here
  },
  INR: {
    USD: 0.0136,
    EUR: 0.0115,
    GBP: 0.0102,
    JPY: 1.5402,
    AUD: 0.0193,
    CAD: 0.0179,
    // Include pairings with other currencies here
  },
  // Add more currencies here
};
function CurrencyConverter() {
  const [amount, setAmount] = useState('');
  const [fromCurrency, setFromCurrency] = useState('USD');
  const [toCurrency, setToCurrency] = useState('EUR');
  const [result, setResult] = useState('');
  const [showConfirmation, setShowConfirmation] = useState(false);
  const { wallet, setWallet } = useWallet();
  const navigate = useNavigate();

  // Log the result whenever it changes
  useEffect(() => {
    if (result) {
      console.log('Result:', result);
    }
  }, [result]);

  const convertCurrency = () => {
    if (amount && fromCurrency && toCurrency) {
      const parsedAmount = parseFloat(amount);

      if (!isNaN(parsedAmount)) {
        if (exchangeRates[fromCurrency] && exchangeRates[fromCurrency][toCurrency]) {
          const rateFromTo = exchangeRates[fromCurrency][toCurrency];
          const convertedAmountFromTo = parsedAmount * rateFromTo;

          setResult(`${parsedAmount.toFixed(2)} ${fromCurrency} = ${convertedAmountFromTo.toFixed(2)} ${toCurrency}`);
          setShowConfirmation(true);
        } else {
          setResult('Invalid currency pair');
        }
      } else {
        setResult('Invalid amount');
      }
    }
  };

  const handleConfirmation = (proceed) => {
  if (proceed) {
    if (result.includes('=')) {
      const match = result.match(/(\d+\.\d+) (\w+) = (\d+\.\d+) (\w+)/);

      if (match && match.length === 5) {
        const [, inputAmount, fromCurrency, convertedAmount, targetCurrency] = match;

        if (!isNaN(parseFloat(convertedAmount))) {
          // Calculate the deduction from the 'fromCurrency'
          const deduction = parseFloat(inputAmount);

          // Check if there is enough balance in the 'fromCurrency' wallet
          if (wallet[fromCurrency] >= deduction) {
            // Update the wallet state with the deduction from 'fromCurrency'
            setWallet((prevWallet) => ({
              ...prevWallet,
              [fromCurrency]: prevWallet[fromCurrency] - deduction,
              [targetCurrency]: (prevWallet[targetCurrency] || 0) + parseFloat(convertedAmount),
            }));

            // Navigate to the payment page
            navigate('/payment');
          } else {
            setResult('Insufficient Balance');
          }
        } else {
          console.error('Invalid converted amount:', convertedAmount);
        }
      } else {
        console.error('Invalid result format:', result);
      }
    }
  } else {
    setShowConfirmation(false);
  }
};

  

  return (
    <div className="App">
      <div className="input-container">
        <h1 className="app-title">Currency Converter</h1>
        <input
          type="text"
          placeholder="Enter amount"
          className="amount-input"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />
        <select
          className="from-currency-select"
          value={fromCurrency}
          onChange={(e) => setFromCurrency(e.target.value)}
        >
          {Object.keys(exchangeRates).map((currency) => (
            <option key={currency} value={currency}>
              {currency}
            </option>
          ))}
        </select>

        <select
          className="to-currency-select"
          value={toCurrency}
          onChange={(e) => setToCurrency(e.target.value)}
        >
          {Object.keys(exchangeRates).map((currency) => (
            <option key={currency} value={currency}>
              {currency}
            </option>
          ))}
        </select>
        <button className="convert-button" onClick={convertCurrency}>
          Convert
        </button>
        {result && <p className="conversion-result">{result}</p>}
        {showConfirmation && (
          <div className="confirmation-container">
            <p>Proceed to Transaction?</p>
            <button className="confirmation-button" onClick={() => handleConfirmation(true)}>Yes</button>
            <button className="confirmation-button" onClick={() => handleConfirmation(false)}>No</button>
          </div>
        )}
      </div>
    </div>
  );
}

export default CurrencyConverter;