package com.startup.platform.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//Роли пользователей
@Entity
@Table(name = "project")
public class Project extends Model {

    @NotNull
    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
                '}';
    }
}
