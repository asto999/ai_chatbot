import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const navigate = useNavigate();
    // State management for inputs
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    // Handle form submission and login API call
    const handleLogin = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        
        try {
            const response = await fetch('http://127.0.0.1:8090/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });

            if (response.ok) {
                const data = await response.json();
                alert('Login successful!');
                navigate("/main_page");
                // You can handle tokens here (e.g., localStorage.setItem('token', data.token))
            } else {
                alert('Invalid credentials.');
            }
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

     const handleRegister=()=>{
navigate("/register")
  }
    return (
        <div>
            <form onSubmit={handleLogin}>
                <input 
                    type="text" 
                    placeholder="Email" 
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)} 
                />
                <input 
                    type="password" 
                    placeholder="Password" 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                />
                <button type="submit">Login</button>
            </form>
              <button onClick={handleRegister}>Register</button>
        </div>
    );
};

export default Login;
