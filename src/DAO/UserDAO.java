package DAO;

import Biz.User.User;
import Database.Database;

import java.sql.SQLException;

/**
 * Created by 931664 on 11/16/2015.
 */
public class UserDAO {

    private Database database;

    public UserDAO() throws SQLException, ClassNotFoundException {
        database = new Database();
        database.connect();
    }

    public User loadUserById(int userId) throws SQLException {

        return database.loadUserById(userId);
    }

    public User loadByUsernameAndPassword(String username, String password) throws SQLException {

        return database.loadUser(username, password);
    }

    public void updatePassword(User user) throws SQLException {

        database.updatePasswordOfUser(user);
    }
}
