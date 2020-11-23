package domain;

import enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int         id;
    private String      username;
    private String      firstName;
    private String      lastName;
    private CountryDTO  countryOfResidence;
    private String      driverLicenseNo;
    private UserStatusEnum status;
}
