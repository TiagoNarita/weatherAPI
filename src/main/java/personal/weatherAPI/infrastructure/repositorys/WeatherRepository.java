package personal.weatherAPI.infrastructure.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.weatherAPI.infrastructure.entitys.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
