package com.research.summarizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.ObjectMapper;

@Service
public class WeatherServiceImpl {
    @Value("${weather.key}")
    private String weatherKey;
    @Value("${weather.url}")
    private String weatherUrl;
    @Autowired
    private  WebClient webClient;
    @Autowired
    private ObjectMapper objectMapper;

    public String createRequest(Double latitude, Double longitude) {

        String url=weatherUrl+"lat="+latitude+"&lon="+longitude+"&appid="+weatherKey;
        WeatherResponse response =webClient.post().uri(url)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
        return response.toString();

    }


}
