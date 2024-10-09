package pl.akademiaspecjalistowit.podstawyspringsecurity.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.NewUserRequestDto;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addNewUser(NewUserRequestDto newUserRequestDto) {
        if (jdbcUserDetailsManager.userExists(newUserRequestDto.getUsername())) {
            throw new RuntimeException();
        }
        jdbcUserDetailsManager.createUser(User
                .withUsername(newUserRequestDto.getUsername())
                .password(passwordEncoder.encode(newUserRequestDto.getPassword()))
                .roles("USER")
                .build()
        );
    }
}
