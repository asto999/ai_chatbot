package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Client.PythonServiceClient;
import com.example.demo.DTO.ChatDto;
import com.example.demo.Entity.ChatMessage;
import com.example.demo.Entity.Conversation;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ChatMessageRepository;
import com.example.demo.Repository.ConversationRepository;
import com.example.demo.Repository.UserRepository;
//should get conversation by userid method be in user or in conversation 
@Service
public class ChatService {
	@Autowired
	PythonServiceClient pythonClient;

	@Autowired
	ChatMessageRepository chatMessageRepository;
	
	@Autowired
	ConversationRepository conversationRepository;
	@Autowired
	UserRepository userRepository;

	public ChatDto processPrompt(ChatDto chat) {

	    // 1. Verify user exists
	    User user = userRepository.findById(chat.getUserId())
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // 2. Find conversation
	    Conversation conversation = conversationRepository
	            .findById(chat.getChatId())
	            .orElseThrow(() -> new RuntimeException("Conversation not found"));

	    // 3. Verify conversation belongs to this user
	    if (conversation.getUser().getId() != user.getId()) {
	        throw new RuntimeException("Conversation does not belong to user");
	    }

	    // 4. Save USER message
	    ChatMessage userMessage = new ChatMessage();
	    userMessage.setSender("USER");
	    userMessage.setMessage(chat.getMessage());
	    userMessage.setTime(LocalDateTime.now());
	    userMessage.setConversation(conversation);

	    chatMessageRepository.save(userMessage);

	    // 5. Send message to Python AI
	    String aiResponse = pythonClient
	            .callPythonService(chat.getMessage())
	            .getResponse();

	    // 6. Save AI message
	    ChatMessage aiMessage = new ChatMessage();
	    aiMessage.setSender("AI");
	    aiMessage.setMessage(aiResponse);
	    aiMessage.setTime(LocalDateTime.now());
	    aiMessage.setConversation(conversation);

	    chatMessageRepository.save(aiMessage);

	    // 7. Return AI response to frontend
	    ChatDto response = new ChatDto();
	    response.setMessage(aiResponse);
	    response.setChatId(chat.getChatId());
	    response.setUserId(chat.getUserId());

	    return response;
	}
	
	public long createNewConversation(long id) {
		//get user id 
		//create new conversation set user id 
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		Conversation conversation = new Conversation();
		conversation.setUser(user);
		conversation.setCreateAt(LocalDateTime.now());
		Conversation savedConversation= conversationRepository.save(conversation);
		return savedConversation.getId();
	}
	//get conversation by user id 
	public List<Conversation> getConversationByUserId(Long id) {
		return conversationRepository.findByUserId(id);
	}
	
	//get chat history by conversation id 
	public List<ChatMessage> getChatMessagesByConversationId(Long id){
		return chatMessageRepository.findByConversationId(id);
	}

}
