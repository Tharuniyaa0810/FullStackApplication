import React, { useState } from 'react';
import '../assets/css/login.css';
import { Link } from 'react-router-dom';

const Login = () => {
  const [formdata, setFormdata] = useState({
    username: "",
    password: ""
  });

  const [error, setError] = useState(null);

  const handleOnChange = (e) => {
    const { name, value } = e.target;
    setFormdata({
      ...formdata,
      [name]: value
    });
  };

  const validateForm = () => {
    if (formdata.username.trim() === "" || formdata.password.trim() === "") {
      setError("Please enter both username and password.");
      return false;
    }
  
    const passwordRegex = /^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*\d).{8,}$/;
    if (!passwordRegex.test(formdata.password.trim())) {
      setError("Password must contain at least one uppercase letter, one special character, one digit and at least 8 characters long.");
      return false;
    }
  
    setError(null);
    return true;
  };
  

  const submitForm = (e) => {
    e.preventDefault();
    
    if (validateForm()) {
     
      console.log("Logging in with username:", formdata.username);
     
    }
  };

  return (
    <div className="login-container">
      <h2 className='login-heading'>Login</h2>
      <form action="" onSubmit={submitForm}>
        <input
          type="text"
          name="username"
          id="username"
          onChange={handleOnChange}
          placeholder='Username'
        />
        <input
          type="password"
          name="password"
          id="password"
          onChange={handleOnChange}
          placeholder='Password'
        />
      {error && <p className="error">{error}</p>}
        <button type="submit">Login</button>
      </form>
      <p>Don't have an account? <Link to="/">Create Account</Link></p>
    </div>
  );
};

export default Login;
