package ar.com.maxi.challengemonitoring.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Email
    private String email;
    @Size(min = 8, max = 15, message = "password required 8 digits")
    private String password;
    @NotBlank(message = "username is required")
    private String username;
}
