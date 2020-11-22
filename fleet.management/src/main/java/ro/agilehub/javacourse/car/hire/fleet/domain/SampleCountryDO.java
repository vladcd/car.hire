package ro.agilehub.javacourse.car.hire.fleet.domain;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
