package com.rod.api.account;


import com.rod.api.common.AbstractService;
import com.rod.api.enums.Messenger;
import com.rod.api.member.Member;

import java.util.*;

public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    private static AccountServiceImpl instance = new AccountServiceImpl();
    List<Account> accounts;
    public static AccountServiceImpl getInstance() {
        return instance;
    }
    private AccountServiceImpl(){
        this.accounts = new ArrayList<>();
    }

    @Override
    public String deposit(Account account) {

        return "계좌 송금 성공";
    }

    @Override
    public String withdraw(Account account) {
        return "계좌 출금 성공";
    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }

    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Account account) {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
