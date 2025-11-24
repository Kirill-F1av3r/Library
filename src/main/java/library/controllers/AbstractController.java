package library.controllers;

import jakarta.validation.Valid;
import library.models.Book;
import library.services.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class AbstractController<T> implements Controller<T> {
    private final Service<T> service;
    private final String name_recourse;
    private final String recourses;

    public AbstractController(Service<T> service, String name_recourse, String recourses) {
        this.service = service;
        this.name_recourse = name_recourse;
        this.recourses = recourses;
    }

    @Override
    public String index(Model model) {
        model.addAttribute(recourses, service.index());
        return recourses + "/index";
    }

    @Override
    public String show(@PathVariable("id") int id, Model model) {
        Optional<T> t = service.show(id);
        if (t.isPresent()) {
            model.addAttribute(name_recourse, t.get());
            return recourses + "/show";
        }
        return recourses + "/notValue";
    }

    @Override
    public String newRecourse(Model model) {
        model.addAttribute(name_recourse, new Book());
        return recourses + "/new";
    }

    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        Optional<T> book = service.show(id);
        if (book.isPresent()) {
            model.addAttribute(name_recourse, book.get());
            return recourses + "/edit";
        }
        return recourses + "/notValue";
    }


    @Override
    public String destroy(@PathVariable("id") int id) {
        service.destroy(id);
        return "redirect:/" + recourses;
    }
}
