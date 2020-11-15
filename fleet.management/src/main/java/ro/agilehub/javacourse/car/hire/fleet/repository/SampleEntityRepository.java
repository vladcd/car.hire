package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleEntity;

@Repository
public interface SampleEntityRepository extends JpaRepository<SampleEntity, Integer> {
}
