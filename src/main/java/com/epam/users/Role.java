package com.epam.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey Yun on 16.02.14.
 */

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    private int id;
    private String roleName;
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(int id, String roleName, Set<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "role")
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
