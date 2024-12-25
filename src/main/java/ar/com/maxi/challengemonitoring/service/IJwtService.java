package ar.com.maxi.challengemonitoring.service;

import ar.com.maxi.challengemonitoring.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String getToken(UserDetails user);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
