from fastapi import FastAPI,Request

app = FastAPI()

@app.post("/api/ai/chat")
async def chat_with_ai(request:Request):
    data = await request.json()
    user_query  = data.get("message")
    if not user_query:
        return {"error":"Missing message field"},400
    ai_response = "respone"
    return {"response":ai_response} 

