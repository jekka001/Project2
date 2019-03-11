package com.myCompany.conferenceManagmentSystem.model.entity;

public class User {
    private long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Role role;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
        this(0, "noEmail", "noPassword", "noName", "noSurname", Role.User);
    }

    public User(long id, String email, String password, String name, String surname, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 17 + (int)(id ^ (id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        User user = (User)obj;
        return user.id == this.id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " id = " + id +
                " email = " + email +
                " password = " + password +
                " name = " + name +
                " surname = " + surname +
                " role = " + role;
    }
}
