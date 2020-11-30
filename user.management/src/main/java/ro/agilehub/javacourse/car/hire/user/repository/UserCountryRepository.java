package ro.agilehub.javacourse.car.hire.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.agilehub.javacourse.car.hire.user.entity.UserCountry;

@Repository
public interface UserCountryRepository extends JpaRepository<UserCountry, Integer> {

}
