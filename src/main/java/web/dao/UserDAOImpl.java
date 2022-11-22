package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void saveUser(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);

    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        entityManager.joinTransaction();
        User user = entityManager.find(User.class, id);
        user.setAge(updatedUser.getAge());
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

    }

    @Transactional
    public void deleteUser(int id) {
        entityManager.joinTransaction();
        entityManager.remove(showUser(id));
    }
}
