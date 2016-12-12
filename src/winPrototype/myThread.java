package winPrototype;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class myThread extends Thread{
	Reminders reminder = new Reminders();
	@Override
	public void run(){
		while(true){
			HashMap<String, String> reminders = reminder.getReminders();
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
			Date dateobj = new Date();
			String date = df.format(dateobj).toString();
			if(reminders.get(date) != null){
				reminder.turnOnNotification(date);
			}
		}
	}
}
