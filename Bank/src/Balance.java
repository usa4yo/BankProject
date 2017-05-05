/**
 * Class        : Balance 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

public class Balance {
    private double balance;

    /**
     * @param firstDeposit
     */
    public Balance(double newDeposit){
        setBalance(newDeposit);
    }
       
    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param newBalance the balance to set
     */
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

}   // Ending bracket of Balance class
