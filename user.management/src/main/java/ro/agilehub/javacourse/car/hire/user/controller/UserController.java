package ro.agilehub.javacourse.car.hire.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ro.agilehub.javacourse.car.hire.api.model.UserDTO;
import ro.agilehub.javacourse.car.hire.api.specification.UsersApi;
import ro.agilehub.javacourse.car.hire.user.service.UserService;
import static java.util.stream.Collectors.toList;

@RestController
public class UserController implements UsersApi {

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<List<UserDTO>> getUsers() {
		// return ResponseEntity.ok(Collections.singletonList(buildStubs()));

		var userEntities = userService.findAll();
		return ResponseEntity.ok(userEntities.stream().map(userEntity -> {
			var result = new UserDTO();
			result.setId(userEntity.getId());
			result.setFirstName(userEntity.getFirstName());
			result.setLastName(userEntity.getLastName());
			result.setUsername(userEntity.getFirstName()+ " "+ userEntity.getLastName());
			result.setEmail(userEntity.getEmail());
			result.setCountryOfResidence(userEntity.getCountry().getName());
			return result;
		}).collect(toList()));
	}

	@Override
	public ResponseEntity<UserDTO> getUserById(Long userId) {
		return ResponseEntity.ok(buildStubs());

	}

	public UserDTO buildStubs() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1);
		userDTO.setFirstName("Diana");
		userDTO.setLastName("Terciu");
		return userDTO;
	}

	@Override
	public ResponseEntity<UserDTO> addUser(@Valid UserDTO userDTO) {

		return ResponseEntity.ok(buildStubs());
	}

	@Override
	public ResponseEntity<Void> deleteUserById(Long userId) {
		return UsersApi.super.deleteUserById(userId);
	}

	@Override
	public ResponseEntity<Void> updateUser(Long userId, UserDTO userDTO) {

		UserDTO user = buildStubs();
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		if (user.getFirstName() != null) {
			user.setFirstName(userDTO.getFirstName());
		}
		if (user.getLastName() != null) {
			user.setLastName(userDTO.getLastName());
		}
		return UsersApi.super.updateUser(userId, userDTO);

	}

}
