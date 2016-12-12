package win;
import java.util.Scanner;
/**Used to log activities such 
 * as exercise and sleep on the user's
 * account. Each user has one ActivityLogger
 * @author Ana J. Garcia
 * @version 1.0 (11/11/2016)
 * @see User
 * @see Activity
 *
 */
public class ActivityLogger {
	private int accountID;
	public Scanner userInput = new Scanner(System.in);
	public ActivityLogger(int accountID) {
		this.accountID = accountID;
	}
	/**Return an Activity logged by the user 
	 * @return an instance of Activity (Workout or Sleep) 
	 * 		   or null if there was an error logging in an activity
	 * @see ActivityLogger#logWorkout()
	 * @see ActivityLogger#logSleep()
	 * 
	 */
//	public Activity logActivity(){
//		System.out.println("What kind of activity would you like to log?");
//		System.out.println("Workout or Sleep?");
//		String choice = userInput.nextLine();
//		if(choice.equals("workout")){
//			Workout w1 = logWorkout();
//			return w1;
//		}			
//		if(choice.equals("sleep")){
//			Sleep s1 = logSleep();
//			return s1;
//		}
//		else{
//			System.out.println("Couldn't log activity");
//		}
//
//		return null;
//	}
	/**Return an instance of Workout
	 * 
	 * @return Run, Swim (Workout subclasses) or null if there was an error 
	 * creating a new instance of type Workout
	 * @see logRun()
	 * @see logSwim()
	 */
//	public Workout logWorkout (){
//		System.out.println("What kind of workout did you do?");
//		String workoutChoice = userInput.nextLine();
//		if(workoutChoice.equals("run")){
//			Run r1 =  logRun();
//			return r1;
//		}
//		if(workoutChoice.equals("swim")){
//			Swim sw1 = logSwim();		
//			return sw1;
//		}
//		return null;
//	}

	/**Prompt the user for details 
	 * on his or her run and return an 
	 * instance of Run 
	 * @return r1, a newly created Run instance
	 * @see Run
	 */
	public Run logRun(int runDistance, int runDuration){
		Run r1 = new Run (accountID, runDuration, false, runDistance);
		return r1;
	}

	/**Prompt the user for details
	 * on his or her swim and return
	 * an object of type Swim
	 * @return sw1, a new Swim instance
	 * @see Swim
	 */
	public Swim logSwim(int swimDuration, int numLaps, int numCycles){
		
		Swim sw1 = new Swim(accountID,swimDuration,false);
		sw1.setNumLaps(numLaps);
		if(numCycles > 0){
			sw1.setNumCycles(numCycles);
		}
		return sw1;		
	}

	/**Prompt the user for details
	 * on his or her sleep (does the user want
	 * to log a nap, or overnight sleep?)
	 * @return s1, an object of type Sleep
	 * @see Sleep
	 */
	public Sleep logSleep(boolean isNap, int sleepDuration){		
		Sleep s1 = new Sleep(accountID, sleepDuration, false, isNap);		
		return s1;
	}

}