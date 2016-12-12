package win;
/**Stores Activity Tracking System users' data
 * (such as sleep and exercise) in daily, 
 * weekly, and monthly views. 
 * @author Ana J. Garcia
 * @version 1.0 (11/14/2016)
 * @see DailyTrend
 * @see WeeklyTrend
 * @see MonthlyTrend
 *
 */
public class Trend {
	protected int sleepTime;
	protected int workoutTime;
	protected int steps;
	
	Trend(){
		
	}
	public Trend(int sleepTime, int workoutTime,  int steps) {
		this.sleepTime = sleepTime;
		this.workoutTime = workoutTime;
		this.steps = steps;
	}


	/**
	 * 
	 * @return sleepTime - the user's total sleep time 
	 */
	public int getSleepTime() {
		return sleepTime;
	}

	/** 
	 * 
	 * @return workoutTime - the user's total workout time
	 */
	public int getWorkoutTime(){
		return workoutTime;
	}

	public int getNumSteps(){
		return steps;
	}
	


	/**
	 * 
	 * @param sleepTime - the user's total 
	 * sleep time
	 */
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}

/**
 * 	
 * @param workoutTime the user's total 
 * workout time
 */
	public void setWorkoutTime(int workoutTime) {
		this.workoutTime = workoutTime;
	}


}