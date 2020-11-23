package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.fleet.entity.Make;

@Repository
public interface MakeRepository extends MongoRepository<Make, ObjectId> {
}
