package ru.tereshin.bootstrap.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.tereshin.bootstrap.models.User;


public interface UserService extends UserDetailsService
 {

    Iterable<User> getAllUsers();

    void addUser(User user);

    void update(User user, long id);

    void deleteUser(long id);

    User getUser(String name);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
