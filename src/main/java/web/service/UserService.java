package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User showUser(int id);

    public void saveUser(User person);

    public void updateUser(int id, User updatedUser);

    public void deleteUser(int id);
}
