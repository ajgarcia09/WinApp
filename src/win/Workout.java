package win;
/** A subclass of Activity that allows
 * creation of different kinds of workouts.
 * Classes Run and Swim are children of Workout
 * @author Ana J. Garcia
 * @see Activity
 * @see Run
 * @see Swim
 *
 */
public class Workout extends Activity{	
	
	public Workout(int accountID, int duration, boolean inProgress) {
		super(accountID, duration, inProgress);		
	}
	
	
}	
