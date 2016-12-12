package win;
import java.util.*;
/**
 * A child of Trend, used to keep track 
 * of the user's weekly sleep and 
 * exercise trends
 * @author Hector Cervantes
 * @version 1.0 (11/17/2016)
 * @see Trend
 *
 */
public class WeeklyTrend extends Trend{
	private static WeeklyTrend user = new WeeklyTrend(); // initialize one instance
	private DailyTrend[] dailyValues = new DailyTrend[7]; // keeps track of the activity time done in the past seven days
	private ArrayList<WeeklyTrend> weeks = new ArrayList<WeeklyTrend>(); // stores the total activity time of the week in a single ArrayList Index
	int currentDay = 0;
	int currentWEEKindex = 0;// keep track of index of the current week 
	
	private WeeklyTrend(){
		
	}
	
	private WeeklyTrend(int steps, int sleepTime, int workoutTime){
		super(steps, sleepTime, workoutTime);
	}
	
	/**Adds total workout time during a day
	 * @see User#activities
	 * @see Activity
	 */
	public void addWeeklyWorkoutTime(int i){
		if(currentDay >= dailyValues.length){
			addWeekTotal();
			resetDailyValuesArray();
			currentDay = 0;
		}
		dailyValues[currentDay].workoutTime += i;
	}
	/**Adds total sleep time during a day
	 * @see User#activities
	 * @see Activity
	 */
	public void addSleepTime(int i){
		if(currentDay >= dailyValues.length){
			addWeekTotal();
			resetDailyValuesArray();
			currentDay = 0;
		}
		dailyValues[currentDay].sleepTime += i;
	}
	/**Adds total steps during a day
	 * @see User#activities
	 * @see Activity
	 */
	public void addSteps(int i){
		if(currentDay >= dailyValues.length){
			addWeekTotal();
			resetDailyValuesArray();
			currentDay = 0;
		}
		dailyValues[currentDay].steps += i;
	}
	/** resets array that keeps track of the activites lengths during the week;
	 * @see User#activities
	 * @see Activity
	 */
	private void resetDailyValuesArray() {
		for(int i = 0; i < dailyValues.length; i++){
			dailyValues[i] = null;
		}
		
	}
	/** adds the weeks total time of activities and stores it 
	 * in an array list of weeks to view weekly progress
	 * @see User#activities
	 * @see Activity
	 */
	private void addWeekTotal() {
		int workOutSum = 0;
		int sleepSum = 0;
		int stepSum = 0;
		for(int i = 0; i < dailyValues.length;i++){
			workOutSum += dailyValues[i].workoutTime;
			sleepSum += dailyValues[i].sleepTime;
			stepSum += dailyValues[i].steps;
		}
		
		WeeklyTrend temp = new WeeklyTrend(stepSum, sleepSum, workOutSum);
		weeks.add(temp);
		currentWEEKindex++;
		}
	/** returns current day
	 * @return current day
	 * @see Activity
	 */
	public int getCurrentDay(){
		return currentDay;
	}
	
	/** returns steps
	 * @return steps
	 * @see Activity
	 */
	public int getSteps(){
		return steps;
	}
	/** returns Work out time 
	 * @return WorkOut Time
	 * @see Activity
	 */
	public int getWorkOutTime(){
		return workoutTime;
	}
	
	/** returns sleep time 
	 * @return sleep Time
	 * @see Activity
	 */
	public int getSleepTime(){
		return sleepTime;
	}
	/** returns daily 
	 * @return sleep Time
	 * @see Activity
	 */
	public DailyTrend[] getDailyProgress(){
		return dailyValues;
	}
	
	public ArrayList<WeeklyTrend> getWeeklyProgress(){
		return weeks;
	}
	
	public void setCurrentDay(int i){
		currentDay = i;
	}
	
	public void setSteps(int i){
		steps = i;
	}
	
	public void setWorkOutTime(int i){
		workoutTime = i;
	}
	
	public void setSleepTime(int i){
		sleepTime = i;
	}
	
	public static WeeklyTrend getUser(){
		return user;
	}
	public int getCurrentWeek(){
		return currentWEEKindex;
	}
	
}