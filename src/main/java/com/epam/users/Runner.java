package com.epam.users;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Andrey Yun on 16.02.14.
 */
public class Runner {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Users").createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery(Role.ROLE_BY_NAME);
        query.setParameter("role_name","admin");
        Role role = (Role) query.getSingleResult();
        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR,1988);
        calendar.set(Calendar.MONTH,3);
        calendar.set(Calendar.DAY_OF_MONTH,10);
        java.util.Date date = calendar.getTime();
        user.setDateOfBirth(date);
        user.setPassword("123");
        user.setTelephone("5556688");
        user.getRoles().add(role);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
