package com.epam.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey Yun on 16.02.14.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String telephone;
    private String password;
    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }

    public User(int id, String name, Date dateOfBirth, String telephone, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "tel")
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "pass")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE},
                targetEntity = Role.class)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
