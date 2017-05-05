/**
 * Class        : BankDriver 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

public class BankDriver {
    private static Bank bank;
    private static DisplayInput input;
    private static DisplayOutput output;

    public static void main(String[] args) {

        initializeBank();
        
        TransactionType choice;
        do{
             Customer customer = bank.getCurrentCustomer();
             output.menu(bank);
             
             choice = input.pickTransaction();
             
             bank.Transaction(choice, customer, input, output);
             
        } while (choice != TransactionType.QUIT);
        
    }   // Ending bracket of the main method        

//        Display.input();
//        Display.output();

    /**
     *  when you start this up, there are some things that need to be initialized.
     */
    private static void initializeBank() {
        bank = new Bank();
        input = new DisplayInput();
        output = new DisplayOutput();
        
    }   // Ending bracket of initializeBank method
    
}   // Ending bracket of BankDriver Class
