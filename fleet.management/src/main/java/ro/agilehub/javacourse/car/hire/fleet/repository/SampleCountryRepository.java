package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.fleet.entity.SampleCountry;

@Repository
public interface SampleCountryRepository extends JpaRepository<SampleCountry, Integer> {

}
