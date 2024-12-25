package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.dto.UserDTO;
import ar.com.maxi.challengemonitoring.model.Role;
import ar.com.maxi.challengemonitoring.model.User;
import ar.com.maxi.challengemonitoring.repository.IRoleRepository;
import ar.com.maxi.challengemonitoring.repository.IUserRepository;
import ar.com.maxi.challengemonitoring.service.IRoleService;
import ar.com.maxi.challengemonitoring.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IRoleService roleService;
    public UserService(IUserRepository userRepository, IRoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public User save(UserDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        Role role = this.roleService.findByName(userDto.getRoleName());
        user.setRole(role);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return this.userRepository.save(user);

    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        User user = this.findById(id);
        if(user == null) {
            throw new RuntimeException("User not found");
        }
        this.userRepository.delete(user);
    }

    @Override
    public User updateUser(UserDTO userDto, Long id) {
        User user = this.findById(id);
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        Role role = this.roleService.findByName(userDto.getRoleName());
        user.setRole(role);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }
}
