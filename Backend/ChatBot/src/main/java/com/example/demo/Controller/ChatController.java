package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.DTO.ChatDto;
import com.example.demo.Entity.User;
import com.example.demo.Service.ChatService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	@PostMapping("/processPrompt")
	public ResponseEntity<ApiResponseDTO<ChatDto>> processPrompt(@RequestBody ChatDto chat){
		//get chat from user send to python service save history in db return
		ChatDto response =  chatService.processPrompt(chat);
		return ResponseEntity.ok(new ApiResponseDTO<>("Prompt processed successfully", true, response));
		
		
	}
	

}
