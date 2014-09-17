package com.epam.webshop.ejb;

import com.epam.webshop.exception.IncorrectSecretAnswerException;
import com.epam.webshop.users.Role;
import com.epam.webshop.utils.PasswordEncoder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Yun
 * Date: 9/17/14
 * Time: 10:40 AM
 */

@RunWith(Arquillian.class)
public class UserServiceBeanTest {

    @Inject
    UserServiceLocal userService;

    @Deployment
    public static Archive<?> createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addPackage(UserServiceBean.class.getPackage())
                .addPackage(Role.class.getPackage()).addPackage(IncorrectSecretAnswerException.class.getPackage())
                .addPackage(PasswordEncoder.class.getPackage())
                .addAsManifestResource("persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return jar;
    }

    @Test
    public void shouldAddNewRole() {
        Role role = new Role();
        role.setRoleName("admin");
        userService.addRole(role);
        int roleCount = userService.rolesCount();
        Assert.assertEquals("should be 1",1,roleCount);
    }
}
