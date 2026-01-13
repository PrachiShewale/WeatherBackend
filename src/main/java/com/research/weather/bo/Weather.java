package com.research.weather.bo;

import lombok.Data;

@Data
public class Weather {
    private Long id;
    private String main;
    private String description;
    private String icon;
}
