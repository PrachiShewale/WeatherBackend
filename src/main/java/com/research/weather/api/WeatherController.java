package com.research.weather.api;

import com.research.weather.bo.WeatherResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")//allow accessing all endpoints from all front end
@AllArgsConstructor
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeatherDetails(@RequestParam String unit, @RequestParam String cityName){
        return weatherService.getWeatherDetails(unit,cityName);

    }

}
