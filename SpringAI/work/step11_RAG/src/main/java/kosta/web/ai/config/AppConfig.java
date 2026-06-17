package kosta.web.ai.config;

import kosta.web.ai.tools.DateTimeTools;
import kosta.web.ai.tools.EmbedingTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

    @Value("classpath:/prompts/system.st")
    private Resource resource;

    private final DateTimeTools dateTimeTools;
    private final EmbedingTools embedingTools;

    public AppConfig(DateTimeTools dateTimeTools, EmbedingTools embedingTools) {
        this.dateTimeTools = dateTimeTools;
        this.embedingTools = embedingTools;
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder,
                                 ToolCallbackProvider tools, VectorStore vectorStore) {

        ChatMemory chatMemory = MessageWindowChatMemory
                .builder()
                .maxMessages(10)
                .build();

        MessageChatMemoryAdvisor chatMemoryAdvisor = MessageChatMemoryAdvisor
                .builder(chatMemory)
                .build();

        QuestionAnswerAdvisor questionAnswerAdvisor =
                QuestionAnswerAdvisor.builder(vectorStore)
                        .searchRequest(
                                SearchRequest.builder()
                                        .topK(5)
                                        .build()
                        )
                        .build();

        return chatClientBuilder
                .defaultSystem(resource)
                .defaultAdvisors(chatMemoryAdvisor, questionAnswerAdvisor)
                .defaultTools(dateTimeTools, embedingTools)
                .defaultToolCallbacks(tools)
                .build();

    }

}
