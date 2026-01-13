package com.research.weather.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WeatherServiceImpl {
    @Value("${weather.key}")
    private String weatherKey;
    @Value("${weather.url}")
    private String weatherUrl;
    @Autowired
    private  WebClient webClient;
    public WeatherResponse getWeatherDetails(String unit, String cityName) {
        log.info("Weather Key: {}", weatherKey);
        if(cityName==null || cityName.isEmpty()){
           return null;
        }
        String url=weatherUrl+"units="+unit+"&q="+cityName+"&appid="+weatherKey;
        System.out.println(url);
        WeatherResponse response =webClient.post().uri(url)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
        return response;

    }


}
