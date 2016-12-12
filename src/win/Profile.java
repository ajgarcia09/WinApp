package win;
import java.util.*;
/** The Profile class can create a new Profile and manage the user needs */
public class Profile{
	
public static Scanner scan = new Scanner (System.in);
/*
 *   Variables used in setFistnesGoals: 
 */
	public static char workoutType;
	public static boolean swimFlag = false;
	public static int num_Goal_Cycles;
	public static int [] swim_Style_Goal = new int [5];
	public static boolean isCycle;
	public static int swimRecord = 0;
	public static int numStyles;
	public static int numKmGoal;
	public static int numCycles;
	public static int [] swimStyle = new int[5];
	public static int numKm;
	public static int runRecord = 0;
	
/*
 *  Variables used in Profile: 
 */
	protected static myProfile Profile;
	protected static Goals newGoals;
	
	/* Crates a new Profile */
	protected static void createProfile(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter your Name: ");
		String Name = scan.nextLine();
		System.out.println();
		
		System.out.print("Enter your LastName: ");
		String LastName = scan.nextLine();
		System.out.println();
		
		System.out.print("Enter your Desired Username: ");
		String Username = scan.nextLine();
		System.out.println();
		
		System.out.print("Enter your Desired Password: ");
		String Password = scan.nextLine();
		System.out.println();
		
		System.out.print("Enter your Age: ");
		int Age = scan.nextInt();
		System.out.println();
		
		System.out.print("Enter your Weight: ");
		double Weight = scan.nextDouble();
		System.out.println();
		
		System.out.print("Enter your Height: ");
		double Height = scan.nextDouble();
		System.out.println();
		
		Profile = new myProfile(Name, LastName, Username, Password, Age, Weight, Height);
		
		scan.close();
	}
	/* Sets a new goal and can update a old one*/
	protected static void setFitnesGoals() {
		Goals.setNewGoals();
	}
	/* Change the current Password */
	protected static boolean changePassword(){
		System.out.print("Enter your new Password: ");
		String newPassword = scan.nextLine();
		String oldPassword = Profile.getPassword();
		Profile.setPassword(newPassword);
		if(oldPassword == Profile.getPassword())
			return false;
		else
			return true;
	}
	/* Change the current Username */
	protected static boolean changeUsername(){
		System.out.print("Enter your new Username: ");
		String newUsername = scan.nextLine();
		String oldUsername = Profile.getUsername();
		Profile.setUsername(newUsername);
		if(oldUsername == Profile.getPassword())
			return false;
		else
			return true;
	}
	/* View your current Goals */
	protected static void viewCurrentGoals(){
		Goals.viewGoals();
	}
	
//	public static void main (String [] args){
//		createProfile();
//		setFitnesGoals();
//		changePassword();
//		changeUsername();
//		viewCurrentGoals();
//	}
}
