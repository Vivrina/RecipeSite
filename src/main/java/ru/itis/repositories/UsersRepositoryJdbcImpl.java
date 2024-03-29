package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public class UsersRepositoryJdbcImpl implements UserRepository{
    private Connection connection;

    //language=sql
    private final String SQL_INSERT_USER = "INSERT INTO users(name, password, email) VALUES (?, ?, ?);";

    //language=SQL
    private final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE email=?;";


    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }



    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPasswordHash());
            preparedStatement.setString(3, user.getEmail());


            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId_user(resultSet.getLong("id_user"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User findByLogin(String email) {
        ResultSet resultSet = null;
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId_user(resultSet.getLong("id_user"));
                user.setName(resultSet.getString("name"));
                user.setPasswordHash(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));

                user.setCreated(resultSet.getDate("created_at"));
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        return user;
    }

}
