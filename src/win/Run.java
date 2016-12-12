package win;
/**Subclass of Workout, grandchild
 * of Activity. 
 * @author Ana J. Garcia
 * @see Workout
 * @see Activity
 */
public class Run extends Workout{
	
	private int numKm;
	private static int runRecord;
	
	public Run(int accountID,int duration, boolean inProgress, int numKm) {
		super(accountID, duration, inProgress);
		this.numKm = numKm;
	}
/** @return numKm-  The total number of kilometers run
 * 
 */
	public int getNumKm() {
		return numKm;
	}
	
	/** @return runRecord-  The user's record 
	 * number of run kilometers 
	 */
	public int getRunRecord() {
		return runRecord;
	}
	/**
	 * 
	 * @param numKm the total number of kilometers run
	 */

	public void setNumKm(int numKm) {
		this.numKm = numKm;
	}
	
	/**
	 * 
	 * @param runRecord the user's record 
	 * number of run kilometers 
	 */

	public void setRunRecord(int runRecord) {
		this.runRecord = runRecord;
	}

}
