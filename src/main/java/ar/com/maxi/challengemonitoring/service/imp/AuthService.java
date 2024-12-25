package ar.com.maxi.challengemonitoring.service.imp;

import ar.com.maxi.challengemonitoring.auth.AuthResponse;
import ar.com.maxi.challengemonitoring.auth.LoginRequest;
import ar.com.maxi.challengemonitoring.auth.RegisterRequest;
import ar.com.maxi.challengemonitoring.model.Role;
import ar.com.maxi.challengemonitoring.model.User;
import ar.com.maxi.challengemonitoring.repository.IRoleRepository;
import ar.com.maxi.challengemonitoring.repository.IUserRepository;
import ar.com.maxi.challengemonitoring.service.IAuthService;
import ar.com.maxi.challengemonitoring.service.IJwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private final IRoleRepository roleRepository;
    private final IUserRepository _userRepository;
    private final IJwtService _jwtService;
    private final PasswordEncoder _passwordEncoder;
    private final AuthenticationManager _authenticationManager;
    public AuthService(IRoleRepository _roleRepository,
                       IUserRepository _userRepository,
                       IJwtService _jwtService,
                       PasswordEncoder _passwordEncoder,
                       AuthenticationManager _authenticationManager) {
        this.roleRepository = _roleRepository;
        this._userRepository = _userRepository;
        this._jwtService = _jwtService;
        this._passwordEncoder = _passwordEncoder;
        this._authenticationManager = _authenticationManager;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        this._authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetails user = this._userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("user not found"));

        String token = this._jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        Role rol = new Role();
        rol.setRoleName("ROLE_USER");
        this.roleRepository.save(rol);
        String encodedPassword = this._passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .username(request.getUsername())
                .password(encodedPassword)
                .email(request.getEmail())
                .role(rol).build();
        this._userRepository.save(user);
        return AuthResponse.builder().token(_jwtService.getToken(user)).build();
    }
}
