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
    
    private String name;
    private Balance balance;
    
     public Customer(int id, String name, String accountNumber, double firstDeposit){
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = new Balance(firstDeposit);
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
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
