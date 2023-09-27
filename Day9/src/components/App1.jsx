import React, { useState } from 'react';
import '../assets/css/App.css';
import Header from './Header';
import Content from './Content';
import Footer from './Footer';
import logo from '../assets/logo.png';
import {
  BsGrid1X2Fill,
  BsFillArchiveFill,
  BsFillGrid3X3GapFill,
  BsPeopleFill,
  BsMenuButtonWideFill,
  BsFillGearFill,
} from 'react-icons/bs';
import Exchangerates from './ExchangeRates';
import Transaction from './Transaction';
import Users from './Users';
import FeedbackPage from './Feedback';
import AdminFeedbacks from './AdminFeedbacks';
import WalletAdmin from './WalletAdmin';

const App1 = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);
  const [activeMenuItem, setActiveMenuItem] = useState('Dashboard'); // Initialize with the default menu item

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };

  const handleMenuItemClick = (menuItem) => {
    console.log(`Clicked on menu item: ${menuItem}`);
    setActiveMenuItem(menuItem);
  };

  const renderContent = () => {
    console.log('Rendering content for:', activeMenuItem);
    switch (activeMenuItem) {
      case 'Dashboard':
        return <Content/>;
      case 'Exchange Rates':
        return <Exchangerates/>;
      case 'Transactions':
        return <Transaction/>;
      case 'Users':
        return <Users/>;
      case 'Feedbacks':
        return <AdminFeedbacks/>;
      case 'Multi-Sig Wallet':
        return <WalletAdmin/>;
      case 'Settings':
        return <div>Settings Content</div>;
      default:
        return null; // Default content when no menu item is selected
    }
  };

  return (
    <div className='grid-container'>
      <Header OpenSidebar={OpenSidebar} />

      {/* Sidebar code */}
      <aside id='sidebar' className={openSidebarToggle ? 'sidebar-responsive' : ''}>
        <div className='sidebar-title'>
          <div className='sidebar-brand'>
            <img src={logo} alt='logo'></img>
            <h1>ForexFlare</h1>
          </div>
          <span className='icon close_icon' onClick={OpenSidebar}>
            X
          </span>
        </div>

        <ul className='sidebar-list'>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Dashboard' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Dashboard')}
          >
            <BsGrid1X2Fill className='icon' /> Dashboard
          </li>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Exchange Rates' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Exchange Rates')}
          >
            <BsFillArchiveFill className='icon' /> Exchange Rates
          </li>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Transactions' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Transactions')}
          >
            <BsFillGrid3X3GapFill className='icon' /> Transactions
          </li>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Users' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Users')}
          >
            <BsPeopleFill className='icon' /> Users
          </li>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Feedbacks' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Feedbacks')}
          >
            <BsMenuButtonWideFill className='icon' /> Feedbacks
          </li>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Multi-Sig Wallet' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Multi-Sig Wallet')}
          >
            <BsMenuButtonWideFill className='icon' /> Multi-Sig Wallet
          </li>
          <li
            className={`sidebar-list-item ${activeMenuItem === 'Settings' ? 'active' : ''}`}
            onClick={() => handleMenuItemClick('Settings')}
          >
            <BsFillGearFill className='icon' /> Settings
          </li>
        </ul>
      </aside>

      {/* Render content based on the activeMenuItem */}
      <main className='main-content' >{renderContent()}</main>

      <Footer />
    </div>
  );
};

export default App1;
