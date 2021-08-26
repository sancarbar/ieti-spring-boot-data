package edu.eci.weatherapi.controller;

import edu.eci.weatherapi.data.document.Weather;
import edu.eci.weatherapi.data.dto.WeatherDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/v1/weather" )
public class WeatherController
{

    @PostMapping
    public Weather createWeather( @RequestBody WeatherDto weatherDto )
    {
        return new Weather( weatherDto );
    }

    @GetMapping( "/{id}" )
    public Weather findWeatherById( @PathVariable String id )
    {
        return null;
    }

    @DeleteMapping( "/{id}" )
    public boolean deleteWeatherById( @PathVariable String id )
    {
        return false;
    }

    @PutMapping( "/{id}" )
    public Weather updateWeatherById( @RequestBody WeatherDto weatherDto, @PathVariable String id )
    {
        return null;
    }
}
