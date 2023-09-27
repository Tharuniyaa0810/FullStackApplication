import React from 'react';
import '../assets/css/ContactDetails.css';
import { Link } from 'react-router-dom';


const ContactDetails = () => {
  return (
    <footer className="contact-footer">
      <div className="contact-info">
        <h2>Contact Us</h2>
        <p>Email: ForexFlare@gmail.com</p>
        <p>Phone: +91 9161718191</p>
        <p>Address: 16/5, Main St, Coimbatore, Tamilnadu</p>
      </div>
      <div className="social-links">
        <h2 className='classcolorforfollow'>Follow Us</h2>
        <button className='link-button'>Facebook</button>
        <button className='link-button'>Twitter</button>
        <button className='link-button'>LinkedIn</button>
      </div>
      <br></br>
      <div className="additional-links">
  <Link to="/privacy" className="link-button">
    Privacy Policy
  </Link>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <Link to="/terms" className="link-button">
    Terms and Conditions
  </Link>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <Link to="/faq" className="link-button">
    FAQ
  </Link>
</div>

      <div className="copyright">
        <p>&#169; 2023 CURRENSYNC</p>
      </div>
    </footer>
  );
};

export default ContactDetails;