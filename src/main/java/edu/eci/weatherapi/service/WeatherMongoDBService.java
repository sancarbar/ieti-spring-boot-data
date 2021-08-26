package edu.eci.weatherapi.service;

import edu.eci.weatherapi.data.document.Weather;
import edu.eci.weatherapi.data.dto.WeatherDto;
import edu.eci.weatherapi.data.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherMongoDBService
    implements WeatherService
{
    private final WeatherRepository weatherRepository;

    public WeatherMongoDBService( @Autowired WeatherRepository weatherRepository )
    {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Weather create( Weather weather )
    {
        return weatherRepository.save( weather );
    }

    @Override
    public Weather updateById( WeatherDto weatherDto, String id )
    {
        if ( weatherRepository.existsById( id ) )
        {
            Weather weather = weatherRepository.findById( id ).get();
            weather.update( weatherDto );
            weatherRepository.save( weather );
            return weather;
        }
        return null;
    }

    @Override
    public boolean deleteById( String id )
    {
        if ( weatherRepository.existsById( id ) )
        {
            weatherRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public Weather findById( String id )
    {
        return weatherRepository.findById( id ).orElse( null );
    }
}
