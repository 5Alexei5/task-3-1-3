package ru.tereshin.bootstrap.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.tereshin.bootstrap.models.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByAuthority(String name);
}
