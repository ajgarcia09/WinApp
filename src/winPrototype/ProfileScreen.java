package winPrototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import win.User;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileScreen {

	private JFrame profileFrame;
	private static User user = MenuWindow.getUser();
	//private User user = new User(123, "Ana", "female", "ajgarcia09","anita@gmail.com","honeyButterBiscuit",false);
	//private User user2 = new User(123, "Hector", "male", "hcervantes10","hcervantes@gmail.com","rocco",false);
	
	public void setUser(User user){
		this.user = user;
		System.out.println("now in profileScreen setUser" + user.getName());
	}
	/**
	 * Launch the application.
	 */
	public static void displayProfileScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileScreen window = new ProfileScreen();
					window.profileFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public ProfileScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		profileFrame = new JFrame();
		profileFrame.setBounds(100, 100, 295, 475);
		profileFrame.getContentPane().setBackground(SystemColor.textHighlight);
		profileFrame.getContentPane().setLayout(null);
		profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Label myProfileLabel = new Label("My Profile");
		myProfileLabel.setForeground(SystemColor.window);
		myProfileLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		myProfileLabel.setBounds(10, 10, 154, 36);
		profileFrame.getContentPane().add(myProfileLabel);
		
		JLabel pictureLabel = new JLabel("New label");
		pictureLabel.setBounds(21, 70, 93, 125);
		profileFrame.getContentPane().add(pictureLabel); 
				
		/**resize an image to fit JLabel above
		 * for now, it only works with the actual 
		 * path of the picture located on my hard disk
		 * TODO try to have this work via Classpath
		 */
//		String imagePath;
//		if(user.getGender().equals("female")){
//			imagePath = "C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\girlPose.png";
//		}
//		else{
//			imagePath = "C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\guyPose.png";
//		}
		ImageIcon myImage = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\girlPose.png");
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		pictureLabel.setIcon(image);
		
		JLabel usernameLabel = new JLabel(user.getName());
		usernameLabel.setForeground(SystemColor.window);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		usernameLabel.setBounds(124, 70, 145, 109);
		profileFrame.getContentPane().add(usernameLabel);
		
		JLabel membershipLabel = new JLabel("Member since 11/2016");
		membershipLabel.setForeground(Color.WHITE);
		membershipLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		membershipLabel.setBounds(85, 158, 184, 19);
		profileFrame.getContentPane().add(membershipLabel);
		
		JButton trendsButton = new JButton("");
		trendsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrendsWindow trendsWindow = new TrendsWindow();
				trendsWindow.displayTrendsWindow();
				profileFrame.setVisible(false);
			}
		});
		trendsButton.setBounds(156, 234, 70, 66);
		profileFrame.getContentPane().add(trendsButton);
		ImageIcon trendsIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\trendsLogo.png");
		Image trendsImg = trendsIcon.getImage();
		Image resizedtrends = trendsImg.getScaledInstance(trendsButton.getWidth(), trendsButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedtrendsIcon = new ImageIcon(resizedtrends);
		trendsButton.setIcon(resizedtrendsIcon);
		
		JButton goalsButton = new JButton("");
		/**open ViewGoalsWindow
		 * 
		 */
		goalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewGoalsWindow vgWindow = new ViewGoalsWindow();
				vgWindow.displaySetGoalsWindow();
				profileFrame.setVisible(false);
			}
		});
		goalsButton.setBounds(50, 234, 70, 66);
		profileFrame.getContentPane().add(goalsButton);
		ImageIcon goalsIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\goalsLogo.png");
		Image goalsImg = goalsIcon.getImage();
		Image resizedGoals = goalsImg.getScaledInstance(goalsButton.getWidth(), goalsButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedGoalsIcon = new ImageIcon(resizedGoals);
		goalsButton.setIcon(resizedGoalsIcon);
		
		JButton menuButton = new JButton("");
		/**take user back to the menu window
		 * 
		 */
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuWindow menuWindow = new MenuWindow();
				menuWindow.displayMenuWindow();
				profileFrame.setVisible(false);
				
			}
		});
		menuButton.setBounds(231, 10, 38, 36);
		profileFrame.getContentPane().add(menuButton);
		ImageIcon menuIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\menu-icon.png");
		Image menuImg = menuIcon.getImage();
		Image resizedMenu = menuImg.getScaledInstance(menuButton.getWidth(), menuButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedMenuIcon = new ImageIcon(resizedMenu);
		menuButton.setIcon(resizedMenuIcon);
		
		
		JButton workoutsButton = new JButton("");
		workoutsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayWorkoutsWindow workoutWindow = new DisplayWorkoutsWindow();
				workoutWindow.displayWorkoutsWindow();
				profileFrame.setVisible(false);
				
			}
		});
		workoutsButton.setBounds(105, 334, 70, 66);
		profileFrame.getContentPane().add(workoutsButton);
		ImageIcon workoutsIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\weightLogo.png");
		Image workoutsImg = workoutsIcon.getImage();
		Image resizedWorkouts = workoutsImg.getScaledInstance(workoutsButton.getWidth(), workoutsButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedWorkoutsIcon = new ImageIcon(resizedWorkouts);
		workoutsButton.setIcon(resizedWorkoutsIcon);
		
		JLabel goalsLabel = new JLabel("My Goals");
		goalsLabel.setForeground(Color.WHITE);
		goalsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		goalsLabel.setBounds(50, 304, 75, 19);
		profileFrame.getContentPane().add(goalsLabel);
		
		JLabel workoutsLabel = new JLabel("My Workouts");
		workoutsLabel.setForeground(Color.WHITE);
		workoutsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		workoutsLabel.setBounds(85, 406, 113, 19);
		profileFrame.getContentPane().add(workoutsLabel);
		
		JLabel trendsLabel = new JLabel("My Trends");
		trendsLabel.setForeground(Color.WHITE);
		trendsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		trendsLabel.setBounds(156, 304, 93, 19);
		profileFrame.getContentPane().add(trendsLabel);
	
}
}
