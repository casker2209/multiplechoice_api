package vn.usth.internship.api.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.usth.internship.api.object.ExamHistory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "User")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String name;
    @DBRef
    private Set<Role> roles = new HashSet<>();
    public User() {
    }

    public User(String username, String email, String password,String name) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User(String id, String username, String email, String password,String name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
