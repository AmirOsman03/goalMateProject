package mk.com.goalmate.backend.dto;

import mk.com.goalmate.backend.model.User;
import mk.com.goalmate.backend.model.enums.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {
    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}
