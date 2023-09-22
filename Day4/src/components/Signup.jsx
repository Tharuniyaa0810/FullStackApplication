import React, { useEffect, useRef, useState } from 'react';
import '../assets/css/sign.css';
import { Link, useNavigate } from 'react-router-dom';
import Lottie from 'lottie-web';
import animationData from '../assets/lotties/sign-anim.json'
const Signup = () => {
  const navigate = useNavigate();
  const sign=useRef(null);
  useEffect(() => {
    const anim = Lottie.loadAnimation({
      container: sign.current,
      renderer: 'svg',
      loop: true,
      autoplay: true,
      animationData: animationData,
      rendererSettings: {
        // Set the width and height of the animation
        // Adjust these values as needed
        width: '45rem',
        height: '55rem',
      },
    });

    // Optionally, you can pause the animation when unmounting the component
    return () => {
      anim.destroy();
    };
  }, []);
  const SignbodyStyles = {
    fontFamily: 'Arial, sans-serif',
    margin: 0,
    padding: 0,
    height: '100vh',
  
    display: 'flex',
    justifyContent: 'flex-end',
    alignItems: 'center',
    overflow: 'hidden',
  };
  const [formdata, setFormdata] = useState({
    firstname: "",
    lastname: "",
    email: "",
    phone: "",
    password: "",
    confirmpassword: ""
  });

  const [errors, setErrors] = useState({});

  const handleOnChange = (e) => {
    const { name, value } = e.target;
    setFormdata({
      ...formdata,
      [name]: value
    });
   
    setErrors({
      ...errors,
      [name]: ""
    });
  };

  const validateForm = () => {
    const newErrors = {};

    if (formdata.firstname.trim() === "") {
      newErrors.firstname = "First name is required.";
    }

    if (formdata.lastname.trim() === "") {
      newErrors.lastname = "Last name is required.";
    }

    if (formdata.email.trim() === "") {
      newErrors.email = "Email is required.";
    }

    if (formdata.phone.trim() === "") {
      newErrors.phone = "Phone number is required.";
    }

    if (formdata.password.trim() === "") {
      newErrors.password = "Password is required.";
    }else {
      
      const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;
      if (!passwordRegex.test(formdata.password.trim())) {
        newErrors.password = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and be at least 8 characters long.";
      }
    }

    if (formdata.confirmpassword.trim() === "") {
      newErrors.confirmpassword = "Confirm password is required.";
    } else if (formdata.password !== formdata.confirmpassword) {
      newErrors.confirmpassword = "Passwords do not match.";
    }

    setErrors(newErrors);

  
    return Object.keys(newErrors).length === 0;
  };

  const submitForm = (e) => {
    e.preventDefault();

    if (validateForm()) {
     
      console.log("Form Submitted", formdata);
      navigate("/login");
    }
  };

  return (
    <div className='signwhole'>
    <div style={SignbodyStyles}>
    <div className='animation-sign-container'>
        <div ref={sign} className='anim-sign'></div>
      </div>
    <div className="sign-container">
      <h2 className='sign-heading'>Sign Up</h2>
      <form action="" onSubmit={submitForm}>
        <input type="text" name="firstname" id="firstname" onChange={handleOnChange} placeholder='Firstname' />
        {errors.firstname && <p className="error">{errors.firstname}</p>}
        
        <input type="text" name="lastname" id="lastname" onChange={handleOnChange} placeholder='Lastname' />
        {errors.lastname && <p className="error">{errors.lastname}</p>}
        
        <input type="text" name="email" id="email" onChange={handleOnChange} placeholder='E-Mail' />
        {errors.email && <p className="error">{errors.email}</p>}
        
        <input type="text" name="phone" id="phone" onChange={handleOnChange} placeholder='Phone Number' />
        {errors.phone && <p className="error">{errors.phone}</p>}
        
        <input type="password" name="password" id="password" onChange={handleOnChange} placeholder='Password' />
        {errors.password && <p className="error">{errors.password}</p>}
        
        <input type="password" name="confirmpassword" id="confirmpassword" onChange={handleOnChange} placeholder='Confirm Password' />
        {errors.confirmpassword && <p className="error">{errors.confirmpassword}</p>}
        
        <button type="submit">Signup</button>
        <p>Already have an account? <Link to="/login">Login</Link></p>
      </form>
    </div>
    </div>
    </div>
  );
};

export default Signup;
