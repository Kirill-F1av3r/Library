package library.services;

import library.models.Person;
import library.repositories.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<Person> {

    @Autowired
    public PersonService(PersonDAO personDAO) {
        super(personDAO);
    }

}
