import React, { useState } from "react";
import Header from "./Header";
import Sidebar from "./Sidebar";
import "../assets/css/App.css"; // Import the CSS file
import Footer from "./Footer";

const Users = () => {
  // Sample user profile data
  const userProfiles = [
    {
      id: 1,
      userName: "Tharuniyaa",
      email: "tharuniyaa@example.com",
      contact:"6765543434",
      country: "USA",
      age: 25,
    },
    {
      id: 2,
      userName: "Jayakanth",
      email: "jayakanth@example.com",
      contact:"6564356765",
      country: "UK",
      age: 30,
    },
    // Add more user profiles here
  ];

  return (
    <div className="user-profile-container">
      <h2>User Profiles</h2>
      <table className="user-profile-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Country</th>
            <th>Age</th>
          </tr>
        </thead>
        <tbody>
          {userProfiles.map((userProfile) => (
            <tr key={userProfile.id}>
              <td>{userProfile.id}</td>
              <td>{userProfile.userName}</td>
              <td>{userProfile.email}</td>
              <td>{userProfile.contact}</td>
              <td>{userProfile.country}</td>
              <td>{userProfile.age}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Users;
