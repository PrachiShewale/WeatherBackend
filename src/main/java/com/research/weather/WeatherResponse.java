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
    private long visibility;
    private Wind wind;
    private Cloud cloud;
    private long dt;
    private SysObj sys;
    private long timezone;
    private long id;
    private String name;
    private long cod;

}