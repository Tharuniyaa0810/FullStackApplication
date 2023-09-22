import React, { useEffect, useRef, useState } from 'react';
import '../assets/css/ForgotPassword.css';
import Lottie from 'lottie-web';
import animationData from '../assets/lotties/forgot-anim.json';

function ForgotPassword() {
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const containanim= useRef(null);

  useEffect(() => {
    const anim = Lottie.loadAnimation({
      container: containanim.current,
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

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // Placeholder message for demonstration
    setMessage('Password reset email sent. Check your inbox.');
  };

  return (
    <div className="container">
      <div className="animation-contain">
        <div ref={containanim} className="animcon"></div>
      </div>
      <div className="forgot-password-container">
        <h2 className="forgot-password-title">Forgot Password</h2>
        <form className="forgot-password-form" onSubmit={handleSubmit}>
          <label className="form-label">
            Email:
            <input
              type="email"
              value={email}
              onChange={handleEmailChange}
              className="form-input"
              required
              />
          </label>
              {message && <p className="success-message">{message}</p>}
          <button type="submit" className="submit-button">
            Reset Password
          </button>
        </form>
      </div>
    </div>
  );
}

export default ForgotPassword;
