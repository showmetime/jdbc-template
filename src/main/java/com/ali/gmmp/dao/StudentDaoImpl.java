package com.ali.gmmp.dao;

import com.ali.gmmp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: ASUS
 * @description: TODO
 * @Date: 22:56 2020/6/24
 */
@Repository("userDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insert(User user) {
        int update = jdbcTemplate.update("insert into user(peoNum,peoIdCard,peoTel,peoEmail,peoDates) " +
                        "values (?,?,?,?,?)", user.getPeoNum(), user.getPeoIdCard(),
                user.getPeoTel(), user.getPeoEmail(), user.getPeoDates());
        return update;
    }

    @Override
    public int update(User user) {
        int update = jdbcTemplate.update("update user set peoIdCard=? where peoNum = ?", user.getPeoIdCard(),
                user.getPeoNum());
        return update;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User(resultSet.getString("peoId"),
                        resultSet.getString("peoIdCard"));
                return user;
            }
        };
        return jdbcTemplate.query("select * from bank.user", rowMapper);
    }

    @Override
    public void update(List<User> users) {
        String sql = "update user set peoId = ?,peoIdCard=?," +
                "peoEmail = ?,peoDate = ? where peoPhone=?";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                User user = users.get(i);
                preparedStatement.setString(1, user.getPeoNum());
                preparedStatement.setString(2, user.getPeoIdCard());
                preparedStatement.setString(3, user.getPeoEmail());
                preparedStatement.setString(4, user.getPeoDates());
                preparedStatement.setString(5, user.getPeoTel());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }

}
