

import java.util.ArrayList;
import java.util.List;

/**
 * Class        : Bank 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

public class Bank {
    private List<Customer> customers;
    private Customer currentCustomer;
    
    // Literal for integer
    public static final int LITERAL_INTEGER_DEFAULT = 000;

    // Literal for double
    public static final double LITERAL_DOUBLE_DEFAULT = 200.00;    

    // Literal for String
    public static final String LITERAL_BANK = "BOFM - Bank of Fake Money";
    public static final String LITERAL_STRING_DEFAULT = "Full Name";
    public static final String LITERAL_ACCOUNT_NUMBER = "Please Enter your account number (XXNNN)";

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }
    /**
     * @param customers the customers
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    
    /**
     * @return the customer who's logged in
     */
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
    /**
     * @param currentCustomer the current customer. only set on successful login
     */
    private void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
    
    /**
     *  constructors gonna construct... -uct -uct.
     */
    public Bank(){
        customers = new ArrayList<Customer>();
    }
    
    /**
     * @param name Like "Bob" or "Larry".
     * @param initialDeposit how much bread they got
     * @return the Customer object you just created, so that we can pass its data to the output routine.
     */
    public Customer createCustomer(String name, double initialDeposit){
        
        int customerId = createUniqueId();
        String accountNumber = createUniqueAccountNumber();
        
        Customer customer = new Customer(customerId, name, accountNumber, initialDeposit);
        
        customers.add(customer);
        
        return customer;
    }
    
    /**
     * @param id the id.
     * @param accountNumber the account number
     * @return The customer account, if it exists.
     */
    public Customer getCustomer(int id, String accountNumber){
        for(Customer customer: customers){
            if(id == customer.getId() && accountNumber.equals(customer.getAccountNumber())){
                return customer;
            }
        }
        return null;
    }

    /**
     * @return a unique-to-this-bank account number in the format AA999. Case sensitive.
     */
    private String createUniqueAccountNumber() {
        
        boolean unique = true;
        String newId = "";
        
        do{
            newId = assembleNewAccountId();
            
            for(Customer customer:customers){
                if(customer.getAccountNumber().equals(newId)) {
                    unique = false;
                    break;
                };
            }
        } while(!unique);
        
        return newId;
    }

    /**
     * @return a potential account id that needs to be checked for uniqueness
     */
    private String assembleNewAccountId() {
        String myString = "";
        
        myString += getRandomChar();
        myString += getRandomChar();
        myString += (int) (Math.random() * 10);
        myString += (int) (Math.random() * 10);
        myString += (int) (Math.random() * 10);
        
        return myString;
    }

    /**
     * @return a random char.  Shocker, eh?
     */
    private char getRandomChar() {
        char myChar = (char) (int) (Math.random() * 26 + 65);
        
        if(Math.random() > 0.5){
            myChar = Character.toLowerCase(myChar);
        }
        
        return myChar;
    }

    /**
     * @return a unique-to-this-bank 3-digit number.
     */
    private int createUniqueId() {
        
        boolean unique = true;
        int newId = 0;
        
        do{
            newId = (int) (Math.random() * 899) + 100;
            
            for(Customer customer:customers){
                if(customer.getId() == newId) {
                    unique = false;
                    break;
                };
            }
        } while(!unique);
        
        return newId;
    }

    /**
     * @param choice which transaction they picked
     * @param customer who they are, if someone's logged in
     * @param input The input class
     * @param output The output class
     */
    public void Transaction(TransactionType choice, Customer customer, DisplayInput input, DisplayOutput output) {
        switch(choice){
        case LOGIN:
            output.requestInputInteger(LITERAL_INTEGER_DEFAULT, LITERAL_BANK);
            int id = input.requestId();
            
            output.requestInputString(LITERAL_ACCOUNT_NUMBER, LITERAL_BANK);
            String account = input.requestString();
            
            setCurrentCustomer(getCustomer(id, account));
            
            break;
            
        case LOGOUT:
            setCurrentCustomer(null);

            break;
            
        case OPEN:
            output.requestInputString(LITERAL_STRING_DEFAULT, LITERAL_BANK);
            String name = input.requestString();
            
            output.requestInputDouble(LITERAL_DOUBLE_DEFAULT, LITERAL_BANK);
            double value = input.requestAmount(200, -1);
            
            Customer newCustomer = createCustomer(name, value);
            
            output.popupNewCustomerDetailLine(newCustomer);
            
            break;
            
        case WITHDRAW:
            Withdraw withdraw = new Withdraw();
            
//            output.printAmountPrompt();
            
            withdraw.doTransaction(currentCustomer, input.requestAmount(0, currentCustomer.getBalance().getBalance()));
            
            break;
            
        case DEPOSIT:
            Deposit deposit = new Deposit();
            
//            output.printAmountPrompt();
            
            deposit.doTransaction(currentCustomer, input.requestAmount(0, -1));
            break;
            
        case QUIT:
            //no-op.  sends us back to the main loop
            
            break;
        
        default:

            break;

        }
    }
}
