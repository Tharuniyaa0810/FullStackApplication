import React from 'react';
import { Link } from 'react-router-dom';
import '../assets/css/App.css';
import 'font-awesome/css/font-awesome.min.css'; // Import Font Awesome CSS
import '../assets/css/App.css'; // Import your footer styles if you have them

const Footer = () => {
  return (
    <footer className='footer-container'>
      <div className='footer-content'>
        <div className='footer-links'>
          <ul>
            <li>
              <Link to='/privacy-policy'>Privacy Policy</Link>
            </li>
            <li>
              <Link to='/terms-and-conditions'>Terms and Conditions</Link>
            </li>
            <li>
              <Link to='/faq'>FAQ</Link>
            </li>
            <li>
              <Link to='/contactus'>Contact</Link>
            </li>
          </ul>
        </div>
        <div className='footer-social-media'>
          {/* Add social media icons here */}
          
            <i className='fa fa-facebook'></i>
     
        
            <i className='fa fa-twitter'></i>
      
    
            <i className='fa fa-instagram'></i>
       
        </div>
        <div className='footer-info'>
          &copy; {new Date().getFullYear()} ForexFlare
        </div>
      </div>
    </footer>
  );
};

export default Footer;
