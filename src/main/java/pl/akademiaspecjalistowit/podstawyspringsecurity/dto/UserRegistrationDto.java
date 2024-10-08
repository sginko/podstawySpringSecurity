package pl.akademiaspecjalistowit.podstawyspringsecurity.dto;

import lombok.Getter;

@Getter
public class UserRegistrationDto {
    private String username;
    private String password;
    private String role;
}
