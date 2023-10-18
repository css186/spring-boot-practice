package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public void transfer(Integer fromAccountId, Integer toAccountId, Integer money) {

        // User A 扣除轉帳金額
        accountDao.decreaseMoney(fromAccountId, money);

        // simulate exception
        Integer a = 1 / 0;

        // User B 收到轉入金額
        accountDao.addMoney(toAccountId, money);
    }
}
