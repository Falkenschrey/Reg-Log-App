package database;

import dao.User;
import java.util.ArrayList;

public class InMemoryDatabase {

    private ArrayList<User> userDatabase;

    public InMemoryDatabase() {
        this.userDatabase = new ArrayList<>();
    }

    /**
     * Add new User to the in memory database. if not empty
     * @param user User object
     * @return boolean if user successfully added, false if null or not added
     */
    public boolean addUser(User user) {
        if (user != null) {
            //Todo: Check if user/mail already exists
            return this.userDatabase.add(user);
        }
        return false;
    }

    public boolean removeUser(int userID) {
        for (User user : this.userDatabase) {
            if (user.getId() == userID) {
                return this.userDatabase.remove(user);
            }
        }
        return false;
    }

    public User getUser(int userID) {
        for (User user : this.userDatabase) {
            if (user.getId() == userID) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String email) {
        if (email != null) {
            for (User user : this.userDatabase) {
                if (user.getEmail() == email) {
                    return user;
                }
            }
        }
        return null;
    }

    public ArrayList<User> getAllUser() {
        return this.userDatabase;
    }
}
