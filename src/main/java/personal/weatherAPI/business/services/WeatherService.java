package personal.weatherAPI.business.services;

import org.springframework.stereotype.Service;
import personal.weatherAPI.controllers.dtos.WeatherOut;
import personal.weatherAPI.infrastructure.repositorys.WeatherRepository;

@Service
public class WeatherService {

    WeatherRepository WeatherRepository;

    public WeatherOut getWeather(String country) {
        return null;
    }
}
