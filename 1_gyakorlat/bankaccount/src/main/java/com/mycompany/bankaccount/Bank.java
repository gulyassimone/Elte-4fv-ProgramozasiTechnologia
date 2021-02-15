
package com.mycompany.bankaccount;

public class Bank {
    public static void main(String[] args) {
        Account acc = new Account();
        System.out.println(acc.getBalance());
        System.out.println(acc.getHistory());
        
        acc.deposit(4000);
        acc.deposit(5);
        acc.withdraw(4000);
        
        System.out.println(acc.getBalance());
        System.out.println(acc.getHistory());
    }    
}
