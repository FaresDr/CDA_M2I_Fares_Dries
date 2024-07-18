import React, { useEffect, useState } from 'react';
import { redirect, useNavigate } from 'react-router-dom';
import { todoService } from '../services/todoService';
import { jwtDecode } from 'jwt-decode';

const CreateTodo = () => {
    var accessTokenObj = JSON.parse(localStorage.getItem("user"));
        var token = accessTokenObj.data.token;
        var decoded = jwtDecode(token)
        console.log(decoded.roles)
        const navigate = useNavigate();
        useEffect( () => {
            if(decoded.roles === "ROLE_USER")
            navigate('/products')
        })
        
    const [todo, setTodo] = useState({
        title: '',
        description: '',
        done : false,
        user_id : decoded.user_id
    });
 

    const handleChange = (e) => {
        const { name, value } = e.target;
        setTodo(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await todoService.createTodo(todo);
            console.log('Product created successfully');
            // Réinitialiser le formulaire ou rediriger l'utilisateur
            setTodo({ title: '', description: '' });
            navigate('/products'); // Optionnel : redirigez l'utilisateur après succès
        } catch (error) {
            console.error('Error creating product:', error);
            // Gérer les erreurs ici, par exemple en informant l'utilisateur
        }
    };

    // Le code JSX reste le même que dans l'exemple précédent
    return (
        <div className="container mt-5">
        <h2>Créer un nouveau produit</h2>
        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor="productName" className="form-label">Nom</label>
                <input 
                    type="text" 
                    className="form-control" 
                    id="todotitle" 
                    name="title" 
                    value={todo.title} 
                    onChange={handleChange} 
                />
            </div>
            <div className="mb-3">
                <label htmlFor="productPrice" className="form-label">Prix</label>
                <input 
                    type="text" 
                    className="form-control" 
                    id="tododescription" 
                    name="description" 
                    value={todo.description} 
                    onChange={handleChange} 
                />
            </div>
            <button type="submit" className="btn btn-primary">Créer</button>
        </form>
    </div>
    );
};

export default CreateTodo;