package edu.eci.weatherapi.controller;

import edu.eci.weatherapi.data.document.Weather;
import edu.eci.weatherapi.data.dto.WeatherDto;
import edu.eci.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final WeatherService weatherService;

    public WeatherController( @Autowired WeatherService weatherService )
    {
        this.weatherService = weatherService;
    }

    @PostMapping
    public Weather createWeather( @RequestBody WeatherDto weatherDto )
    {

        return weatherService.create( new Weather( weatherDto ) );


    }

    @GetMapping( "/{id}" )
    public Weather findWeatherById( @PathVariable String id )
    {
        return weatherService.findById( id );
    }

    @DeleteMapping( "/{id}" )
    public boolean deleteWeatherById( @PathVariable String id )
    {
        return weatherService.deleteById( id );
    }

    @PutMapping( "/{id}" )
    public Weather updateWeatherById( @RequestBody WeatherDto weatherDto, @PathVariable String id )
    {
        return weatherService.updateById( weatherDto, id );
    }
}
