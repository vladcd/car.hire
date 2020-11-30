package ro.agilehub.javacourse.car.hire.user.service;

import java.util.List;
import java.util.Optional;

import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

public interface UserService {

	List<UserEntity> findAll();

	 Optional<UserEntity> findById(Long id);

	void save(UserEntity user);

	void delete(Long id);
}
