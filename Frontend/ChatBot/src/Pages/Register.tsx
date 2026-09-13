import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Register = () => {
    const navigate  = useNavigate();
    // State management for inputs
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    // Handle form submission and API call
    const handleRegister = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        
        try {
            const response = await fetch('http://127.0.0.1:8090/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });

            if (response.ok) {
                alert('Registration successful!');
                navigate("/main_page")
            } else {
                alert('Registration failed.');
            }
        } catch (error) {
            console.error('Error during registration:', error);
        }
    };

  const handleLogin=()=>{
navigate("/login")
  }

    return (
        <div>
            <form onSubmit={handleRegister}>
                <input 
                    type="text" 
                    placeholder="Username" 
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)} 
                />
                <input 
                    type="password" 
                    placeholder="Password" 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                />
                <button type="submit">Register</button>
            </form>
            <button onClick={handleLogin}>Login</button>
        </div>
    );
};

export default Register;
