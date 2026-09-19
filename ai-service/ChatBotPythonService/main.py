from fastapi import FastAPI,Request,HTTPException
from groq import AsyncGroq
from dotenv import load_dotenv
import os

load_dotenv()

app = FastAPI()

groq_api_key = os.getenv("GROQ_API_KEY")
if not groq_api_key:
    raise RuntimeError("GROQ_API_KEY is not set. Add it to ai-service/ChatBotPythonService/.env")

client = AsyncGroq(api_key=groq_api_key)


@app.get("/api/ai/models")
async def get_all_models():
    try:
        models_page = await client.models.list()
        model_list=[]
        for model in models_page.data:
              model_list.append({
                "id": model.id,
                "owned_by": model.owned_by,
                "active": model.active if hasattr(model, 'active') else True
            })
            
        return {"models": model_list}
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Failed to fetch models: {str(e)}")
   
        

@app.post("/api/ai/chat")
async def chat_with_ai(request:Request):
    data  = await request.json()
    user_query = data.get("message")
    print(user_query)
    if not user_query:
        return {"error":"Missing message field"},400
    completion  = await client.chat.completions.create(
        model="openai/gpt-oss-120b",
        messages=[
            {"role":"system","content":"you are a helpful chat bots "},
            {"role":"user","content":user_query}
        ],
        temperature=0.7,
        max_tokens=1024
    )
    ai_response = completion.choices[0].message.content
    return {"response":ai_response}
