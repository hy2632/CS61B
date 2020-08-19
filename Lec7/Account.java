public class Account {
    public int balance;

    public Account(int balance0){
        this.balance = balance0;
    }
    public int deposit(int amount){
        this.balance += amount;
        return balance;
    }
    public int withdraw(int amount){
        if (balance < amount)
            throw new IllegalStateException("Insufficient funds");
        else balance -= amount;
        return balance;
    }

    private static int _funds = 0; // private变量前加_
    public static int funds(){
        return _funds; //or Account._funds
    } //class-wide === static;

    public static void main(String[] args){
        Account acc1 = new Account(30);
        System.out.println(acc1.deposit(50));
        System.out.println(acc1.withdraw(20));
    }

    
}