package entity;

import enums.UserStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@EqualsAndHashCode(of = "_id")
@Document("users")
public class User {

    @Id
    @Field(name = "_id")
    private ObjectId        id;

    private String          username;
    private String          firstName;
    private String          lastName;
    private String          driverLicense;
    private UserStatusEnum  userStatus;

    @DBRef(db = "countries")
    private Country         country;

}
