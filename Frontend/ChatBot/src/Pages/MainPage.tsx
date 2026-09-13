import { useState } from "react";

const MainPage =()=>{
    const[message,setMessage] = useState("");
    const [reply,setReply] = useState("");
    const handleMessage = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();
        
        try {
            const response = await fetch('http://127.0.0.1:8090/processPrompt', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
             body: JSON.stringify({ id: 1, sender: "user", message: message }),
            });

            const data = await response.json()
          if (data.success) {
    setReply(data.body.message);
}
            console.log(data);

           
        } catch (error) {
            console.error('Error during login:', error);
        }
    };
    return (
<div>
    main page
    <h1>{reply}</h1>
    <input placeholder="type..." onChange={(e) => setMessage(e.target.value)} />

    <button onClick={handleMessage}>send</button>
</div>
    )
}
export default MainPage;