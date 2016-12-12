package win;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
/** A Reminder class used to alert user of
 * predefined reminders
 * 
 * @author Hector Cervantes
 *  @version 1.0 (11/10/16)
 *  @since version 1.0
 */

public class Reminder{
	/** reminders- stores reminders in a global hashmap.
	 * userSeeting- gets predefined user settings
	 * buzzer- sets off alarm
	 */

	static HashMap<String, String> reminders = new HashMap<>();
	static Setting userSetting = new Setting();
	static boolean buzzer = false;

	/** 
	 * Adds new reminders and reminder times to a Hashmap of reminders
	 * with the times as keys.
	 * @param String for reminder message, String for reminder time, boolean to see if called by test;
	 *  @return true for testing purposes
	 * */
	public static void setReminder(String reminderTime, String reminder){
				
		reminders.put(reminderTime, reminder);

	}

	/** compares current time with stored reminder times 
	 * to whether or not alert the user.
	 * @param time to compare to saved reminder times
	 * @return true if reminder and time exist in the HashMap
	 * */ 
	public static boolean setAlarm(String time){

		if(reminders.get(time) != null){
			if(userSetting.getBandStatus()){
				turnOnBuzzer();
			}
			System.out.println(reminders.get(time));
			return true;
		}
		else{ 
			return false;
		}
	}

	/** turns on the alarm
	 * */
	private static void turnOnBuzzer() {
		buzzer = true;

	}

	/** Gets current time and date and sends
	 * the information to check for any existing 
	 * reminders.
	 * @return for testing purposes
	 * */
	public boolean checkReminders(){
		boolean executed = false;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		String currentDate = df.format(calobj.getTime()).toString().replaceAll("\\s+","");
		setAlarm(currentDate);
		executed = true;
		return executed;
	}
}
