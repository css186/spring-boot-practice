package com.example.demo.dao;

public interface AccountDao {

    void decreaseMoney(Integer id, Integer money);

    void addMoney(Integer id, Integer money);
}
