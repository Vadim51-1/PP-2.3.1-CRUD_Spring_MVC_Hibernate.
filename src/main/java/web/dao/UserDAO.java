package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

      List<User> getAllUsers();

      User showUser(int id);

      void saveUser(User person);

      void updateUser(int id, User updatedUser);

      public void deleteUser(int id);


}
