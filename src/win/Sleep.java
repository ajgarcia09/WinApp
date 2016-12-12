package win;
/** A subclass of Activity that creates 
 * objects of type Sleep, which include
 * sleep duration and a nap-setting option.
 *
 * @author Ana J. Garcia
 * @version 1.0 (11/14/2016)
 * @see Activity
 *
 */
public class Sleep extends Activity{
	
	private int alarm;
	private boolean isNap;
	
	public Sleep(int accountID, int duration, boolean inProgress, boolean isNap) {
		super(accountID, duration, inProgress);
		this.isNap = isNap;
	}

	/**
	 * 
	 * @return alarm - the time for which
	 * an alarm is set
	 */
	public int getalarm() {
		return alarm;
	}
/**
 * 
 * @return isNap - whether the logged
 * sleep is a nap or overnight sleep
 */
	public boolean isNap() {
		return isNap;
	}

	/**
	 * 
	 * @param alarm the time for which
	 * a given alarm is set
	 */
	public void setalarm(int alarm) {
		this.alarm = alarm;
	}
/**
 * 
 * @param isNap whether the logged sleep
 * is a nap or overnight sleep
 */
	public void setNap(boolean isNap) {
		this.isNap = isNap;
	}
}
