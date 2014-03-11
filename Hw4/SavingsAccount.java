//sub class of BankAccount.java
public class SavingsAccount extends BankAccount{
  //interest rate is in decimal form e.g. 0.5%
  private double interestRate;
  
  //constructer SavingsAcount takes in parameters from parent class and sets the interest rate value.
  public SavingsAccount(int accountNum, String customerName, double balance, double interestRate){
    super(accountNum,customerName,balance);
    this.interestRate = interestRate;
  }
  //constructor is overloaded taking in different parameters in order to set the balance.
  public SavingsAccount(int accountNum, String customerName, double interestRate){
    super(accountNum, customerName);
    this.interestRate = interestRate;
    super.balance = 0;
  }
  //getter for data field interestRate
  public double getInterestRate(){
    return interestRate;
  }
  
  //adds the intersest rate of the balance back into the balance.
  public void accrueInterest(){
    super.balance += (this.balance)*(interestRate);
  }
    
}