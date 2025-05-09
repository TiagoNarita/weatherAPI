package personal.weatherAPI.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.weatherAPI.business.services.WeatherService;
import personal.weatherAPI.controllers.dtos.WeatherOut;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{country}")
    public ResponseEntity<WeatherOut> getWeather(@PathVariable String country) {
        return ResponseEntity.ok(weatherService.getWeather(country));
    }
}
