import java.util.List;

public interface Users {
    List<User> all();
    Long insert(User user);
}
