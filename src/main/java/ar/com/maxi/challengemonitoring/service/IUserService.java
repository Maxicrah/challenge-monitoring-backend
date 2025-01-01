package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.dto.UserDTO;
import ar.com.maxi.challengemonitoring.model.User;

import java.util.List;

public interface IUserService {

    User save(UserDTO userDto);
    User findById(Long id);
    void deleteUser(Long id);
    User updateUser(UserDTO userDto, Long id);
    List<User> findAllUsers();
    User findUserByEmail(String email);
}
