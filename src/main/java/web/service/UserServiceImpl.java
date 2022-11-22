package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDao) {
        this.userDAO = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return  userDAO.getAllUsers();
    }

    @Override
    public User showUser(int id) {
        return userDAO.showUser(id);
    }

    @Override
    public void saveUser(User person) {
        userDAO.saveUser(person);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
