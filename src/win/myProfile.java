package win;

public class myProfile {

	protected String Name;
	protected String LastName;
	protected String Username;
	protected String Password;
	protected int Age;
	protected double Weight;
	protected double Height;
    
    public myProfile (String Name, String LastName, String Username, String Password, int Age, double Weight, double Height ){
    	this.Name = Name;
    	this.LastName = LastName;
    	this.Password = Password;
    	this.Age = Age;
    	this.Weight = Weight;
    	this.Height = Height;
    }
    /* Constructor
     * @Param Weight, Height
     *  */
    public double getBMI (double Weight, double Height){
    	double BMI;
    	Weight = Weight * 0.45;
    	Height = Height * 0.025;
    	BMI = Height * Height;
    	BMI = Weight / BMI;
    	
    	return BMI;
    }

    /* returns Weight */
    public double getWeight(){
    	return Weight;
    }
    /* returns Height */
    public double getHeight(){
    	return Height;
    }
    /* returns Username */
    public String getUsername(){
    	return Username;
    }
    /* returns Password */
    public String getPassword(){
    	return Password;
    }
    /* returns Name */
    public String getName(){
    	return Name;
    }
    /* returns Last Name */
    public String getLastName(){
    	return LastName;
    }
    /* returns Age */
    public int getAge(){
    	return Age;
    }
    /* Change Password */
    public void setPassword(String newPassword){
    	this.Password = newPassword;
    }
    /* Change Username */
    public void setUsername(String newUsername){
    	this.Password = newUsername;
    }
}
