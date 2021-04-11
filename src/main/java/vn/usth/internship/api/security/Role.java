package vn.usth.internship.api.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Role")
public class Role {
    @Id
    private String id;
    private RoleEnum name;
    public Role(){}
    public Role(RoleEnum name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
