package com.research.summarizz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
//    {
//        "coord": {
//        "lon": 72.8321,
//                "lat": 18.9582
//    },
//        "weather": [
//        {
//            "id": 800,
//                "main": "Clear",
//                "description": "clear sky",
//                "icon": "01n"
//        }
//  ],
//        "base": "stations",
//            "main": {
//        "temp": 298.03,
//                "feels_like": 298.27,
//                "temp_min": 298.03,
//                "temp_max": 298.03,
//                "pressure": 1016,
//                "humidity": 65,
//                "sea_level": 1016,
//                "grnd_level": 1015
//    },
//        "visibility": 10000,
//            "wind": {
//        "speed": 4.69,
//                "deg": 346,
//                "gust": 5.51
//    },
//        "clouds": {
//        "all": 0
//    },
//        "dt": 1768149356,
//            "sys": {
//        "country": "IN",
//                "sunrise": 1768095844,
//                "sunset": 1768135702
//    },
//        "timezone": 19800,
//            "id": 1266741,
//            "name": "Khetwādi",
//            "cod": 200
//    }
}