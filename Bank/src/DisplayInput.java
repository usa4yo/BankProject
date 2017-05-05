
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class        : DisplayInput
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */


public class DisplayInput {
    private DisplayOutput output;
    private Bank bank;

    public static final int LITERAL_INITIAL_DEPOSIT = 200;

    public static final String LITERAL_BANK = "BOFM - Bank of Fake Money";
    
    public static final String LITERAL_FULL_NAME = "Full Name";
    public static final String OPEN_MESSAGE = "In order to signin with the BOFM, you need to provide your ";
    public static final String DOUBLE_MESSAGE = "You also have to make a deposit of $200.00 or more. How much would you like to deposit today?";    
    public static final String LOGIN_USER_INFO = "Customer Information";
    public static final String LOGIN_MESSAGE = "Please Enter your 3 digit CustomerId";    
    public static final String LITERAL_CUSTOMER_ID = "NNN";
    public static final String LITERAL_ACCOUNT_NO = "XXNNN";
    public static final String ACCOUNT_NO_MESSAGE = "Please Enter your 5 digit Account Number";    
    public static final String LITERAL_OPEN = "Signin";
    public static final String LITERAL_LOGIN = "Login";


    
    /**
     * @return a TransactionType.  Won't return until they've picked a valid one.
     */
    public TransactionType pickTransaction(){
        boolean valid = false;

        TransactionType returnValue;
        
        do{
            String response = "QUIT"; // To be change for the value of user selected choices

            System.out.println("Value of response after welcomeMenu: " + response);
            
            processResponse(response);
            System.out.println("Value of response after processResponse: " + response);
            
            try{
                returnValue = TransactionType.valueOf(response.toUpperCase());
                valid = true;
            } catch(IllegalArgumentException myException){
                returnValue = null;
                valid = false;
            }
        } while(!valid);
        
        return returnValue;
    }
    
    /**
     * @param minAmount the minimum amount we'll allow.  0 is the lowest you can go, no negatives.
     * @param maxAmount the maximum amount we'll allow.  if you pick -1, you get MAX_DOUBLE. 
     * @return the amount they entered.
     */
    public double requestAmount(double minAmount, double maxAmount){
        boolean valid = false;
        double value = -1;
        
        if(minAmount < 0){
            minAmount = 0;
        }
        
        if(maxAmount < 0){
            maxAmount = Double.MAX_VALUE;
        }
        
        do{
//            value = keyboard.nextDouble();
            
            if(value > minAmount && value < maxAmount){
                valid = true;
            }
            
        } while (!valid);
        
        return value;
    }


    /**
     * @return the string they entered.
     */
    public String requestString() {
        return  "requestString";
    }

    /**
     * @return the id they entered.  it's the only time we use ints in this input class.
     */
    public int requestId() {
        return 000;
    }
    
     
    public void processResponse(String response){
        // Derive the process according with the user selection using a switch statement
        switch (response){
          
            // Menu option signin
            case LITERAL_OPEN:   
                popupInputString(OPEN_MESSAGE, LITERAL_FULL_NAME);
                popupInputDouble(DOUBLE_MESSAGE, LITERAL_INITIAL_DEPOSIT);

                break;
            
             // Menu option login                
            case LITERAL_LOGIN:
                String infoMessage = ("BOFM - Bank User INformation \n");
                if(null == bank.getCurrentCustomer()){
                    popupInputString(LOGIN_MESSAGE, LITERAL_CUSTOMER_ID);
                    popupInputString(ACCOUNT_NO_MESSAGE, LITERAL_ACCOUNT_NO);                     
                } else {    
                    infoMessage = ("BOFM - Bank User INformation \n"
                          + bank.getCurrentCustomer().getName()
                          + ", User ID: \n")
                          + bank.getCurrentCustomer().getId()
                          + ", Account: \n" 
                          + bank.getCurrentCustomer().getAccountNumber()
                          + ", Balance: \n" 
                          + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(bank.getCurrentCustomer().getBalance().getBalance());
                    if(bank.getCurrentCustomer().getBalance().getBalance() > 0){
                        System.out.println("WITHDRAWAL");
                } // Ending bracket of if statement
            }                
            break;
            // If option 3 is selected exit
        default:
            // Some output            
        }   //  End of switch
    }
    
    
    public void popupInputString(String inputMessage, String inputDialog) {
        System.out.println("Now processing popupInputString");
        // a jframe here isn't strictly necessary, but it makes the example a little more real
        JFrame frame = new JFrame();

        // prompt the user to enter their userId and accountNo
        String name = JOptionPane.showInputDialog(frame, inputMessage, inputDialog);

        System.out.printf("Your name is %s.\n", name);
    }   //Ending bracket of popupInputString method

    public  void popupInputDouble(String inputMessage, int inputDialog) {
        System.out.println("Now processing popupInputDouble");        
        // a jframe here isn't strictly necessary, but it makes the example a little more real
        JFrame frame = new JFrame();

        // prompt the user to enter their userId and accountNo        
        double initialDeposit = Integer.parseInt(JOptionPane.showInputDialog(frame, inputMessage, inputDialog));

        // if the user presses Cancel, this will be null
        System.out.printf("Your initial deposit is $%6.2f.\n", initialDeposit);
        
    }   // Ending bracket of signin method

}
