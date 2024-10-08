package pl.akademiaspecjalistowit.podstawyspringsecurity.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.mapper.BookMapper;
import pl.akademiaspecjalistowit.podstawyspringsecurity.repository.BookRepository;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAllBooks(){
        return bookRepository.findAll()
            .stream()
            .map(e->new BookDto(e.getName()))
            .toList();
    }

    @Override
    public void addBook(BookDto bookDto){
        bookRepository.save(bookMapper.toEntity(bookDto));
    }
}
