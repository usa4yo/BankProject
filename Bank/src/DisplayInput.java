
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
    private int userId;
    private double userAmount;
    private String userInfo;
   
    // Literal for integer
    public static final int LITERAL_INTEGER_DEFAULT = 000;

    // Literal for double
    public static final double LITERAL_DOUBLE_DEFAULT = 200.00;    

    // Literal for String
    public static final String LITERAL_BANK = "BOFM - Bank of Fake Money";
    public static final String LITERAL_STRING_DEFAULT = "Full Name";
    public static final String LITERAL_QUIT = "QUIT";
    
    
    
    public DisplayInput(){
        super();
        this.userId = LITERAL_INTEGER_DEFAULT;
        this.userAmount = LITERAL_DOUBLE_DEFAULT;
        this.userInfo = LITERAL_STRING_DEFAULT;
    }
    
    public DisplayInput(int userId, double userAmount, String userInfo) {
        this.userId = userId;
        this.userAmount = userAmount;
        this.userInfo = userInfo;
    }   // Ending bracket of constructor userId, userAmount, userInfo

    public DisplayInput(int newUserId){
        this.userId = newUserId;
    }   // Ending bracket of constructor userId
    
    public DisplayInput(double newUserAmount){
        this.userAmount = newUserAmount;
    }   // Ending bracket of constructor userAmount

    public DisplayInput(String newUserInfo){
        this.userInfo = newUserInfo;
    }   // Ending bracket of constructor userInfo
    
    /**
     * @return a TransactionType.  Won't return until they've picked a valid one.
     */
    public TransactionType pickTransaction(){
        boolean valid = false;
        String option = LITERAL_QUIT;
        
        TransactionType returnValue;
        System.out.println("The return value is: " + userInfo);
        
        do{
            String response = DisplayOutput.SelectMenu(option);
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
            value = DisplayOutput.requestInputDouble(LITERAL_DOUBLE_DEFAULT, LITERAL_BANK);
            
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
        return DisplayOutput.requestInputString(LITERAL_STRING_DEFAULT, LITERAL_BANK);
    }

    /**
     * @return the id they entered.  it's the only time we use ints in this input class.
     */
    public int requestId() {
        return DisplayOutput.requestInputInteger(LITERAL_INTEGER_DEFAULT, LITERAL_BANK);
    }
}
