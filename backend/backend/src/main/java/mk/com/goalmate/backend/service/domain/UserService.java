package mk.com.goalmate.backend.service.domain;

import mk.com.goalmate.backend.model.User;
import mk.com.goalmate.backend.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

}
