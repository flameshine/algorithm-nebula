class Bank {

    private final Map<Integer, Long> accounts;
    private final int n;

    public Bank(long[] balance) {
        this.n = balance.length;
        this.accounts = IntStream.range(0, balance.length)
            .boxed()
            .collect(Collectors.toMap(k -> k + 1, v -> balance[v]));
    }
    
    public boolean transfer(int account1, int account2, long money) {
        
        if (account1 > n || account2 > n) {
            return false;
        }

        if (!withdraw(account1, money)) {
            return false;
        }

        deposit(account2, money);

        return true;
    }
    
    public boolean deposit(int account, long money) {
        
        if (account > n) {
            return false;
        }

        accounts.merge(account, money, Long::sum);

        return true;
    }
    
    public boolean withdraw(int account, long money) {
        
        if (account > n) {
            return false;
        }

        var value = accounts.get(account);

        if (value < money) {
            return false;
        }

        accounts.merge(account, -money, Long::sum);

        return true;
    }
}