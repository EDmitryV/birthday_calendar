package ru.edmitryv.birthday_scheduler.services;

import ru.edmitryv.birthday_scheduler.models.Person;
import ru.edmitryv.birthday_scheduler.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    public PersonService(PersonRepo personRepo){
        this.personRepo = personRepo;
    }
    private PersonRepo personRepo;
    public void savePerson(Person person) {
        personRepo.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }
}
