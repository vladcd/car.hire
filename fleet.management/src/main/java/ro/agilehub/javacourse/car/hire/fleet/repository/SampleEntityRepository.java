package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

@Repository
public interface SampleEntityRepository extends MongoRepository<SampleEntity, ObjectId> {
}
