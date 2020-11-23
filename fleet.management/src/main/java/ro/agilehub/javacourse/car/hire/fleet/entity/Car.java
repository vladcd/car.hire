package ro.agilehub.javacourse.car.hire.fleet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(of = "_id")
@Document("cars")
public class Car {

    @Id
    @Field("_id")
    private ObjectId id;

    @DBRef(db = "makes")
    private Make make;
    private String model;
    private int year;
    private int mileage;
    private float fuel;
    private String carClass;
    private String status;
}
