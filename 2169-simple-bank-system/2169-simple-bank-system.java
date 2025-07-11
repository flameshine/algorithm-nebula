class Bank {

    private final Map<Integer, Long> accounts;

    public Bank(long[] balance) {
        this.accounts = IntStream.range(0, balance.length)
            .boxed()
            .collect(Collectors.toMap(k -> k + 1, v -> balance[v]));
    }
    
    public boolean transfer(int account1, int account2, long money) {
        
        if (!accounts.containsKey(account1) || !accounts.containsKey(account2)) {
            return false;
        }

        if (!withdraw(account1, money)) {
            return false;
        }

        deposit(account2, money);

        return true;
    }
    
    public boolean deposit(int account, long money) {
        
        if (!accounts.containsKey(account)) {
            return false;
        }

        accounts.merge(account, money, Long::sum);

        return true;
    }
    
    public boolean withdraw(int account, long money) {
        
        if (!accounts.containsKey(account)) {
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