package com.research.summarizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;
@Service
public class ResearchServiceImpl {
    @Value("${gemini.api.key}")
    private String geminiApiKey;
    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Autowired
    private  WebClient webClient;
    @Autowired
    private ObjectMapper objectMapper;

    public String createRequest(ResearchRequest request) {
        String prompt=buildPrompt(request);

        Map<String,Object> requestBody= Map.of("contents",new Object[]{
                                            Map.of("parts", new Object[]{
                                                Map.of("text", prompt)
                                                })
                                            }
                                         );

        String response =webClient.post().uri(geminiApiUrl + geminiApiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return extractResponseContent(response);

    }

    private String extractResponseContent(String response) {
        try{
            ResearchResponse researchResponse= objectMapper.readValue(response, ResearchResponse.class);
            if(researchResponse.getCandidates()!=null && !researchResponse.getCandidates().isEmpty())
            {
                ResearchResponse.Candidate candidate= researchResponse.getCandidates().getFirst();
                if(candidate.getContent()!=null && candidate.getContent().getParts()!=null && !candidate.getContent().getParts().isEmpty()){
                    return candidate.getContent().getParts().getFirst().getText();
                } else {
                    throw new RuntimeException("Content is null or empty in the candidate.");
                }
            } else {
                throw new RuntimeException("No candidates found in the response.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse response: " + e.getMessage());
        }
    }

    private String buildPrompt(ResearchRequest request){
        StringBuilder prompt= new StringBuilder();
        switch (request.getOperation()){
            case "summarize" :
                prompt.append("Provide a clear and concise summary of the following text in a few sentences:\n\n");
                break;
            case "suggest topics" :
                prompt.append("Analyze the following text and suggest relevant research topics based on its content:\n\n");
                break;
            default:
                throw new IllegalArgumentException("Invalid query type: " + request.getOperation());
        }
        prompt.append(request.getContent());
        return prompt.toString();
    }
}
