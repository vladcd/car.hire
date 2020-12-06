package ro.agilehub.javacourse.car.hire.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.CreatedDTO;
import ro.agilehub.javacourse.car.hire.api.model.UserDTO;
import ro.agilehub.javacourse.car.hire.api.specification.UserApi;
import ro.agilehub.javacourse.car.hire.user.controller.mapper.UserDTOMapper;
import ro.agilehub.javacourse.car.hire.user.service.definition.UserService;
import ro.agilehub.javacourse.car.hire.user.service.domain.UserDO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserDTOMapper userDTOMapper;
    private final UserService userService;

    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userDTOMapper.toUserDTOList(userService.findAllUsers()));
    }

    @Override
    public ResponseEntity<CreatedDTO> addUser(@Valid UserDTO userDTO) {
        UserDO userDO = userDTOMapper.toNewUserDO(userDTO);
        Integer newUserId = userService.createNewUser(userDO);
        CreatedDTO createdDTO = new CreatedDTO();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdDTO.id(newUserId));
    }

    @Override
    public ResponseEntity<UserDTO> getUser(Integer id) {
        return ResponseEntity.ok(userDTOMapper.toUserDTO(userService.getById(id)));
    }

    @Override
    public ResponseEntity<Void> patchUser(Integer id, @Valid UserDTO userDTO) {
        userService.patchUser(id, userDTOMapper.toUserDO(userDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
