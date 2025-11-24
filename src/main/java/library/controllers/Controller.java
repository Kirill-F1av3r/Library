package library.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public interface Controller<T> {

    @GetMapping
    String index(Model model);

    @GetMapping("/{id}")
    String show(@PathVariable("id") int id, Model model);

    @GetMapping("/new")
    String newRecourse(Model model);

    @PostMapping
    String create(T t, BindingResult bindingResult);

    @GetMapping("/{id}/edit")
    String edit(@PathVariable("id") int id, Model model);

    @PatchMapping("/{id}")
    String update(@PathVariable("id") int id, T t, BindingResult bindingResult);

    @DeleteMapping("/{id}")
    String destroy(@PathVariable("id") int id);

}
