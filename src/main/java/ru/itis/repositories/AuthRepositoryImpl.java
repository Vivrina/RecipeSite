package ru.itis.repositories;

import ru.itis.models.Auth;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class AuthRepositoryImpl implements AuthRepository{

    private Connection connection;
    private Statement statement;


    //language=sql
    private final String SQL_INSERT_USER = "INSERT INTO auth(user_id, cookie_value) VALUES (?, ?);";



    public AuthRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auth findByCookieValue(String cookieValue) {
        return null;
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
