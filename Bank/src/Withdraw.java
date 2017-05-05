/**
 * Class        : Withdraw 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

public class Withdraw {
    
    public void doTransaction(Customer customer, double amount) {
        customer.getBalance().setBalance(customer.getBalance().getBalance() - amount);
    }

}   // Ending bracket of Withdraw class
