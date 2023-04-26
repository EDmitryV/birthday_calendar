package ru.edmitryv.birthday_scheduler.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edmitryv.birthday_scheduler.models.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
