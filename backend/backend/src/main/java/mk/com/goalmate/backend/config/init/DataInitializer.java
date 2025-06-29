package mk.com.goalmate.backend.config.init;

import jakarta.annotation.PostConstruct;
import mk.com.goalmate.backend.model.User;
import mk.com.goalmate.backend.model.enums.Role;
import mk.com.goalmate.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @PostConstruct
    public void init(){
        User admin = new User(
                "admin",
                passwordEncoder.encode("admin"),
                "Admin",
                "Admin",
                Role.ROLE_ADMIN
        );
        userRepository.save(admin);
    }
}
