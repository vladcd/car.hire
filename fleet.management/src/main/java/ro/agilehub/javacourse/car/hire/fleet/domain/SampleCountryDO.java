package ro.agilehub.javacourse.car.hire.fleet.domain;

import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleCountryDO {

    private String id;

    private String name;

    private String isoCode;

}
