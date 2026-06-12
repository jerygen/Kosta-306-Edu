package kosta.web.ai.controller;

import jakarta.annotation.PostConstruct;
import kosta.web.ai.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
//    private ChatClient chatClient;
//
//    public ChatController(ChatClient.Builder builder){
//        this.chatClient = builder.build();
//    }
//
//    @PostConstruct
//    public void init() {
//        System.out.println("ChatController initialized with chatCline: "+chatClient);
//    }
    @Autowired
    private ChatService chatService;


    @GetMapping("/chat")
    public String chat(String message){
        return chatService.chat(message);
    }



}
