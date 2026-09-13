import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import MainPage from './Pages/MainPage'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Login from './Pages/Login'
import Register from './Pages/Register'

function App() {

  return (
    <>
   <BrowserRouter>
   <Routes>
    <Route element={<Login/>} path='/login'/>
    <Route element={<Register/>} path='/register'/>
    <Route element={<MainPage/>} path='/main_page'/>
   </Routes>
   </BrowserRouter>
    </>
  )
}

export default App
