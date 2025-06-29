package mk.com.goalmate.backend.web.controllers;

import mk.com.goalmate.backend.dto.CreateUserDto;
import mk.com.goalmate.backend.dto.DisplayUserDto;
import mk.com.goalmate.backend.dto.LoginResponseDto;
import mk.com.goalmate.backend.dto.LoginUserDto;
import mk.com.goalmate.backend.model.User;
import mk.com.goalmate.backend.model.exceptions.InvalidArgumentsException;
import mk.com.goalmate.backend.model.exceptions.InvalidUserCredentialsException;
import mk.com.goalmate.backend.model.exceptions.PasswordsDoNotMatchException;
import mk.com.goalmate.backend.repository.UserRepository;
import mk.com.goalmate.backend.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserApplicationService userApplicationService;
    private final UserRepository userRepository;

    public UserController(UserApplicationService userApplicationService, UserRepository userRepository) {
        this.userApplicationService = userApplicationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<DisplayUserDto> register(@RequestBody CreateUserDto createUserDto) {
        try {
            return userApplicationService.register(createUserDto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto) {
        try {
            return userApplicationService.login(loginUserDto)
                    .map(ResponseEntity::ok)
                    .orElseThrow(InvalidUserCredentialsException::new);
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Principal principal) {
        String username = principal.getName();
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOpt.get();
        return ResponseEntity.ok(user);
    }

}
