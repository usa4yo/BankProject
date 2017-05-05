/**
 * Class        : DisplayOutput 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

import java.security.cert.PKIXRevocationChecker.Option;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DisplayOutput extends JFrame{
    /**
     *  Default serial version UID 
     */
    private static final long serialVersionUID = 1L;
    
    
    // Literal for the menu options
    public static final String LITERAL_BANK = "BOFM - Bank of Fake Money"; 
    public static final String LOGIN_USER_INFO = "Customer Information";
    public static final String OPEN_MESSAGE = "In order to signin with the BOFM, you need to provide your ";
    public static final String DOUBLE_MESSAGE = "You also have to make a deposit of $200.00 or more. How much would you like to deposit today?";    
    public static final String NEW_USER_OPEN = " New User Signin ";
    public static final String RETURNING_USER_LOGIN = " Returning User Login ";
    public static final String LITERAL_SELECT = "Welcome! How can I help you today?";
    public static final String LITERAL_OPEN = "Signin";
    public static final String LITERAL_LOGIN = "Login";
    public static final String LITERAL_EXIT = "Exit";    

    /**
     * @param bank The bank object is required here so you can find out if a customer is logged in
     */
    public void menu(Bank bank){
        if(null == bank.getCurrentCustomer()){
            // if no customer is logged in, display these menus:
            // Defined an array to hold the 2 principal options on the menu with a third option to exit if needed.
            List<String> optionList = new ArrayList<String>();
            
            // populate the array optionList with 1, 2, 3
            optionList.add(LITERAL_OPEN);
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
            String option = optionList.get(value); 
        
        } else {
            // if a customer is logged in, display these menus:
            System.out.println("Le Banque | User Name: "
                         + bank.getCurrentCustomer().getName()
                         + ", User ID: " 
                         + bank.getCurrentCustomer().getId() 
                         + ", Account: " 
                         + bank.getCurrentCustomer().getAccountNumber()
                         + ", Balance: " 
                         + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(bank.getCurrentCustomer().getBalance().getBalance()));
            
            if(bank.getCurrentCustomer().getBalance().getBalance() > 0){
                System.out.println("WITHDRAWAL");
            }
            // Display Deposit info and logout
            
        }
        // always display quit
          
    }


    /**
     * you get it.
     */
    public void popupNewCustomerDetailLine(Customer newCustomer) {

        String infoMessage = ("New Customer created: \n" 
                   + newCustomer.getName()
                   + " id = \n"
                   + newCustomer.getId()
                   + " account = \n"
                   + newCustomer.getAccountNumber());
        popupInfoLogin(infoMessage, LOGIN_USER_INFO);        
    }   // Ending bracket of popupNewCustomerDetailLine

    /**
     * Display Info box
     */
    public static void popupInfoBox(String infoMessage, String titleBar) {
        System.out.println("Now processing popupInfoBox");
        JOptionPane.showMessageDialog(null,  infoMessage, LITERAL_BANK + " " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }   // Ending bracket of popupInfoBox

    public static void popupInfoLogin(String infoMessage, String titleBar) {
        System.out.println("Now processing popupInfoLogin");
        JOptionPane.showMessageDialog(null,  infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }   // Ending bracket of popupInfoBox


    public static void login(String infoMessage) {
        System.out.println("Running the login method");
        System.out.println("Processing Customer Information");
        popupInfoLogin(infoMessage, LOGIN_USER_INFO);
        
    }   // Ending bracket of login method

    public static void output() {
        System.out.println("Running the output method");
        
    }   // Ending bracket of output method
}

