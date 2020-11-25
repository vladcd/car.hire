package ro.agilehub.javacourse.car.hire.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;
import ro.agilehub.javacourse.car.hire.user.repository.UserEntityRepository;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }
    
    @Override
    public Optional<UserEntity>  findById(Long id) {
        return userEntityRepository.findById(id);
    }
    
    @Override
    public void save(UserEntity user) {
    	userEntityRepository.save(user);
    }
     
    @Override
    public void delete(Long id) {
    	userEntityRepository.deleteById(id);
    }
}
