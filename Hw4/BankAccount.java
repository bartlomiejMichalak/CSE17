//BankAccount is has a composition relationship with savingsaccount. 
public class BankAccount{
  //data fields
  int accountNum;
  String customerName;
  double balance;
  
  //constructor for bankaccount. uses this. to set class variables.
  public BankAccount(int accountNum, String customerName, double balance){
    this.accountNum = accountNum;
    this. customerName = customerName;
    this.balance = balance;
  }
  //overloaded constructor for BankAccount taking in different parameters from first constructor.
  public BankAccount(int accountNum, String customerName){
    this.accountNum = accountNum;
    this.customerName = customerName;
    balance = 0;
  }
  //getter for accountNum
  public int getAccountNum(){
    return accountNum;
  }
  //getter for customerName
  public String getCustomerName(){
    return customerName;
  }
  //getter for data field balance.
  public double getBalance(){
    return balance;
  }
  //Add depositAmt to the account’s balance
  public void makeDeposit(double depositAmt){
    this.balance += depositAmt;
  }
  //Prints information about the account
  public void printAccountInfo(){
    System.out.printf("%5d %-20s %8.2f\n",accountNum,customerName,balance);
  }
}