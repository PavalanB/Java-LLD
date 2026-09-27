package LLD.Bank;

class BankAccount{
    private int accNo;
    private String holName;
    private int balance;
    public void setAccNo(int accNo){
        this.accNo=accNo;
    }
    public void setHolName(String holName){
        this.holName=holName;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }
    public int getAccNo(){
        return accNo;
    }
    public String getHolName(){
        return holName;
    }
    public int getBalance(){
        return balance;
    }
    BankAccount(int accNo,String holName,int balance){
        setAccNo(accNo);
        setHolName(holName);
        setBalance(balance);
    }
    void deposit(int add){
        int bal=getBalance();
        setBalance(bal+add);
    }
    void withdraw(int rem){
        int bal=getBalance();
        if(bal>=rem){
            setBalance(bal-rem);
        }else{
            System.out.println("Insufficient balance!!");
        }
    }
    void displayAccount(){
        System.out.println("Accoount Number: "+accNo);
        System.out.println("Account Holder Name: "+holName);
        System.out.println("Balance: "+balance);
    }
}

public interface AccountOperations{
    void deposit(int amt);
    void withdraw(int rem);
}

class SavingAccount extends BankAccount implements AccountOperations{
    private int interestRate;
    public void setInterestRate(int interestRate){
        this.interestRate=interestRate;
    }
    public int getInterestRate(){
        return interestRate;
    }
    SavingAccount(int accNo,String holName,int balance,int interestRate){
        super(accNo,holName,balance);
        setInterestRate(interestRate);
    }
    int calculateInterest(){
        int amt=getBalance();
        return amt/interestRate;
    }
    @Override
    public void withdraw(int rem){
        boolean ch=true;
        while(ch){
            int bal=getBalance();
            if(bal>=rem){
                setBalance(bal-rem);
                ch=false;
            }else{
                System.out.println("Insufficient balance!!");
            }
        }
    }
    @Override 
    public void deposit(int amt){
        int bal=getBalance();
        setBalance(bal+amt);
    }
}

class CurrentAccount extends BankAccount implements AccountOperations{
    private int odLimit;
    public void setOdLimit(int odLimit){
        this.odLimit=odLimit;
    }
    public int getOdLimit(){
        return odLimit;
    }
    CurrentAccount(int accNo,String holName,int balance,int odLimit){
        super(accNo,holName,balance);
        setOdLimit(odLimit);
    }
    @Override 
    public void withdraw(int rem){
        int ch=getOdLimit();
        if(ch>=0){
            int bal=getBalance();
            if(bal>=rem){
                setBalance(bal-rem);
                ch--;
            }else{
                System.out.println("Insufficient balance!!");
            }
        }
    }
    @Override 
    public void deposit(int amt){
        int bal=getBalance();
        setBalance(bal+amt);
    }
}

class Main{
    public static void main(String[] args){
        BankAccount sav=new SavingAccount(200,"Prime",50000,5);
        BankAccount cur=new CurrentAccount(202,"Zaira",40000,2);
        sav.deposit(500);
        sav.withdraw(200);
        sav.displayAccount();
        cur.deposit(1500);
        cur.withdraw(2000);
        cur.displayAccount();

    }
}