import './App.css'
import Homepage from "./components/homepage/homepage"
import Login from "./components/login/login"
import Register from "./components/register/register"
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from 'react';
import Protected from './components/Protected';
import { AuthProvider } from './context/AuthContext';
import CryptoData from './components/cryptoData/CryptoData';
function App() {




  return (
    <AuthProvider>
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/home" element={<Protected Component={Homepage} />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
      
    </div>
    <CryptoData />
    </AuthProvider>
  );
}

export default App;
