import React from 'react';
import { Link } from 'react-router-dom'; // Import Link from react-router-dom
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
              <Link to='/content'>Contact</Link>
            </li>
          </ul>
        </div>
        <div className='footer-info'>
          {/* Add any additional information or content you want in your footer */}
          &copy; {new Date().getFullYear()} ForexFlare
        </div>
      </div>
    </footer>
  );
};

export default Footer;
