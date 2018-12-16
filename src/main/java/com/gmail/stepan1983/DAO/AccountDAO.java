package com.gmail.stepan1983.DAO;

import com.gmail.stepan1983.model.Account;

import com.gmail.stepan1983.model.Currency;

public interface AccountDAO {

    Account addAccount(Account accountToAdd);

    void deleteAccount(Long id);

    void putMonney(Long accId, Double ammount, Currency currency);

    void withdrawMoney(Long accId, Double ammount, Currency currency);

}
