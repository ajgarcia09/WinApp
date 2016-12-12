package win;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
/** A Setting class that is used to control a User 
 * account information and to check connectivity of a fitband
 * and add a fitband
 *
 *  @author Hector Cervantes
 *  @version 1.0 (11/10/16)
 *  @since version 1.0
 */
public class Setting{
	/** bandIsConnected- determines if band is connected.
	 * email- contains the user email
	 * password- contains the user password
	 */
	
	static boolean bandIsConnected = false;
	String email = "guccis@miners.utep.edu"; // used to debug
	String password = "funkmasterguccis"; // used to debug
			
	/** Checks if fitband is connected
	 * @return the connectivity status of a fitband
	 * */
	public boolean getBandStatus(){
		return bandIsConnected;
	}
	
	/** Asks user to connect a new fitband
	 * */
	// connects band;
	public boolean connectBand(boolean test){
		Scanner input = new Scanner(System.in);
		int run = 1;
		int operation;
		while(run == 1){
			if(test){
				operation = 1;
			}
			else{
				System.out.println("Would you like to turn on band? Enter 1 for yes or 2 for no");
			    operation = input.nextInt();
			}
			switch(operation){
			case 1:
				bandIsConnected = true;
				return true;
			case 2: 
				bandIsConnected = false;
				return false;
			default:
				System.out.println("Please enter eihter a 1 or a 2");
				run = 1;
			}
		}
		return false;
	}
	/** Changes the user password with verification
	 * */
	public boolean changePassword(boolean test, String p){
		String checkpassword = "";
		if(test){
		   checkpassword = p;
		}
		else{
			String checkPassword;
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter password");
		    checkPassword = input.nextLine();
		}
		if(checkpassword.equals(password)){
			password = checkpassword;
			return true;
		}
		else{
			System.out.println("That is an incorrect password");
			return false;
		}
	}
	/** Changes the user email with verification
	 * */
	public boolean changeEmail(boolean test, String p){
		String checkPassword = " ";
		Scanner input = new Scanner(System.in);
		if(test){
			checkPassword = p;
		}
		else{
			
			System.out.println("Please enter password");
			checkPassword = input.nextLine();
		}
		if(checkPassword.equals(password)){
			if(!test){
				System.out.println("Please enter new Email");
				String newEmail = input.nextLine();
				email = newEmail;
			}
			return true;
		}
		else{
			System.out.println("That is an incorrect password");
			return false;
		}
	}
	/** Changes the user email without verification
	 * @param email changing the current email
	 * */
	public void setEmail(String e){
		email = e;
	}
	/** Returns user email without verification
	 * @return the user email
	 * */
	public String getEmail(){
		return email;
	}
	/** Changes the user password without verification
	 * @param password changing the current password
	 * */
	public void setPassword(String p ){
		password = p;
	}
	/** Returns user password without verification
	 * @return the user password
	 * */
	public String getPassword(){
		return password;
	}

	
	
}




