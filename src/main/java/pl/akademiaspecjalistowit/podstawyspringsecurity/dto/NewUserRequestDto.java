package pl.akademiaspecjalistowit.podstawyspringsecurity.dto;

import lombok.Getter;

@Getter
public class NewUserRequestDto {
    private String username;
    private String password;
}
