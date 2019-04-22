package com.kursach.repositories;

import com.kursach.models.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AuthRepositoryImpl implements AuthRepository {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthRepositoryImpl(DriverManagerDataSource driverManagerDataSource) {
        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }

    private static final String SAVE = "INSERT INTO auth_table (user_id, auth) values (?, ?)";
    private static final String DELETE = "DELETE FROM auth_table where user_id = ?";
    private static final String READ = "SELECT * FROM auth_table WHERE user_id = ?";

    public void save(Auth auth){
        jdbcTemplate.update(SAVE, auth.getUserId(), auth.getAuth());
    }

    public void delete(Integer vkId){
        jdbcTemplate.update(DELETE, vkId);
    }

    RowMapper<Auth> rowMapper = new RowMapper<Auth>() {
        @Override
        public Auth mapRow(ResultSet resultSet, int i) throws SQLException {
            return Auth.builder()
                    .userId(resultSet.getInt("user_id"))
                    .auth(resultSet.getString("auth"))
                    .build();
        }
    };

    public Auth read(Integer vkId){
        try {
            return jdbcTemplate.queryForObject(READ, rowMapper, vkId);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

}
