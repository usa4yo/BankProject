import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class        : Display (input/output) 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

public class Display {
    
    // Literal for the menu options
    public static final String NEW_USER_SIGNIN = " New User Signin ";
    public static final String RETURNING_USER_LOGIN = " Returning User Login ";
    public static final String EXIT = " Exit";
 
    
    // Literal numbers
    public static final String LITERAL_BANK = "Bank of Fake Money - BOFM"; 
    public static final String LITERAL_SELECT = "Welcome! How can I help you today?";    
    public static final String LITERAL_SIGNIN = "Signin";
    public static final String LITERAL_LOGIN = "Login";
    public static final String LITERAL_EXIT = "Exit";    
    
    public static void mainProcess(){
        System.out.println("Running the mainProcess method");
        input();
        
    }   // Ending bracket of mainProcess method
    
    public static void input() {
        System.out.println("Running the input method");
        
        // Defined an array to hold the 2 principal options on the menu with a third option to exit if needed.
        List<String> optionList = new ArrayList<String>();
        
        // populate the array optionList with 1, 2, 3
        optionList.add(LITERAL_SIGNIN);
        optionList.add(LITERAL_LOGIN);
        optionList.add(LITERAL_EXIT);
        
        // Request the user to select a value from 1 to 3
        Object[] options = optionList.toArray();
        
        int value = JOptionPane.showOptionDialog(null,
                LITERAL_SELECT,
                LITERAL_BANK,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,                
                null,
                options,
                optionList.get(0));

        // store the value in variable opt
        String opt = optionList.get(value);
        
        // Derive the process according with the user selection using a switch statement
        switch (opt){
          
            // Menu option signin
            case LITERAL_SIGNIN:   
                signin();
                break;
            
             // Menu option login                
            case LITERAL_LOGIN:
                login();
                break;
            // If option 3 is selected exit
            default:
        }   //  End of switch
    }   // Ending bracket of input method
        
        
    public static void signin() {
        System.out.println("Running SIGN IN method");
        // a jframe here isn't strictly necessary, but it makes the example a little more real
        JFrame frame = new JFrame("InputDialog Example #1");

        // prompt the user to enter their userId and accountNo
        String name = JOptionPane.showInputDialog(
            frame, "In order to sign you in, you will need to provide your name?", "Full Name");

        double initialDeposit = Integer.parseInt( JOptionPane.showInputDialog(
            frame,
            "We also required an initial deposit of of $200.00 or more. How much would you like to deposit today?", 
            "200" 
        ));
       
        // get the user's input. note that if they press Cancel, 'name' will be null
        System.out.printf("Your name is '%s'.\n", name);
        // if the user presses Cancel, this will be null
        System.out.printf("Your initial deposit is '%s'.\n", initialDeposit);
        
//        Bank newCustomer = new Bank(name, initialDeposit);
        
    }   // Ending bracket of signin method

    public static void login() {
        System.out.println("Running the login method");
        
    }   // Ending bracket of login method


    public static void output() {
        System.out.println("Running the output method");
        
    }   // Ending bracket of output method
    
    
}   // Ending bracket of Display class
