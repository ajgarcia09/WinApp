package win;
import java.util.*;
/**
 * A child of Trend, used to keep track 
 * of the user's daily sleep and 
 * exercise trends
 * @author Ana J. Garcia
 * @version 1.0 (11/17/2016)
 * @see Trend
 *
 */

public class DailyTrend extends Trend{
	private boolean isNewDay = true;
	private int date;
	
	public DailyTrend(){
		
	}
	public DailyTrend(int sleepTime, int workoutTime, int numSteps) {
		super(sleepTime, workoutTime,numSteps);
		this.date = date;		
	}
	
	/**
	 * @return isNewDay boolean
	 * that determines whether data for 
	 * a new day will be entered
	 */
	public boolean getIsNewDay(){
		return isNewDay;
	}
	
	/**
	 * 
	 * @return date - an integer that 
	 * holds the day of the month
	 * for which data was saved
	 */
	public int getDate(){
		return date;
	}	
	
	/**
	 * 
	 * @param isNewDay a boolean that determines
	 * whether data for a new day will be entered
	 */
	public void setIsNewDay(boolean isNewDay){
		this.isNewDay = isNewDay;
	}
	
	/**
	 * 
	 * @param date the day of the month
	 * for which the data is being entered
	 */
	public void setDate(int date){
		this.date = date;
	}	

}