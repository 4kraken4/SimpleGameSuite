package common.model;

import java.util.Objects;

public class User {

    private int userId;
    private String username;
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    public User() {
    }

    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public User(int userId, String username, Game game) {
        this.userId = userId;
        this.username = username;
        this.game = game;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.userId;
        hash = 37 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return Objects.equals(this.username, other.username);
    }
    
    
}
