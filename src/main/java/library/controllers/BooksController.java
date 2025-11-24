package library.controllers;

import jakarta.validation.Valid;
import library.models.Book;
import library.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController extends AbstractController<Book> {

    private final BooksService booksService;

    private static final String NAME_RECOURSE = "book";
    private static final String RECOURSES = "books";

    @Autowired
    public BooksController(BooksService booksService) {
        super(booksService, NAME_RECOURSE, RECOURSES);
        this.booksService = booksService;
    }

    @Override
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        booksService.create(book);
        return "redirect:/books";
    }

    @Override
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }

        booksService.update(id, book);
        return "redirect:/books";
    }
}
