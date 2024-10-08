package pl.akademiaspecjalistowit.podstawyspringsecurity.service;

import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    void addBook(BookDto bookDto);
}
