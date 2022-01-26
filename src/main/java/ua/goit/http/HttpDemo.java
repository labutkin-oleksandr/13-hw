package ua.goit.http;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class HttpDemo {
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException, InterruptedException {
        //TASK 1
       // Task 1.1
        User newUser = createDefaultUser();
        final User createUser = HttpUtil.createUser(URI.create(USER_URL), newUser);
//        System.out.println("Create new user " + createUser);

        // Task 1.2
        newUser.setName("Artem");
        final User updateUser = HttpUtil.updateUser(URI.create(USER_URL), newUser);
//        System.out.println("Update new user " + updateUser);

        // Task 1.3
        final int statusCode = HttpUtil.deleteUser(URI.create(USER_URL), newUser);
//        System.out.println("Delete new user status code " + statusCode);

        // Task 1.4
        final List<User> users = HttpUtil.getAllUsers(URI.create(USER_URL));
//        System.out.println("All users");
//        users.forEach(System.out::println);

        // Task 1.5
        final User userById = HttpUtil.getUserById(URI.create(USER_URL), 2);
//        System.out.println("Get user by id " + userById);

        // Task 1.6
        final List<User> userByUsername = HttpUtil.getUserByUsername(URI.create(USER_URL), "Kamren");
//        System.out.println("Get user by username " + userByUsername);


        //TASK 2
        int userid = 1;
        final List<Post> userPosts = HttpUtil.getUserPosts(URI.create(USER_URL), userid);
        int idLastPost = userPosts.get(userPosts.size() - 1).getId();
        final List<Comment> userComments = HttpUtil.getUserComments(URI.create(POSTS_URL), idLastPost);
        WriteComments writeComments = new WriteComments();
        writeComments.writeComments(userid, idLastPost, userComments);


        //TASK 3
        final List<Todo> allOpenTodos = HttpUtil.getAllOpenTodos(URI.create(USER_URL), 1);
//        System.out.println("Get allOpenTodos ");
//        allOpenTodos.forEach(System.out::println);
    }

    private static User createDefaultUser() {
        User user = new User();
        user.setId(1);
        user.setName("Oleksandr");
        user.setUsername("La-Oleksandr");
        user.setEmail("lalala@gmail.com");
        user.setAddress(new Object());
        user.setPhone("067-000-00-00");
        user.setWebsite("myWebsite");
        user.setCompany(new Object());
        return user;
    }
}
