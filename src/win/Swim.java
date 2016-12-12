package win;
/**Subclass of Workout, grandchild
 * of Activity. Creates workouts of 
 * type Swim, which include number
 * of laps, and swimming style.
 *  
 * @author Ana J. Garcia
 * @see Workout
 * @see Activity
 */
public class Swim extends Workout{
	private int numCycles;
	private int numStyles;
	private int numLaps;
	private boolean freeStyle;
	private boolean butterfly;
	private boolean backStroke;
	private boolean breastStroke;

	public Swim(int accountID, int duration, boolean inProgress) {
		super(accountID, duration, inProgress);
	}	

	/**
	 * 
	 * @return numCycles - the number of
	 * cycles swum
	 */
	public int getNumCycles() {
		return numCycles;
	}
	/**
	 * 
	 * @return numStyles - the number of styles
	 * the user swam
	 */
	public int getNumStyles() {
		return numStyles;
	}
	/**
	 * 
	 * @return numLaps - the number of laps the user swam
	 */
	public int getNumLaps() {
		return numLaps;
	}
	/**
	 * 
	 * @return freeStyle - whether
	 * the user swam freestyle
	 */
	public boolean getFreeStyle() {
		return freeStyle;
	}
	/**
	 * 
	 * @return butterfly - whether the user
	 * swam butterfly style
	 */
	public boolean getButterfly() {
		return butterfly;
	}
	/**
	 * 
	 * @return backStroke - whether the user
	 * swam back stroke style
	 */
	public boolean getBackStroke() {
		return backStroke;
	}
	/**
	 * 
	 * @return breastStroke - whether
	 * the user swam breastStroke
	 */
	public boolean getBreastStroke() {
		return breastStroke;
	}
	/**
	 * 
	 * @param numCycles the number of cycles swum
	 */
	public void setNumCycles(int numCycles) {
		this.numCycles = numCycles;
	}
	/**
	 * 
	 * @param numStyles the number of styles swum
	 */
	public void setNumStyles(int numStyles) {
		this.numStyles = numStyles;
	}
	/**
	 * 
	 * @param freeStyle whether the user swam in freestyle
	 * 
	 */
	public void setFreeStyle(boolean freeStyle) {
		this.freeStyle = freeStyle;
	}

	/**
	 * 
	 * @param butterfly whether the user swam in butterfly
	 */
	public void setButterfly(boolean butterfly) {
		this.butterfly = butterfly;
	}
	/**
	 * 
	 * @param backStroke whether the user swam in backstroke
	 */
	public void setBackStroke(boolean backStroke) {
		this.backStroke = backStroke;
	}
	/**
	 * 
	 * @param breastStroke whether the user swam in breaststroke
	 */
	public void setBreastStroke(boolean breastStroke) {
		this.breastStroke = breastStroke;
	}

	/**
	 * 
	 * @param numLaps the number of laps the user swam
	 */
	public void setNumLaps(int numLaps) {
		this.numLaps = numLaps;
	}

}
