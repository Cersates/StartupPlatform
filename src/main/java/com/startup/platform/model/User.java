package com.startup.platform.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Список пользователей
@Entity
@Table(name = "user")
public class User extends Model {

    @Size(min = 3, max = 25)
    @Column
    private String email;

    @Size(min = 3, max = 25)
    @NotNull
    @Column
    private String password;

    @Size(min = 3, max = 25)
    @Column
    private String firstname;

    @Size(min = 3, max = 25)
    @Column
    private String lastname;

    @Column
    private Date dateBirth;

    @Column
    private String about;

    @Column
    private Date registrationDate;

    @Column
    private String type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "favorites", joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "project_id", nullable = false, updatable = false))
    private Set<Project> favorites = new HashSet<Project>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Project> projects = new HashSet<Project>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false, updatable = false))
    private Set<Role> roles = new HashSet<Role>();


    public User() {
        super();
    }

    public User(int id) {
        super(id);
    }

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Project> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Project> favorites) {
        this.favorites = favorites;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateBirth=" + dateBirth +
                ", about='" + about + '\'' +
                ", registrationDate=" + registrationDate +
                ", type='" + type + '\'' +
                '}';
    }
}
