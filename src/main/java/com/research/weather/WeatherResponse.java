package com.research.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private MainObj main;
    private Long visibility;
    private Wind wind;
    private Cloud clouds;
    private Long dt;
    private SysObj sys;
    private Long timezone;
    private Long id;
    private String name;
    private Long cod;

}