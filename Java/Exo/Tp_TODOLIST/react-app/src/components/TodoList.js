import React, { useEffect, useState } from 'react';
import  {todoService}  from '../services/todoService';
import UpdateProductModal from './UpdateProductModal';
import { jwtDecode } from "jwt-decode";


function Todolist() {
  const [todos, setTodos] = useState([]);
  const [error, setError] = useState('');
  var accessTokenObj = JSON.parse(localStorage.getItem("user"));
  var token = accessTokenObj.data.token;
  var decoded = jwtDecode(token)
  useEffect(() => {    

    todoService.getAllTodos()
      .then(response => {
        console.log(response)
        setTodos(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  }, []);

  const loadProducts = () => {
    todoService.getAllTodos()
      .then(response => {
        setTodos(response.data);
      })
      .catch(error => {
        setError('Erreur lors de la récupération des produits.');
      });
  };

  const [selectedTodo, setSelectedTodo] = useState(null);

  const updateProduct = (todoData) => {
    console.log("product " + todoData.name)
    todoService.updateTodo(todoData)
      .then(() => {
        loadProducts();
        setSelectedTodo(null);
      })
      .catch(error => {
        setError('Erreur lors de la mise à jour du produit.');
      });
  };


  const deleteProduct = (todoId) => {
    todoService.deleteTodo(todoId)
      .then(() => {
        loadProducts();
      })
      .catch(error => {
        setError('Erreur lors de la suppression du produit.');
      });
  };
  


  return (
    <div className="container mt-5">
      <h2>Todo List</h2>
      <h3></h3>
      {error && <div className="alert alert-danger" role="alert">
        {error}
      </div>}
      <table className="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col" className='center'>Actions</th>

          </tr>
        </thead>
        <tbody>
          {todos.map((todo, index) => (
            decoded.roles === 'ROLE_USER'   ?(
            <tr key={todo.id}>
              <th scope="row">{index + 1}</th>
              <td>{todo.title}</td>
              <td>{todo.description}</td>              
              
            </tr>
            ) : decoded.roles != 'ROLE_USER' &&  todo.user_id === decoded.user_id  ?(  <tr key={todo.id}>
            <th scope="row">{index + 1}</th>
            <td>{todo.title}</td>
            <td>{todo.description}</td>              
            <td>
                <button className="btn btn-danger mr-4" onClick={() => deleteProduct(todo.id)}>Supprimer</button>
                <button className='btn btn-warning' onClick={() => setSelectedTodo(todo)}>Update</button>
              
               
              </td>             
            <td>
              
            
             
            </td>
          </tr>): null
          ))}
           {selectedTodo && (
                  <UpdateProductModal
                  todo={selectedTodo}
                    onSave={updateProduct}
                    onCancel={() => setSelectedTodo(null)}
                  />
                )}
        </tbody>
      </table>

    </div>
  );
}

export default Todolist;
