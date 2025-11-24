package library.controllers;

import jakarta.validation.Valid;
import library.models.Person;
import library.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    private static final String NAME_RECOURSE = "person";
    private static final String RECOURSES = "people";

    public PersonController(PersonService personService) {
        super(personService, NAME_RECOURSE, RECOURSES);
        this.personService = personService;
    }

    @Override
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personService.create(person);
        return "redirect:/people";
    }

    @Override
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personService.update(id, person);
        return "redirect:/people";
    }

    @Override
    protected Person createRecourse() {
        return new Person();
    }
}
