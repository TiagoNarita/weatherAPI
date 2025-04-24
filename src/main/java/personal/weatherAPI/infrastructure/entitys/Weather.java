package personal.weatherAPI.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Weather")
@Entity(name = "Weather")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tempMax;
    private int tempMin;
    @Column(nullable = false)
    private String city;
    private int temp;
    private int feelsLike;
    private int precipitationProbability;
    private String conditions;
    private String icon;
}
