package com.example.demo.Client;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DTO.PredictResponseDto;
@Service
public class PythonServiceClient {
	private final WebClient webClient;
	public PythonServiceClient() {
		
		 this.webClient = WebClient.create("http://localhost:8000");
	}
	

	public PredictResponseDto callPythonService(String message) {
		Map<String,Object> requestBody = Map.of("message",message);
		return webClient.post()
				.uri("/api/ai/chat")
				.bodyValue(requestBody)
				.retrieve()
				.bodyToMono(PredictResponseDto.class)
				.block();
	}
}
