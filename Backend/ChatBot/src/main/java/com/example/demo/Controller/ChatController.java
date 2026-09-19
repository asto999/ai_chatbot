package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.DTO.ChatDto;
import com.example.demo.Entity.ChatMessage;
import com.example.demo.Entity.Conversation;
import com.example.demo.Entity.User;
import com.example.demo.Service.ChatService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/conversation")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	@PostMapping("/processPrompt")
	public ResponseEntity<ApiResponseDTO<ChatDto>> processPrompt(@RequestBody ChatDto chat){
		//get chat from user send to python service save history in db return
		ChatDto response =  chatService.processPrompt(chat);
		return ResponseEntity.ok(new ApiResponseDTO<>("Prompt processed successfully", true, response));
		
		
	}
	 
	@GetMapping("/getConversationByUserId")
	public ResponseEntity<ApiResponseDTO<List<Conversation>>> getConversationByUserId(@RequestParam("id") long id){
		List<Conversation> conversations = chatService.getConversationByUserId(id);
		return ResponseEntity.ok(new ApiResponseDTO<>("fetched conversations",true,conversations));
	}
	
	@GetMapping("/getChatsByConversationId")
	public ResponseEntity<ApiResponseDTO<List<ChatMessage>>> getChatsByConversation(@RequestParam("id") long id){
		List<ChatMessage> chatMessages = chatService.getChatMessagesByConversationId(id);
		return ResponseEntity.ok(new ApiResponseDTO<>("fetched chats",true,chatMessages));
	}
	
	

}
