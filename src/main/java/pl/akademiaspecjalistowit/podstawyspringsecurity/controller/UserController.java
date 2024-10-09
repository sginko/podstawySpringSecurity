//package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;
//
//import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.UserRuquestDto;
//import pl.akademiaspecjalistowit.podstawyspringsecurity.service.UserService;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/new-user")
//public class UserController {
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping
//    public void registerUser(@RequestBody UserRuquestDto userRuquestDto) {
//        userService.addUser(userRuquestDto);
//    }
//}
