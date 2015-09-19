package com.github.monikaemm.users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiluchM on 2015-09-19.
 */
public class UsersRepository {
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UsersRepository usersRepository = new UsersRepository();
        List<User> allUsers = usersRepository.getAllUsers();
        System.out.println(allUsers);
        User userByLogin = usersRepository.getUserByLogin("uz1", "pass1");
        System.out.println(userByLogin);
        User userByLogin2 = usersRepository.getUserByLogin("uz1", "pass10");
        System.out.println(userByLogin2);
        User userByLogin3 = usersRepository.getUserByLogin("uz1", "' OR '' = '");
        System.out.println(userByLogin3);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> listUsers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:h2:D:/---Java---/database/calendarDB", "sa", "")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FIRST_NAME, SURNAME, LOGIN " +
                    "FROM  USERS");
            while (resultSet.next()) {
                User user = createUserFromRow(resultSet);
                listUsers.add(user);
            }
        }
        return listUsers;
    }

    public User getUserByLogin(String login, String password) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:D:/---Java---/database/calendarDB", "sa", "")) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT FIRST_NAME, SURNAME, LOGIN " +
                    "FROM  USERS WHERE LOGIN = ?  AND PASSWORD = ? ");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createUserFromRow(resultSet);
            }
        }
        return null;
    }

    private User createUserFromRow(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("FIRST_NAME");
        String surname = resultSet.getString("SURNAME");
        String login = resultSet.getString("LOGIN");

        User user = new User();
        user.setFirstname(firstName);
        user.setSurname(surname);
        user.setLogin(login);

        return user;
    }
}
