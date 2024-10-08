//package pl.akademiaspecjalistowit.podstawyspringsecurity.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.UserRegistrationDto;
//
//@AllArgsConstructor
//@Service
//public class UserServiceImpl implements UserService {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Override
//    public void addNewUser(UserRegistrationDto userRegistrationDto) {
//        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)",
//                userRegistrationDto.getUsername(), userRegistrationDto.getPassword(), true);
//
//        jdbcTemplate.update("INSERT INTO user_roles (user_id, role_id) VALUES (?, ?)",
//                getUserIdByUsername(userRegistrationDto.getUsername()), getRoleIdByName("ROLE_USER"));
//    }
//
//    private Long getUserIdByUsername(String username) {
//        return jdbcTemplate.queryForObject("SELECT id FROM users WHERE username = ?", Long.class, username);
//    }
//
//    private Long getRoleIdByName(String roleName) {
//        return jdbcTemplate.queryForObject("SELECT id FROM roles WHERE name = ?", Long.class, roleName);
//    }
//
//
//}
