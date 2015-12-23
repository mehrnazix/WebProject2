package Biz.User;

import Biz.User.User;
import DAO.UserDAO;

import java.sql.SQLException;

/**
 * Created by 931664 on 12/22/2015.
 */
public class UserBLO {

    private UserDAO userDAO;

    public UserBLO() throws SQLException, ClassNotFoundException {

        userDAO = new UserDAO();
    }

    public User loadByUserId(int userId) throws SQLException {

        return userDAO.loadUserById(userId);
    }

    public User loadByUsernameAndPassword(String username, String password) throws SQLException {

        return userDAO.loadByUsernameAndPassword(username, password);
    }

    public void updatePassword(User user) throws SQLException {

        userDAO.updatePassword(user);
    }

}