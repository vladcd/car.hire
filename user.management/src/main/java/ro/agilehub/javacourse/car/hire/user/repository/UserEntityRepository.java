package ro.agilehub.javacourse.car.hire.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findById(Long id);

	void deleteById(Long id);
}
