import React from 'react'
import 
 {BsFillBellFill, BsFillEnvelopeFill, BsPersonCircle, BsSearch, BsJustify}
 from 'react-icons/bs'
import { useSelector } from 'react-redux';
import { selectUser } from './redux/UserSlice';

function Header({OpenSidebar}) {
  const user = useSelector(selectUser);
  const username = user.user && user.user.username ? user.user.username : 'Guest';

  return (
    <header className='header'>
        <div className='menu-icon'>
            <BsJustify className='icon' onClick={OpenSidebar}/>
        </div>
        <p>Welcome, {username}!</p>

        
    </header>
  )
}

export default Header