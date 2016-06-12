package com.startup.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Типы банов
@Entity
@Table(name = "userBanType")
public class UserBanType extends Model {

    @Column
    private String title;

    @Column
    private String description;

    public UserBanType() {
        super();
    }

    public UserBanType(int id) {
        super(id);
    }

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
}
