package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.NewUserRequestDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/new-user")
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void registerUser(@RequestBody NewUserRequestDto userRequestDto) {
        userService.addNewUser(userRequestDto);
    }
}
