package apiGateway.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private long expiresIn;
    private Collection<String> authorities;
}
