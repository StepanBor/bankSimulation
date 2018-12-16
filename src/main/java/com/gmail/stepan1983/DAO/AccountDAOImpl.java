package com.gmail.stepan1983.DAO;

import com.gmail.stepan1983.model.Account;
import com.gmail.stepan1983.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import com.gmail.stepan1983.model.Currency;

@Component
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    EntityManagerFactory emf;

    EntityManager entityManager;

    public Account addAccount(Account accountToAdd) {
        return entityManager.merge(accountToAdd);
    }

    public void deleteAccount(Long id) {

        entityManager.getTransaction().begin();
        Account account=entityManager.find(Account.class,(Long) id);
        if (account==null){
            return;
        }
        User user=account.getUser();
        user.getUserAccounts().remove(account);
        entityManager.remove(account);
        entityManager.getTransaction().commit();

    }

    public void putMonney(Long accId, Double ammount, Currency currency) {

        entityManager.getTransaction().begin();
        Account account=entityManager.find(Account.class,(Long) accId);
        if (account==null){
            return;
        }
        account.setMonneyAmmount(account.getMonneyAmmount()
                +ammount*currency.getRate_USD()
                *account.getCurrency().getRate_USD());

        entityManager.getTransaction().commit();

    }

    public void withdrawMoney(Long accId, Double ammount, Currency currency) {

        entityManager.getTransaction().begin();
        Account account=entityManager.find(Account.class,(Long) accId);
        if (account==null){
            return;
        }
        account.setMonneyAmmount(account.getMonneyAmmount()
                -ammount*currency.getRate_USD()
                *account.getCurrency().getRate_USD());
        entityManager.getTransaction().commit();

    }
}
