package ar.com.maxi.challengemonitoring.dto;

import ar.com.maxi.challengemonitoring.model.Role;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "username is required")
    private String username;
    @NotBlank(message = "email is required")
    @Email
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 8, max = 8, message = "password required 8 digits")
    private String password;
    @Size(min = 6, max = 12, message = "name range 6 - 10 characters")
    private String roleName;
}
