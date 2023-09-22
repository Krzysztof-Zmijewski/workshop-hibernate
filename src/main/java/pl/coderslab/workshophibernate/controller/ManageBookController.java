package pl.coderslab.workshophibernate.controller;

import lombok.AllArgsConstructor;
import pl.coderslab.workshophibernate.book.Book;
import pl.coderslab.workshophibernate.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin/books")
@Controller
@AllArgsConstructor
public class ManageBookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/view-all-books";
    }
}
