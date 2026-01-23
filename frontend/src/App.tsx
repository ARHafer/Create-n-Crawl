import './App.css'
import { Route, Routes } from 'react-router-dom';
import CommandPage from './pages/CommandPage';
import HomePage from './pages/HomePage';

function App() {

  return (
    <Routes>
      <Route path="/" element={<HomePage/>} />
      <Route path="/command" element={<CommandPage/>} />
    </Routes>
  )

}

export default App
