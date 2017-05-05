/**
 * Class        : DisplayOutput 
 * Project 12   : Banking
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-20
 * Last Mod.    : 2017-04-20
 * Due Date     : 2017-04-27
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DisplayOutput extends JFrame{
    /**
     *  Default serial version UID 
     */
    private static final long serialVersionUID = 1L;

    // Literal for String
    public static final String LITERAL_BANK = "BOFM - Bank of Fake Money"; 
    public static final String LOGIN_USER_INFO = "Customer Information";
    public static final String OPEN_MESSAGE = "In order to signin with the BOFM, you need to provide your ";
    public static final String DOUBLE_MESSAGE = "You also have to make a deposit of $200.00 or more. How much would you like to deposit today?";    
    public static final String NEW_USER_OPEN = " New User Signin ";
    public static final String RETURNING_USER_LOGIN = " Returning User Login ";
    public static final String LITERAL_SELECT = "Welcome! How can I help you today?";
    public static final String LITERAL_MENU = "What would you like to do?";
    public static final String LITERAL_BALANCE = "See Balance";
    public static final String LITERAL_DEPOSIT = "Make a Deposit";
    public static final String LITERAL_WITHDRAW = "Make a Withdraw";    
    public static final String LITERAL_OPEN = "Open Account";
    public static final String LITERAL_LOGIN = "Login";
    public static final String LITERAL_LOGOUT = "Logout";    
    public static final String LITERAL_EXIT = "Exit";    

    public static String option;
    /**
     * @param bank The bank object is required here so you can find out if a customer is logged in
     */
    public void menu(Bank bank){
        if(null == bank.getCurrentCustomer()){
            
            SelectMenu(option);
            System.out.println("Menu Option: " + option);
            
        
        } else {
            // if a customer is logged in, display these menus:
            popupNewCustomerDetailLine(bank.getCurrentCustomer());
            
            if(bank.getCurrentCustomer().getBalance().getBalance() > 0){
                System.out.println("WITHDRAW Transaction");
            }   // Ending bracket of inner if statement
        }
    }


    public static String SelectMenu(String selectOption){
        // Defined an array to hold the 2 principal options on the menu with a third option to exit if needed.
        List<String> optionMenu = new ArrayList<String>();
        
        // populate the array optionList with 1, 2, 3
        optionMenu.add(LITERAL_BALANCE);
        optionMenu.add(LITERAL_DEPOSIT);
        optionMenu.add(LITERAL_LOGIN);
        optionMenu.add(LITERAL_LOGOUT);
        optionMenu.add(LITERAL_OPEN);
        optionMenu.add(LITERAL_WITHDRAW);
        optionMenu.add(LITERAL_EXIT);
        
        // Request the user to select a value from 1 to 3
        Object[] options = optionMenu.toArray();
        
        int value = JOptionPane.showOptionDialog(null,
                LITERAL_SELECT,
                LITERAL_BANK,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,                
                null,
                options,
                optionMenu.get(0));

        return option = optionMenu.get(value); 
        
    }

    
    /**
     * Display Customer Info
     */
    public void popupNewCustomerDetailLine(Customer newCustomer) {

        String infoMessage = ("New Customer created: \n" 
                   + newCustomer.getCustomer()
                   + " id = \n"
                   + newCustomer.getId()
                   + " account = \n"
                   + newCustomer.getAccountNumber());
        popupInfoLogin(infoMessage, LOGIN_USER_INFO);        
    }   // Ending bracket of popupNewCustomerDetailLine

    /**
     * 
     * @param infoMessage
     * @param titleBar
     */
    public static void popupInfoBox(String infoMessage, String titleBar) {
        System.out.println("Now processing popupInfoBox");
        JOptionPane.showMessageDialog(null,  infoMessage, LITERAL_BANK + " " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }   // Ending bracket of popupInfoBox

    /**
     * 
     * @param infoMessage
     * @param titleBar
     */
    public static void popupInfoLogin(String infoMessage, String titleBar) {
        System.out.println("Now processing popupInfoLogin");
        JOptionPane.showInputDialog(infoMessage);
//        JOptionPane.showInputDialog(null,infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }   // Ending bracket of popupInfoLoggin

    /**
     * 
     * @param inputString
     * @param titleBar
     * @return
     * 
     */
    public static String requestInputString(String inputString, String titleBar) {
        System.out.println("Now processing requestInputString");
        JOptionPane.showInputDialog(null,  inputString, titleBar, JOptionPane.INFORMATION_MESSAGE);
        return inputString;
    }   // Ending bracket of popupInfoLoggin

    /**
     * 
     * @param inputDouble
     * @param titleBar
     * @return
     * 
     */
    public static double requestInputDouble(Double inputDouble, String titleBar) {
        System.out.println("Now processing requestInputDouble");
        JOptionPane.showInputDialog(null,  inputDouble, titleBar, JOptionPane.INFORMATION_MESSAGE);
        return inputDouble;
    }   // Ending bracket of popupInfoLoggin

    /**
     * 
     * @param inputInteger
     * @param titleBar
     * @return
     * 
     */
    public static int requestInputInteger(int inputInteger, String titleBar) {
        System.out.println("Now processing requestInputInteger");
        JOptionPane.showInputDialog(null,  inputInteger, titleBar, JOptionPane.INFORMATION_MESSAGE);
        return inputInteger;
    }   // Ending bracket of popupInfoLoggin
    
}   // Ending bracket of DisplayOutput class

