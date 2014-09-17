package com.epam.webshop.ejb;

import com.epam.webshop.users.Role;
import com.epam.webshop.users.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Yun
 * Date: 9/16/14
 * Time: 2:51 PM
 */

@Stateless
public class UserServiceBean implements UserServiceLocal {
    @PersistenceContext(unitName = "Users")
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void addRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public int rolesCount() {
        Query query = entityManager.createNamedQuery(Role.All_ROLES);
        List<Role> roles = query.getResultList();
        if (roles != null && !roles.isEmpty()) {
            return roles.size();
        } else {
            return 0;
        }
    }


}
