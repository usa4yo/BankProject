/**
 * Class        : Deposit 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

public class Deposit implements TransactionInterface {

    @Override
    public void doTransactionInterface(Customer customer, double amount) {
        customer.getBalance().setBalance(customer.getBalance().getBalance() + amount);
    }

}

