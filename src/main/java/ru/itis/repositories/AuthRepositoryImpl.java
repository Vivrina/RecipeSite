package ru.itis.repositories;

import ru.itis.models.Auth;
import ru.itis.models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public class AuthRepositoryImpl implements AuthRepository{

    private Connection connection;


    //language=sql
    private final String SQL_INSERT_USER = "INSERT INTO auth(user_id, cookie_value) VALUES (?, ?);";

    //language=sql
    private final String SQL_SELECT_USER_BY_COOKIE = "select * from users u left join auth a on u.id_user = a.user_id where cookie_value = ?;";



    public AuthRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findByCookieValue(String cookieValue) {
        ResultSet resultSet = null;
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_COOKIE);
            preparedStatement.setString(1, cookieValue);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User();
                user.setId_user(resultSet.getLong("id_user"));
                user.setName(resultSet.getString("name"));
                user.setPasswordHash(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));

                user.setCreated(resultSet.getDate("created_at"));
            }
        } catch (SQLException throwables){
            //throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Optional<Auth> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Auth save(Auth auth) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, auth.getUser().getId_user());
            preparedStatement.setString(2, auth.getCookieValue());


            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                auth.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auth;
    }

    @Override
    public void deleteById(Long id) {

    }
}
