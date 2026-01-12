package com.research.weather;

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
//    https://api.openweathermap.org/data/2.5/weather?units=metric&q=Bangalore&appid=
    public WeatherResponse createRequest(String unit, String cityName) {
        String url=weatherUrl+"units="+unit+"&q="+cityName+"&appid="+weatherKey;
        WeatherResponse response =webClient.post().uri(url)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
        return response;

    }


}
