import React, { useState } from "react";
import Header from "./Header";
import Sidebar from "./Sidebar";
import "../assets/css/Transaction.css"; // Import the CSS file
import Footer from "./Footer";

const Transaction = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };

  // Sample transaction data
  const transactions = [
    { id: 1, date: "2023-09-22", description: "Purchase Item A", amount: 50.00 },
    { id: 2, date: "2023-09-23", description: "Purchase Item B", amount: 75.00 },
    // Add more transactions here
  ];

  return (
    <div className="grid-container">
      <Header OpenSidebar={OpenSidebar} />
      <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar} />

      <div className="transaction-table-container">
        <h2>Transaction History</h2>
        <table className="transaction-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Date</th>
              <th>Description</th>
              <th>Amount</th>
            </tr>
          </thead>
          <tbody>
            {transactions.map((transaction) => (
              <tr key={transaction.id}>
                <td>{transaction.id}</td>
                <td>{transaction.date}</td>
                <td>{transaction.description}</td>
                <td>${transaction.amount.toFixed(2)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <Footer />
    </div>
  );
};

export default Transaction;
