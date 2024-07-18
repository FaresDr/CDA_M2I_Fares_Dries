import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Todolist from './components/TodoList';
import Header from './shared/Header';
import CreateTodo from './components/CreateTodo';
import PrivateRoute from './helpers/PrivateRoute'

function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/" element={<Login />} />

        {/* Protéger la route /products */}
        <Route path="/todos" element={
          <PrivateRoute>
            <Todolist />
          </PrivateRoute>
        } />

        {/* Protéger la route /create-product */}
        <Route path="/create-todos" element={
          <PrivateRoute>
            <CreateTodo />
          </PrivateRoute>
        } />
      </Routes>
    </Router>
  );
}
export default App;

