package com.sistemasactivos.jdbcByAry.interfaces;

import com.sistemasactivos.jdbcByAry.model.Account;

import java.util.List;

public interface AccountDAO {
    public List<Account> findAll();
    public Account findById(Long id);
    public boolean save(Account account);
    public Account update(Account account);
    public Boolean delete(Long id);
}
