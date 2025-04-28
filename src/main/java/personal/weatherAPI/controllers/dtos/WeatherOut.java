package personal.weatherAPI.controllers.dtos;

public record WeatherOut(
        String datetime,
        double tempmax,
        double tempmin,
        double temp,
        double feelslike,
        int precipprob,
        String conditions,
        String icon
) {
}
