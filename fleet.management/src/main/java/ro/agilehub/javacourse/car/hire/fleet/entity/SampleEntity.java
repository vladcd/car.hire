package ro.agilehub.javacourse.car.hire.fleet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(of = "_id")
@Document(collection = "entity")
public class SampleEntity {

    @Id
    @Field("_id")
    private ObjectId id;

    private String name;

    private String country;

}
