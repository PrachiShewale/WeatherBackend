package com.research.summarizz;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*")//allow accessing all endpoints from all front end
@AllArgsConstructor
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    @PostMapping("/weather")
    public String createRequest(@RequestParam Double latitude,@RequestParam Double longitude){
        return weatherService.createRequest(latitude,longitude);

    }

}
