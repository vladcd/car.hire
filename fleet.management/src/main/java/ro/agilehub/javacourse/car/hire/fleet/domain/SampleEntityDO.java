package ro.agilehub.javacourse.car.hire.fleet.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleEntityDO {

    private String id;

    private String name;

    private SampleCountryDO country;

}
