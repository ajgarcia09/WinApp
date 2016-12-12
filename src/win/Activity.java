package win;
/**Superclass activity that allows for the 
 * creation of various Activites
 * @author Ana J. Garcia
 * @version 1.0 (11/11/2016)
 *
 */
public class Activity {
	private int accountID;
	private int duration;
	private boolean inProgress;
	
	public Activity(int accountID, int duration, boolean inProgress) {
		super();
		this.accountID = accountID;
		this.duration = duration;
		this.inProgress = inProgress;
	}

	/**
	 * @return accountID a unique integer belonging
	 * to the user, which will be linked to his or
	 * her list of Activities
	 */	
	
	public int getAccountID() {
		return accountID;
	}
	
	/**
	 * @return duration- an integer representing
	 * the length of time an Activity lasted
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @return inProgress- a boolean variable
	 * that determines whether the current
	 * Activity is in progress
	 */
	public boolean isInProgress() {
		return inProgress;
	}

	/**
	 * @param accountID - a unique integer belonging to
	 * a user which will be used to link the user to 
	 * his or her set of Activities
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	/**
	 * @param duration - the amount of 
	 * time the current Activity lasted
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @param inProgress - a boolean that
	 * determines whether the current Activity 
	 * is in progress
	 */
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}
	
	/**Prints the subclass type of an 
	 * instance of type activity 
	 * @param activity1 an activity whose type needs to be printed
	 * @see User
	 */
	public void printActivityType(Activity activity1){
		System.out.println("Activity is of type:  " +  activity1.getClass().getTypeName());
		
	}
	
}
