package com.epam.webshop.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey Yun on 16.02.14.
 */

@Entity
@Table(name = "roles")
@NamedQueries(
        {@NamedQuery(name = Role.ROLE_BY_NAME, query = "from Role r where r.roleName = :role_name"),
         @NamedQuery(name = Role.All_ROLES, query = "select r from Role r")}
)
public class Role implements Serializable {
    private int id;
    private String roleName;
    private Set<User> users = new HashSet<User>();
    public static final String ROLE_BY_NAME = "role.by.name";
    public static final String All_ROLES = "all.roles";

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
