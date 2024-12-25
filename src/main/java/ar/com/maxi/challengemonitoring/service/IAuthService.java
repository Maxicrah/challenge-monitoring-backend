package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.auth.AuthResponse;
import ar.com.maxi.challengemonitoring.auth.LoginRequest;
import ar.com.maxi.challengemonitoring.auth.RegisterRequest;

public interface IAuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}
