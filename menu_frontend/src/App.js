import logo from './logo.svg';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './Home';
import Menu from './Menu'

function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Home />} />
              {/* Define other routes here */}
              <Route path="/menu" element={<Menu/>} />
          </Routes>
      </Router>
  );
}

export default App;
