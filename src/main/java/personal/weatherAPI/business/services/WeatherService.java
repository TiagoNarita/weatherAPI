package personal.weatherAPI.business.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import personal.weatherAPI.controllers.dtos.WeatherOut;
import personal.weatherAPI.infrastructure.repositorys.WeatherRepository;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    WeatherRepository WeatherRepository;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherOut getWeather(String country) {
        try {
            return getWeatherOut(country);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @NotNull
    private WeatherOut getWeatherOut(String country) {
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                + country + "?unitGroup=us&key=" +apiKey +"&contentType=json&lang=pt";

        JsonNode root = restTemplate.getForObject(url, JsonNode.class);
        JsonNode day = root.path("days").get(0);

        return createWeatheOut(day);
    }

    @NotNull
    private WeatherOut createWeatheOut(JsonNode day) {
        return new WeatherOut(
                day.path("datetime").asText(),
                day.path("tempmax").asDouble(),
                day.path("tempmin").asDouble(),
                day.path("temp").asDouble(),
                day.path("feelslike").asDouble(),
                day.path("precipprob").asInt(),
                day.path("conditions").asText(),
                day.path("icon").asText()
        );
    }
}
