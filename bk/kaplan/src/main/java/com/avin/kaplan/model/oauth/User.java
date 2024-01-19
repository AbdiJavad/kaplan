package com.avin.kaplan.model.oauth;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer action;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> outhorization = new HashSet<>();

    public User() {
    }

    public User(String username, String password, String email, Integer action) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.action = action;
    }

}
