package win;
import java.util.*;
/** public Class that manages the Goals of the user*/
public class Goals extends Profile{
	
	/**
	 *  Compares the exercise with the current goal of the user
	 */
	protected static void printNumKm() {
		System.out.println("Congratulations!");
		System.out.println("You run " + numKm);
		
		int diff = numKmGoal - numKm;
		
		if(diff >=0 ){
			System.out.println("You were " + diff + " Km short of your goal!");
			System.out.println("Keep it up!!!");
		}
		
		else if(diff ==0){
			System.out.println("You reach your goal!");
			System.out.println("Congratulations!");
		}
		else if(diff <0){
			System.out.println("Congratulations! you set a new record!");
			runRecord = numKm;
		}
		
	}

	/**
	 * 
	 * @return boolean variable for determing if the operation was succesfull
	 */
	static boolean getRandomData() {
		
		numCycles = 1 + (int)(Math.random() * ((10 - 1) + 1));
		
		for(int i = 0; i < swim_Style_Goal.length; i++)
			swimStyle[i] = 0 + (int)(Math.random() * ((7 - 0) + 0));
		
		numKm = 1 + (int)(Math.random() * ((100 - 1) + 1));
		
		if(numCycles >= 0 && numKm >= 0){
			return true;
		}
		return false;
	}

	protected static void printCycleFalse() {
		for(int i = 0; i < swimStyle.length; i++){
			if(i < numStyles){
				System.out.print("For Style number: "+(i+1) );
				System.out.println(" You did: " + swimStyle[i] + " Laps");
			}
		}
	}

	protected static void printCycleTrue() {
		System.out.println("Congratulations!");
		System.out.println("You did " + numCycles + " number of Cycles!");
		
		int diff = num_Goal_Cycles - numCycles;
		
		if(diff >=0 ){
			System.out.println("You were " + diff + " Km short of your goal!");
			System.out.println("Keep it up!!!");
		}
		
		else if(diff ==0){
			System.out.println("You reach your goal!");
			System.out.println("Congratulations!");
		}
		else if(diff <0){
			System.out.println("Congratulations! you set a new record!");
			swimRecord = numCycles;
		}
	}
	/**
	 * @see selectWorkoutType
	 * @return true if correct implementation of method
	 */
	protected static boolean askWorkoutType() {
		if(workoutType == 'S' || workoutType == 's'){
			swimFlag = true;
			swimWorkout();
			return true;
		}
		
		else if(workoutType == 'R' || workoutType == 'r'){
			runWorkout();
			return true;
		}
		return false;
		
	}

	private static void runWorkout() {
		System.out.println("How many Kilometers will you run?");
		int runKm = scan.nextInt();
		numKmGoal = runKm;
		
	}

	/**
	 * Ask the user if he will be swimming in cycles
	 */
	private static void swimWorkout() {
	//	Scanner scan = new Scanner (System.in);
		
		System.out.println("Will you be swimming cycles? ");
		char isCycles = scan.next().charAt(0);
		System.out.println("");
		if(isCycles == 'N' || isCycles == 'n'){
			isCycle = false;
			noCycle();
		}
		if(isCycles == 'Y' || isCycles == 'y'){
			isCycle = true;
			yesCycle();
		}
		//scan.close();
	}
	
	/**
	 * @see swimWorkout
	 */
	private static void yesCycle() {
		System.out.println("A cycle is back, breast, free, fly");
		System.out.println("How many Cycles will you swim?");
		int numLaps = scan.nextInt();
		num_Goal_Cycles = numLaps;
	}
	
	/**
	 * @see swimWorkout
	 */
	private static void noCycle(){
		System.out.println("How many styles of Swimming will you be swimming? ");
		 numStyles = scan.nextInt();
		System.out.println("");
		System.out.println("Which Styles will you be swimming?");
		System.out.println("1)  FreeStyle");
		System.out.println("2)  Back Stroke");
		System.out.println("3)  Breast Stroke");
		System.out.println("4)  Butterfly Stroke");
		
		for(int i = 0; i < numStyles; i++){
			System.out.println("Which would be your "+(i+1)+" style?");
			int SS = scan.nextInt();
			System.out.println("Enter the number of laps you wish to do: ");
			int lapGoal = scan.nextInt();
			swim_Style_Goal[SS] = lapGoal;
		}
	}
	
	/**
	 * Ask the user what type of workout will he be doing
	 * @return true if the operation was succesfull
	 */
	protected static boolean selectWorkoutType() {		
		System.out.println("Select Workout Type:");
		System.out.println("");
		System.out.println("| R)   Running |");
		System.out.println("| S)   Swimming|");
		workoutType = scan.next().charAt(0);
		if(workoutType == 'R' || workoutType == 'S'){
			return true;
		}
		return false;
	}
	
	/* view your current Goals */
	protected static void viewGoals(){
		System.out.println("Your swimming goal is: ");
		System.out.println(num_Goal_Cycles + " cycles & the following Styes: ");
		for(int i = 0; i < 5; i++){
			if(swim_Style_Goal[i] == 1)
				System.out.println("Free Style");
			if(swim_Style_Goal[i] == 2)
				System.out.println("Back Stroke");
			if(swim_Style_Goal[i] == 3)
				System.out.println("Breast Stroke");
			if(swim_Style_Goal[i] == 4)
				System.out.println("Butterfly Stoke");
		}
		System.out.println("Your Running goal is: ");
		System.out.println(numKmGoal + "Kilometers");
		
	}
	/* Set new Goals or Updating old ones */
	protected static void setNewGoals() {
		getRandomData();
		//Is the goal 
		selectWorkoutType();
		askWorkoutType();
		if(swimFlag == true){
			if(isCycle == false)
				printCycleFalse();
			else
				printCycleTrue();
		}
		else
			printNumKm();
	}
	
	/**
	 * Recomends the user a company made workout
	 */
	protected static void premadeWorkout(){
		
		System.out.println("We recomend this workout for you:");
		System.out.println(" 200 laps of swimming & 5km Running");
	}
}
