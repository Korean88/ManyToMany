package com.epam.webshop.ejb;

import com.epam.webshop.users.Role;
import com.epam.webshop.users.User;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Yun
 * Date: 9/16/14
 * Time: 2:50 PM
 */

@Local
public interface UserServiceLocal {
    void addUser(User user);
    void addRole(Role role);
    int rolesCount();
}
