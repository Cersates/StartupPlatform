package com.startup.platform.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Роли пользователей
@Entity
@Table(name = "project")
public class Project extends Model {

    @NotNull
    @Column
    private String title;

    @Lob
    @Column
    private String description;

    @Column
    private Date dateRegistration;

    @Column
    private BigInteger financing;

    @Column
    private String sphere;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "favorites")
    private Set<User> users = new HashSet<User>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public BigInteger getFinancing() {
        return financing;
    }

    public void setFinancing(BigInteger financing) {
        this.financing = financing;
    }

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", financing=" + financing +
                ", sphere='" + sphere + '\'' +
                '}';
    }
}
