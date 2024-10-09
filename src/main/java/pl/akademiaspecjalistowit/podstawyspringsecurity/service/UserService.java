package pl.akademiaspecjalistowit.podstawyspringsecurity.service;

import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.NewUserRequestDto;

public interface UserService {

    void addNewUser(NewUserRequestDto newUserRequestDto);
}
