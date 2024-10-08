package pl.akademiaspecjalistowit.podstawyspringsecurity.mapper;

import org.springframework.context.annotation.Configuration;
import pl.akademiaspecjalistowit.podstawyspringsecurity.dto.BookDto;
import pl.akademiaspecjalistowit.podstawyspringsecurity.entity.BookEntity;

@Configuration
public class BookMapper {

    public BookEntity toEntity(BookDto bookDto) {
        return new BookEntity(bookDto.getName());
    }
}
