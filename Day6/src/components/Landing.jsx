import React from 'react'
import { Link } from 'react-router-dom'

function Landing() {
  return (
    <div>
       <Link to="/review"> <button>button</button></Link>
       <Link to="/convertor"> <button>con</button></Link>
    </div>

  )
}

export default Landing