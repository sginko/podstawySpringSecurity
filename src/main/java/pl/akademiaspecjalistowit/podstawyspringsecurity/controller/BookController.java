package pl.akademiaspecjalistowit.podstawyspringsecurity.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.service.BookService;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('USER')")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping
    public List<BookDto> getBooks(){
        return bookService.getAllBooks();
    }

    @PreAuthorize("hasRole('ADMIN')")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/new-book")
    public void createNewBook(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
    }

    @GetMapping("/check-password") //http://localhost:8080/books/check-password?rawPassword=admin
    public boolean checkPassword(@RequestParam String rawPassword) {
        String hashedPassword = "$2a$10$QZXmTvcbZz1k5p8PZylVFeuYUv.mOi9MyL9pSlhLVCRzUzeA0wByy";
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
