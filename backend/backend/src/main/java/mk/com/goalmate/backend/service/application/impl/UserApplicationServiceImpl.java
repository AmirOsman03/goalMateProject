package mk.com.goalmate.backend.service.application.impl;

import mk.com.goalmate.backend.dto.CreateUserDto;
import mk.com.goalmate.backend.dto.DisplayUserDto;
import mk.com.goalmate.backend.dto.LoginResponseDto;
import mk.com.goalmate.backend.dto.LoginUserDto;
import mk.com.goalmate.backend.helpers.JwtHelper;
import mk.com.goalmate.backend.model.User;
import mk.com.goalmate.backend.service.application.UserApplicationService;
import mk.com.goalmate.backend.service.domain.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

}
