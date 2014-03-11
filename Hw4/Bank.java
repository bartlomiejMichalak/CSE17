/*
 CSE 17
 Bart Michalak
 bpm215
 Homework #4      DEADLINE: October 12, 2012
 */
public class Bank{
  //data field declarations
  private String name;
  private SavingsAccount[] accounts;
  private int totalAccounts;
  //sets max ammount for accounts to 20.
  public static final int MAX_ACCOUNTS = 20;
  
  public Bank(String name){
    totalAccounts = 0;
    accounts = new SavingsAccount[MAX_ACCOUNTS];
    this.name=name;
  }
  //getter for name data field.
  public String getName(){
    return name;
  }
  //method addAccount 
  public void addAccount(int accountNum, String customerName, double balance, double interestRate){
    accounts[totalAccounts] = new SavingsAccount(accountNum, customerName, balance, interestRate);
    totalAccounts++;
  }
  
  public void printBankSummary(){
    System.out.println("Bank Name: " + name);
    for(int i=0; i<totalAccounts; i++){
      accounts[i].printAccountInfo();
    }
  }
  
  public void accrueInterestAllAccounts(){
    for(int i=0; i<totalAccounts; i++){
      accounts[i].accrueInterest();
    }
  }
  
  //main method for the program. hardcordes the names of the accounts as well as the deposits and interest rates.
  public static void main(String[] args){
    Bank bank = new Bank("Java S&L");
    bank.addAccount(42001, "Gordon Gekko", 85234.12, 0.001);
    bank.addAccount(42002, "Cheech Marin", 12.83, 0.0005);
    bank.addAccount(42003, "Average Joe", 392.52, 0.0008);
    bank.printBankSummary();
    //creates a blank line in between both prints.
    System.out.println();
    
    bank.accrueInterestAllAccounts();
    bank.printBankSummary();
  }
}
    
  