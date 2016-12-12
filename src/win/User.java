package win;
import java.util.*;

/**Represents a user of the Activity Tracking System.
 * Each user has various fields and methods for
 * storing and computing sleep and workout data 
 * @author Ana Garcia
 * @author Hector Cervantes
 * @version 1.0 (11/14/2016)
 * @see ActivityLogger
 * @see Trend
 * @see WeeklyTrend
 * @see Reminder
 *
 */

public class User {
	private int accountID;
	private String name;
	private String gender; 
	private int sleepGoal;
	private int swimGoal;
	private int runGoal;
	private int stepGoal;
	/**randomly generate a number between 1000 and 10000
	 * (int)(Math.random()*((max-min)+1)+min)
	 */	
	private static int daySteps = (int)(Math.random()*((10000-1000)+1)+1000);
	private static int daySleep;
	private static int dayWorkout;
	private Reminder reminders;
	private ActivityLogger activityLogger = new ActivityLogger(accountID);
	private HashSet<Activity> activities = new HashSet<Activity>();
	private WeeklyTrend weeklyTrends = WeeklyTrend.getUser();
	Calendar calendar = Calendar.getInstance();
	int day = calendar.get(Calendar.DAY_OF_WEEK);
	int dayCounter = 0;
	public static final String[] daysOfTheWeek = { "Sunday", "Monday" , "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
	/**
	 * 
	 * @param accountID the user's unique ID
	 * @param name the user's name
	 * @param gender the user's gender
	 */
	public User(int accountID, String name, String gender) {
		this.accountID = accountID;
		this.name = name;
		this.gender =gender;
		
	}
	
	/**@return the user's instance of type Reminder
	 * 
	 */
	public Reminder getReminders(){
		return reminders;
	}	

	/**
	 * 
	 * @param daySteps the number of steps taken in the current day
	 */
	public void setDaySteps(int daySteps){
		this.daySteps = daySteps;
	}
	
	/**
	 * 
	 * @param daySleep the length of sleep gained in the current day
	 */
	public void setDaySleep(int daySleep){
		this.daySleep = daySleep;
	}
	
	/**
	 * 
	 * @param dayWorkout the total workout time done in the current day
	 */
	public void setDayWorkout(int dayWorkout){
		this.dayWorkout = dayWorkout;
	}
	/**
	 * 
	 * @return the number of steps taken in the current day
	 */
	public int getDaySteps(){
		return daySteps;
	}
	
	/**
	 * 
	 * @return the amount of sleep obtained in the current day
	 */
	public int getDaySleep(){
		return daySleep;
	}
	
	/**
	 * 
	 * @return the amount of workout time obtained in the current day
	 */
	public int getDayWorkout(){
		return dayWorkout;
	}
	/**
	 * 
	 * @return the user's instance of type WeeklyTrend
	 */
	public WeeklyTrend getWeeklyTrends(){
		return weeklyTrends;
	}
	
	/**
	 * 
	 * @param sleepGoal the total sleep the user
	 * wishes to have in a day
	 */
	public void setSleepGoal(int sleepGoal){
		this.sleepGoal = sleepGoal;
	}
	
	/**
	 * 
	 * @param swimGoal the number of laps 
	 * the user wishes to complete in a day
	 */
	public void setSwimGoal(int swimGoal){
		this.swimGoal = swimGoal;
	}
	/**
	 * 
	 * @param runGoal the number of km the 
	 * user wishes to run in a day
	 */
	public void setRunGoal(int runGoal){
		this.runGoal = runGoal;
	}
	
	/**
	 * 
	 * @param stepGoal the number of steps 
	 * the user wishes to take during a day
	 */
	public void setStepGoal(int stepGoal){
		this.stepGoal = stepGoal;
	}
	
	/**
	 * 
	 * @return the user's sleep goal
	 */
	public int getSleepGoal(){
		return sleepGoal;
	}
	/**
	 * 
	 * @return the user's swim (laps) goal
	 */
	public int getSwimGoal(){
		return swimGoal;
	}
	/**
	 * 
	 * @return the user's run (km) goal
	 */
	public int getRunGoal(){
		return runGoal;
	}
	/**
	 * 
	 * @return the user's step goal
	 */
	public int getStepGoal(){
		return stepGoal;
	}	
/**
 * @return name the user's name
 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return the user's gender
	 */
	public String getGender(){
		return gender;
	}		
	
/**
 * 
 * @param name the user's name
 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param gender the user's gender
	 */
	public void setGender(String gender){
		this.gender = gender;
	}


	/**Adds an activity to the user's set of activities
	 * 
	 * @param a1 an object of type Activity
	 * @see User#activities 
	 */
	public void addActivity(Activity a1){
		activities.add(a1);
	}
	
	/**Print the user's logged activities
	 * by traversing its HashSet of type Activity
	 * @see User#activities
	 */
	public void printActivities(){
		System.out.println("User's logged activites: ");
		for(Iterator it = activities.iterator(); it.hasNext();){
			Activity activity = (Activity)it.next();
			activity.printActivityType(activity);
			//for debugging using the frames
			System.out.println(activity.getDuration());
			
		}
	}	

	/**Adds the user's total sleep time within
	 * a given time frame by traversing the user's 
	 * set of Activities.
	 * @return daySleep the total amount of sleep the user had in a day
	 * @see User#activities
	 * @see Activity
	 */
	public int countDaySleepTime() {
		int daySleep =0;		
		if(day != calendar.get(Calendar.DAY_OF_WEEK)){
			day =  calendar.get(Calendar.DAY_OF_WEEK);
			activities.clear();
			weeklyTrends.setCurrentDay(weeklyTrends.getCurrentDay() + 1);
			dayCounter++;
		}
		for(Iterator it = activities.iterator(); it.hasNext();){
			Activity currentActivity = (Activity)it.next();
			System.out.println(currentActivity.getClass().getTypeName());
			if(currentActivity.getClass().getTypeName().equals("Sleep"))
				daySleep += currentActivity.getDuration();	
			    }
		weeklyTrends.addSleepTime(daySleep);
		return daySleep;
	}
	
	/**Adds the user's total workout time within
	 * a given time frame by traversing the user's 
	 * set of Activities.
	 * @return dayWorkout the total amount of sleep the user had in a day
	 * @see User#activities
	 * @see Activity
	 */
	public int countDayWorkoutTime() {
		int dayWorkout =0;

		if(day != calendar.get(Calendar.DAY_OF_WEEK)){
			day = calendar.get(Calendar.DAY_OF_WEEK);
			activities.clear();
			weeklyTrends.setCurrentDay(weeklyTrends.getCurrentDay() + 1);
			dayCounter++;
		}
		for(Iterator it = activities.iterator(); it.hasNext();){
			Activity currentActivity = (Activity)it.next();
			currentActivity.printActivityType(currentActivity);
			if(currentActivity.getClass().getSuperclass().getTypeName().equals("Workout")){
				dayWorkout += currentActivity.getDuration();

			}
		}
		weeklyTrends.addWeeklyWorkoutTime(dayWorkout);
		return dayWorkout;
	}
	
	/**Adds randomly generated steps
	 * @return steps the total amount of steps the user had in a day
	 * @see User#activities
	 * @see Activity
	 */
	public int countDaySteps(){
		if(day != calendar.get(Calendar.DAY_OF_WEEK)){
			day = calendar.get(Calendar.DAY_OF_WEEK);
			activities.clear();
			weeklyTrends.setCurrentDay(weeklyTrends.getCurrentDay() + 1);
			dayCounter++;
		}
		Random generator = new Random();
		int steps= generator.nextInt();
		weeklyTrends.addSteps(steps);
		return steps;
	}
	
	/**
	 * 
	 * @param runDistance the total distance the user ran
	 * @param runDuration the total time the user spent running
	 */
	public void logRun(int runDistance, int runDuration) {
		Activity a1 = this.activityLogger.logRun(runDistance, runDuration);
		addActivity(a1);
		dayWorkout+= a1.getDuration();
		
	}

	/**
	 * 
	 * @param swimDuration the total time the user swam
	 * @param numLaps the number of laps the user swam
	 * @param numCycles the number of cycles the user swam
	 */
	public void logSwim(int swimDuration, int numLaps, int numCycles) {
		Activity a1 = this.activityLogger.logSwim(swimDuration, numLaps, numCycles);
		addActivity(a1);
		dayWorkout+=a1.getDuration();
		
	}

	/**
	 * 
	 * @param isNap whether the sleep that's being logged is a nap
	 * @param sleepDuration the total time the user spent sleeping
	 */
	public void logSleep(boolean isNap, int sleepDuration) {
		Activity a1 = this.activityLogger.logSleep(isNap, sleepDuration);
		addActivity(a1);
		daySleep+=a1.getDuration();
	}
	
	/**
	 *  Used to traverse and print the amount of activities done during the week 
	 */
	public void printWeekProgress(){
		DailyTrend[] week = weeklyTrends.getDailyProgress();
		for(int i = 0; i < week.length; i++){
			System.out.println("The amount of sleep on " + daysOfTheWeek[i] +" was: " + week[i].sleepTime + " Min");
			System.out.println("The amount of workout time on" + daysOfTheWeek[i] +" is: " + week[i].workoutTime + " Min");
			System.out.println("The amount of steps on" + daysOfTheWeek[i] +" is: " + week[i].steps + " Min");
		}
	}
	
	/** Used to traverse the array list of weeks to compare week progress
	 * 
	 */
	public void printWeeklyProgress(){
		ArrayList<WeeklyTrend> weeks = weeklyTrends.getWeeklyProgress();
		int i = weeklyTrends.getCurrentWeek();
		int counter = 5;
		for(; counter >= 0; i--){
			System.out.println("The amount of sleep on week"+ i +" was: " + weeks.get(i).sleepTime + " Min");
			System.out.println("The amount of workout time on week" + i +" is: " + weeks.get(i).workoutTime + " Min");
			System.out.println("The amount of steps on week" + i +" is: " + weeks.get(i).steps + " Min");
			counter --;
		}
	}

}