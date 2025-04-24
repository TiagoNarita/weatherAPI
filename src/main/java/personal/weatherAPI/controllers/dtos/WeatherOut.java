package personal.weatherAPI.controllers.dtos;

public record WeatherOut(
        String id,
        int tempMax,
        int tempMin,
        int temp,
        int feelsLike,
        int precipitationProbability,
        String conditions,
        String icon
) {
}
