// Author: Ali Kaddoura

import java.util.HashMap;

import java.util.HashMap;

public class BankAccount {
    private double balance;

    public BankAccount(double initBalance) {
        balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance +amount;
    }

    public void withdraw(double amount) {
        balance =balance -amount;
    }
}

class RegularAccount extends BankAccount {
    public RegularAccount(double initBalance) {
        super(initBalance);
    }
}

class SafeAccount extends BankAccount {
    public SafeAccount(double initBalance) {
        super(initBalance);
    }

    @Override
    public void withdraw(double amount) {
    	double currentBalance = getBalance();
        if (currentBalance >= amount)
            super.withdraw(amount);
    }
}

class Test {
	
	
	 void test() {
		HashMap<String, BankAccount> accounts = new HashMap<>();

		  accounts.put("kim", new RegularAccount(100));

		  accounts.put("chris", new SafeAccount(100));

		 

		  accounts.get("kim").withdraw(199.13);

		  accounts.get("chris").withdraw(147.78);

		 

		
	}
}


	


