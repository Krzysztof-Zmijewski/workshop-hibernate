package main.pl.coderslab.workshophibernate.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.pl.coderslab.workshophibernate.book.Book;
import main.pl.coderslab.workshophibernate.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class JpaBookService implements BookService{
    private BookRepository bookRepository;
    @Override
    @GetMapping("")
    public List<Book> getBooks() {
        log.debug("Returning all books");
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findAll().stream()
                .filter(item -> item.getId().equals(id)).findFirst();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return get(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        ));
    }


    @Override
    @PostMapping("/create")
    public void add(@RequestBody Book book) {
        log.debug("Adding to books: {}", book);
        bookRepository.save(book);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.delete(getBook(id));

    }

    @Override
    @PutMapping
    public void update(@RequestBody Book book) {
        if (get(book.getId()).isPresent()) {
            bookRepository.save(book);
        }
    }
}
