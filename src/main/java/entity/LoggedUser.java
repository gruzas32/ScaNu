package entity;

import jakarta.persistence.*;

@Entity
public class LoggedUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name ="isLogged")
    private boolean isLogged;

    public LoggedUser(int userId, boolean isLogged) {
        this.userId = userId;
        this.isLogged = isLogged;
    }

    public LoggedUser() {
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
