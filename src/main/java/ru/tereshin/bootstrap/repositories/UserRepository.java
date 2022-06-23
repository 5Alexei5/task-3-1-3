package ru.tereshin.bootstrap.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.tereshin.bootstrap.models.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
