package ru.edmitryv.birthday_scheduler.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edmitryv.birthday_scheduler.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
