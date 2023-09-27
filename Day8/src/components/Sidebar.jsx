import React from 'react'
import 
{BsCart3, BsGrid1X2Fill, BsFillArchiveFill, BsFillGrid3X3GapFill, BsPeopleFill, 
  BsListCheck, BsMenuButtonWideFill, BsFillGearFill}
 from 'react-icons/bs'
import logo from '../assets/logo.png'
import { Link } from 'react-router-dom';
function Sidebar({openSidebarToggle, OpenSidebar}) {
  return (
    <aside id="sidebar" className={openSidebarToggle ? "sidebar-responsive": ""}>
        <div className='sidebar-title'>
            <div className='sidebar-brand'>
               <img src={logo} alt='logo'></img>
               <h1>ForexFlare</h1>
            </div>
            <span className='icon close_icon' onClick={OpenSidebar}>X</span>
        </div>

        <ul className='sidebar-list'>
            <li className='sidebar-list-item'>
            
                    <BsGrid1X2Fill className='icon'/> Dashboard
                  
            </li>
            <li className='sidebar-list-item'>
                    <BsFillArchiveFill className='icon'/> Exchange Rates
            </li>
            <li className='sidebar-list-item'>
                    <BsFillGrid3X3GapFill className='icon'/> Transactions
            </li>
            <li className='sidebar-list-item'>
                    <BsPeopleFill className='icon'/> Users

            </li>
          
            <li className='sidebar-list-item'>
              
                    <BsMenuButtonWideFill className='icon'/> Feedbacks
             
            </li>
            <li className='sidebar-list-item'>
               
                    <BsFillGearFill className='icon'/> Settings
             
            </li>
        </ul>
    </aside>
  )
}

export default Sidebar;