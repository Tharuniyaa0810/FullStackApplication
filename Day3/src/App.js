import * as React from 'react';
import { BrowserRouter as Router,Route,Routes } from 'react-router-dom';
import Signup from './components/Signup';
import Login from './components/Login';
function App() {
  return (
    <div >
      <Router>
        <Routes>
          <Route path='/' element={<Signup/>}></Route>
          <Route path='/login' element={<Login/>}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
