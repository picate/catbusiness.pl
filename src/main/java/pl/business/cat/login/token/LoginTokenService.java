package pl.business.cat.login.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginTokenService {

    private final LoginTokenRepository loginTokenRepository;

    public void saveConfirmationToken(LoginToken token) {
    	loginTokenRepository.save(token);
    }

    public Optional<LoginToken> getToken(String token) {
        return loginTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return loginTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
