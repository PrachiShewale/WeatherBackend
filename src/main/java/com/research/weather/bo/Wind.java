package com.research.weather.bo;

import lombok.Data;

@Data
public class Wind {

    private double speed;
    private int deg;
    private double gust;
}
