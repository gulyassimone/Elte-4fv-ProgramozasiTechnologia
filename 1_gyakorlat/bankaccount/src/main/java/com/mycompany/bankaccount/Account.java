
package com.mycompany.bankaccount;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gulyas
 */
public class Account {
    private int balance;
    private final List<Integer> history;

    public Account() {
        this.balance = 0;
        this.history = new ArrayList<>();
    }
    
    
    
    public int getBalance() {
        return balance;
    }

    public List<Integer> getHistory() {
        return history;
    }
    
    public void deposit(int amount){
        if(amount < 0){
            throw new IllegalArgumentException("Negative value");
        }
        this.balance+=amount;
        history.add(amount);
    }
            
    public void withdraw(int amount){
        if(amount < 0 || balance < amount){
            throw new IllegalArgumentException();
        }
        this.balance-=amount;
        history.add(-amount);
    }
}
