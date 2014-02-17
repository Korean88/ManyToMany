package com.epam.users;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Date;

/**
 * Created by Andrey Yun on 16.02.14.
 */
public class Runner {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Users").createEntityManager();
        entityManager.getTransaction().begin();
        Role role = new Role();
        role.setRoleName("user");
        User user = new User();
        user.setName("Andrey");
        user.setDateOfBirth(new Date(20019991003L));
        user.setPassword("123");
        user.setTelephone("5556688");
        user.getRoles().add(role);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
