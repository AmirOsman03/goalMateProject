package mk.com.goalmate.backend.service.application;

import mk.com.goalmate.backend.dto.CreateUserDto;
import mk.com.goalmate.backend.dto.DisplayUserDto;
import mk.com.goalmate.backend.dto.LoginResponseDto;
import mk.com.goalmate.backend.dto.LoginUserDto;
import mk.com.goalmate.backend.model.enums.Role;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

}
