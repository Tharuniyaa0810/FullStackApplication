import React, { useEffect, useRef, useState } from 'react';
import '../assets/css/login.css';
import { Link, useNavigate } from 'react-router-dom';
import {useDispatch} from 'react-redux';
import { login } from './redux/UserSlice';
import Lottie from 'lottie-web';
import animationData from '../assets/lotties/login-anim.json'
import { useUser } from './context/UserContext';

const Login = () => {
  const dispatch = useDispatch();
  const navigate=useNavigate();
  const {login:userLogin}=useUser();
  const container=useRef(null);
  useEffect(() => {
    const anim = Lottie.loadAnimation({
      container: container.current,
      renderer: 'svg',
      loop: true,
      autoplay: true,
      animationData: animationData,
    });

    // Optionally, you can pause the animation when unmounting the component
    return () => {
      anim.destroy();
    };
  }, []);
  
  const LoginbodyStyles = {
    fontFamily: 'Arial, sans-serif',
    margin: 0,
    padding: 0,
    /* backgroundImage: 'url("../backl.png")', */
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
    backgroundPosition: 'center',
    display: 'flex',
    justifyContent: 'flex-end',
    alignItems: 'center',
    height: '96vh',
  };
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
      userLogin();
      dispatch(login(formdata.username)); // Pass just the username as the payload
    navigate("/dashboard");
     
    }

  };
  

  return (
    <div className='whole'>
    <div style={LoginbodyStyles} className='center-container'>
     
      <div className='animation-container'>
        <div ref={container} className='animcon'></div>
      </div>
      <div className="login-container">
        <h2 className='login-heading'>Login</h2>
        <form action="" onSubmit={submitForm}>
          <label >Username</label>
          <input
            type="text"
            name="username"
            id="username"
            onChange={handleOnChange}
            placeholder='Username'
          />
          <label >Password</label>
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
        <p><Link to="/forgot">Forgot Password?</Link></p> {/* Add this line */}
      </div>
      </div>
    </div>
  );
  
};

export default Login;
