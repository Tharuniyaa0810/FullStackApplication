import React from 'react';
import { Link } from 'react-router-dom';
import '../assets/css/ContactDetails.css'; // Import your Contact Us page styles if you have them

const ContactUs = () => {
  return (
    <div className='contact-us-container'>
      <h2 className='contact-us-title'>Contact Us</h2>

      <div className='contact-info'>
        <p className='contact-info-item'>
          <strong className='contact-info-label'>Company Name:</strong> Your Company Name
        </p>
        <p className='contact-info-item'>
          <strong className='contact-info-label'>Address:</strong> 123 Main Street, City, Country
        </p>
        <p className='contact-info-item'>
          <strong className='contact-info-label'>Phone:</strong> +1 (123) 456-7890
        </p>
        <p className='contact-info-item'>
          <strong className='contact-info-label'>Email:</strong> info@example.com
        </p>
        <p className='contact-info-item'>
          <strong className='contact-info-label'>Hours of Operation:</strong> Monday-Friday: 9:00 AM - 5:00 PM
        </p>
      </div>

      <div className='contact-form'>
        <h3 className='contact-form-title'>Send us a message</h3>
        <form className='contact-form-fields'>
          <div className='form-group'>
            <label htmlFor='name' className='form-label'>Name:</label>
            <input type='text' id='name' name='name' className='form-input' required />
          </div>
          <div className='form-group'>
            <label htmlFor='email' className='form-label'>Email:</label>
            <input type='email' id='email' name='email' className='form-input' required />
          </div>
          <div className='form-group'>
            <label htmlFor='subject' className='form-label'>Subject:</label>
            <input type='text' id='subject' name='subject' className='form-input' required />
          </div>
          <div className='form-group'>
            <label htmlFor='message' className='form-label'>Message:</label>
            <textarea id='message' name='message' rows='4' className='form-textarea' required></textarea>
          </div>
          <button type='submit' className='form-submit-button'>Submit</button>
        </form>
      </div>

      <div className='social-media-links'>
        <h3 className='social-media-title'>Connect with Us</h3>
        <ul className='social-media-list'>
          <li className='social-media-item'>
            <Link to='/facebook' className='social-media-link'>
              <i className='fa fa-facebook'></i> Facebook
            </Link>
          </li>
          <li className='social-media-item'>
            <Link to='/twitter' className='social-media-link'>
              <i className='fa fa-twitter'></i> Twitter
            </Link>
          </li>
          <li className='social-media-item'>
            <Link to='/instagram' className='social-media-link'>
              <i className='fa fa-instagram'></i> Instagram
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default ContactUs;
