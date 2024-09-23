package project.people.DAO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import project.people.models.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class UserDAO {
    private static int PEOPLE_COUNTER;
    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++PEOPLE_COUNTER, "Tom", "Cruz", 18));
        users.add(new User(++PEOPLE_COUNTER, "John", "Smith", 20));
        users.add(new User(++PEOPLE_COUNTER, "Sam", "Kroger", 40));
        users.add(new User(++PEOPLE_COUNTER, "Bob", "Marli", 15));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void saveUser(User user) {
        user.setId(++PEOPLE_COUNTER);
        users.add(user);
    }

    public void updateUserById(int id , User updateUser) {
        User uniqUser = getUserById(id);
        uniqUser.setLastName(updateUser.getLastName());
        uniqUser.setName(updateUser.getName());
        uniqUser.setAge(updateUser.getAge());
    }

    public void deleteUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
