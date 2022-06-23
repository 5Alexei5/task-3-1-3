package ru.tereshin.bootstrap.services;



import ru.tereshin.bootstrap.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getListRoles(String... roles);

    Iterable<Role> getRoles();
}
