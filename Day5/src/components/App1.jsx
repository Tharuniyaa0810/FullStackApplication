import React, { useState } from 'react';
import '../assets/css/App.css';
import Header from './Header';
import Sidebar from './Sidebar';
import Home from './Home';
import Footer from './Footer';

const App1 = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };

  return (
    <div className='grid-container'>
      <Header OpenSidebar={OpenSidebar} />
   
        <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar} />
        <Home />
      
      <Footer />
    </div>
  );
};

export default App1;
