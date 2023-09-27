import React from 'react';
import '../assets/css/market.css';

const MarketInsightsTable = ({ isVisible }) => {
  // Dummy data for market insights
  const marketInsightsData = [
    { currency: 'USD', value: '1.23', change: '+0.05' },
    { currency: 'EUR', value: '0.89', change: '-0.03' },
    { currency: 'GBP', value: '1.42', change: '+0.08' },
    { currency: 'JPY', value: '110.25', change: '-0.12' },
    { currency: 'AUD', value: '1.33', change: '+0.04' },
    { currency: 'CAD', value: '1.28', change: '-0.02' },
    { currency: 'CHF', value: '0.98', change: '+0.07' },
  { currency: 'CNY', value: '6.45', change: '-0.04' },
  { currency: 'INR', value: '73.55', change: '+0.03' },
  { currency: 'NZD', value: '1.46', change: '-0.01' },
  { currency: 'BRL', value: '5.20', change: '-0.09' },
  { currency: 'ZAR', value: '14.30', change: '+0.06' },
  { currency: 'SGD', value: '1.34', change: '+0.02' },
  { currency: 'SEK', value: '8.75', change: '-0.01' },
  { currency: 'NOK', value: '9.20', change: '+0.05' },
  { currency: 'MXN', value: '20.05', change: '-0.07' },
  { currency: 'KRW', value: '1201.50', change: '+0.10' },
  { currency: 'HKD', value: '7.78', change: '-0.03' },
  { currency: 'TRY', value: '9.20', change: '+0.12' },
    // Add more data as needed
  ];

  return (
    <div className={`market-insights ${isVisible ? 'visible' : 'hidden'}`}>
      <h2 className='markettablename'>Market Insights</h2>
      <table>
        <thead>
          <tr>
            <th>Currency</th>
            <th>Value</th>
            <th>Change</th>
          </tr>
        </thead>
        <tbody>
          {marketInsightsData.map((item, index) => (
            <tr key={index}>
              <td>{item.currency}</td>
              <td>{item.value}</td>
              <td>{item.change}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MarketInsightsTable;