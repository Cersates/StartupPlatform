package com.startup.platform.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

//Баны пользователей
@Entity
@Table(name = "userBan")
public class UserBan extends Model {

    private String author;
    private String user;
    private boolean active;
    private String userBanType;
    private Date beginDate;
    private Date endDate;
    private String description;

    public UserBan() {
        super();
    }

    public UserBan(int id) {
        super(id);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserBanType() {
        return userBanType;
    }

    public void setUserBanType(String userBanType) {
        this.userBanType = userBanType;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
