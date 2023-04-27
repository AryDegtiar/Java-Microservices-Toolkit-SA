package com.sistemasactivos.jdbcByAry.repository;

import com.sistemasactivos.jdbcByAry.interfaces.AccountDAO;
import com.sistemasactivos.jdbcByAry.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(Long id) {
        try {
            String sql = "SELECT * FROM account WHERE id = ?";
            Account account = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Account.class));
            return account;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean save(Account account) {
        return jdbcTemplate.update("INSERT INTO account (`accalias`, `acctype`) VALUES (?, ?)",
                account.getAccalias(), account.getAcctype()) > 0;
    }

    @Override
    public Account update(Account account) {
        if (this.findById(account.getId()) == null) {
            return null;
        }
        jdbcTemplate.update("UPDATE account SET accalias = ?, acctype = ? WHERE id = ?",
                account.getAccalias(), account.getAcctype(), account.getId());
        return this.findById(account.getId());

    }

    @Override
    public Boolean delete(Long id) {
        return jdbcTemplate.update("DELETE FROM account WHERE id = ?", id) > 0;
    }


}
