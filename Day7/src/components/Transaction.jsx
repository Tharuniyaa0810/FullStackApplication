import React, { useState } from "react";
import Header from "./Header";
import Sidebar from "./Sidebar";
import "../assets/css/App.css"; // Import the CSS file
import Footer from "./Footer";

const Transaction = () => {
  // Sample transaction data
  const transactions = [
    {
      id: 1,
      date: "2023-09-22",
    user:"Tharuniyaa",
      fromCurrency: "USD",
      toCurrency: "EUR",
    
      amount: 50.00,
    },
    {
      id: 2,
      date: "2023-09-23",
     user:"Jayakanth",
      fromCurrency: "EUR",
      toCurrency: "GBP",
    
      amount: 75.00,
    },
    // Add more transactions here
  ];

  return (
    <div className="transaction-table-container">
      <h2>Transaction History</h2>
      <table className="transaction-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Date</th>
            <th>User</th>
            <th>From Currency</th>
            <th>To Currency</th>
          
            <th>Amount</th>
          </tr>
        </thead>
        <tbody>
          {transactions.map((transaction) => (
            <tr key={transaction.id}>
              <td>{transaction.id}</td>
              <td>{transaction.date}</td>
              <td>{transaction.user}</td>
              <td>{transaction.fromCurrency}</td>
              <td>{transaction.toCurrency}</td>
           
              <td>{transaction.amount.toFixed(2)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Transaction;
