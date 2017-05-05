/**
 * Class        : Customer 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

    public class Customer {

    private int id;
    private String accountNumber;
    private String customer;
    private Balance balance;
    
     public Customer(int newId, String newCustomer, String newAccountNumber, double newDeposit){
        this.id = newId;
        this.customer = newCustomer;
        this.accountNumber = newAccountNumber;
        this.balance = new Balance(newDeposit);
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id
     */
    public void setId(int newId) {
        this.id = newId;
    }
    /**
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }
    /**
     * @param customer the customer
     */
    public void setCustomer(String newCustomer) {
        this.customer = newCustomer;
    }
    /**
     * @return the Balance
     */
    public Balance getBalance() {
        return balance;
    }
    /**
     * @param balance the Balance
     */
    public void setBalance(Balance newBalance) {
        this.balance = newBalance;
    }
}
