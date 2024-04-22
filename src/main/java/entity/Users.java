package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password_hash")
    private String passwordHash;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;


    public Users(String username, String passwordHash, String firstName, String lastName) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;

    }
    public Users() {

    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(username, users.username) && Objects.equals(passwordHash, users.passwordHash) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, passwordHash, firstName, lastName);
    }
}
