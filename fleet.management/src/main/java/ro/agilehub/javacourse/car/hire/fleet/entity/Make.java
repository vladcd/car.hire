package ro.agilehub.javacourse.car.hire.fleet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(of = "_id")
@Document("makes")
public class Make {

    @Id
    @Field(value = "_id")
    private ObjectId id;

    private String name;
    private String description;
}
