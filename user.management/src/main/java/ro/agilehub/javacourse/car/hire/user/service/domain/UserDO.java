package ro.agilehub.javacourse.car.hire.user.service.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class UserDO {

    private Integer id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private CountryDO countryOfResidence;
    private String driverLicense;
    private UserStatusDO status;
}
