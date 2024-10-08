package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.service.BookService;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<BookDto> getBooks(){
        return bookService.getAllBooks();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/new-book")
    public void createNewBook(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
    }
}
