package ru.edmitryv.birthday_scheduler.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edmitryv.birthday_scheduler.models.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
