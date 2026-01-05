package com.research.summarizz;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class ResearchServiceImpl {
    @Value("${gemini.api.key}")
    private String geminiApiKey;
    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    public String createRequest(ResearchRequest request) {
        String prompt=buildPrompt(request);

        Map<String,Object> requestBody= Map.of("contents",new Object[]{
                                            Map.of("parts", new Object[]{
                                                Map.of("text", prompt)
                                                })
                                            }
                                         );


        ResearchResponse researchResponse=new ResearchResponse();
        return researchResponse.toString();

    }

    private String buildPrompt(ResearchRequest request){
        StringBuilder prompt= new StringBuilder();
        switch (request.getQuery()){
            case "summarize" :
                prompt.append("Provide a clear and concise summary of the following text in a few sentences:\n\n");
                break;
            case "suggest topics" :
                prompt.append("Analyze the following text and suggest relevant research topics based on its content:\n\n");
                break;
            default:
                throw new IllegalArgumentException("Invalid query type: " + request.getQuery());
        }
        prompt.append(request.getContent());
        return prompt.toString();
    }
}
