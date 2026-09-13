package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Client.PythonServiceClient;
import com.example.demo.DTO.ChatDto;

@Service
public class ChatService {
	@Autowired
	PythonServiceClient pythonClient;

	public ChatDto processPrompt(ChatDto chat) {
		System.out.println("Received message: " + chat.getMessage());
		ChatDto response = new ChatDto();
		response.setMessage(pythonClient.callPythonService(chat.getMessage()).getResponse());
		System.out.print(response.getMessage());
		return response;
	}

}
