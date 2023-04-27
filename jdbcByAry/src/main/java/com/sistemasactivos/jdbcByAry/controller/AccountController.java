package com.sistemasactivos.jdbcByAry.controller;

import com.sistemasactivos.jdbcByAry.model.Account;
import com.sistemasactivos.jdbcByAry.repository.AccountDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {
    @Autowired
    private AccountDAOImpl eDAO;

    @GetMapping("/account")
    public List<Account> findAll(){
        System.out.println("findAll() called");
        return eDAO.findAll();
    }

    @GetMapping("/account/{id}")
    public Account findById(@PathVariable("id") Long id){
        System.out.println("findById() called");
        return eDAO.findById(id);
    }

    @PostMapping("/account")
    public boolean save(@RequestBody Account account){
        System.out.println("save() called");
        return eDAO.save(account);
    }

    @PutMapping("/account/{id}")
    public Account update(@RequestBody Account account, @PathVariable("id") Long id){
        System.out.println("update() called");
        if (account.getId() == id) {
            return eDAO.update(account);
        }
        return null;
    }

    @DeleteMapping("/account/{id}")
    public Boolean delete(@PathVariable("id") Long id){
        System.out.println("delete() called");
        return eDAO.delete(id);
    }

}
