//package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.UserRegistrationDto;
//import pl.akademiaspecjalistowit.podstawyspringsecurity.service.UserService;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/add-user")
//public class UserController {
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping
//    public String registerUser(@RequestBody UserRegistrationDto userDto) {
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        userService.saveUser(userDto);
//        return "User registered successfully";
//    }
//
//
//}
