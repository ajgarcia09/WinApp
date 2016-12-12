package winPrototype;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;

import win.User;

import java.awt.Font;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewGoalsWindow {
	

	private JFrame goalsFrame;
	private User user = HomeScreen.getUser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		displaySetGoalsWindow();
		
	}

	/**
	 * Create the application.
	 */
	public ViewGoalsWindow() {
		initialize();
	}
	
	public static void displaySetGoalsWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGoalsWindow window = new ViewGoalsWindow();
					window.goalsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//User user = new User(123, "Ana", "female", "ajgarcia09","anita@gmail.com","honeyButterBiscuit",false);
//		user.setStepGoal(1123);
//		user.setSleepGoal(8);//hours
//		user.setSwimGoal(10); //number of laps
//		user.setRunGoal(5);//km
		
		goalsFrame = new JFrame();
		goalsFrame.setBounds(100, 100, 295, 475);
		goalsFrame.getContentPane().setBackground(SystemColor.textHighlight);
		goalsFrame.getContentPane().setLayout(null);
		
		JLabel stepCountLabel = new JLabel();
		stepCountLabel.setText(Integer.toString(user.getStepGoal()));
		stepCountLabel.setForeground(Color.WHITE);
		stepCountLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		stepCountLabel.setBounds(65, 40, 145, 67);
		goalsFrame.getContentPane().add(stepCountLabel);
		
		Label myGoalsLabel = new Label(user.getName() + "'s Goals");
		myGoalsLabel.setForeground(Color.WHITE);
		myGoalsLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		myGoalsLabel.setBounds(10, 10, 154, 36);
		goalsFrame.getContentPane().add(myGoalsLabel);
		
		Label stepsLabel = new Label("Daily Steps");
		stepsLabel.setForeground(Color.WHITE);
		stepsLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		stepsLabel.setBounds(75, 113, 129, 36);
		goalsFrame.getContentPane().add(stepsLabel);
		
		JLabel sleephours = new JLabel(Integer.toString(user.getSleepGoal()/60));
		sleephours.setForeground(Color.WHITE);
		sleephours.setFont(new Font("Tahoma", Font.BOLD, 35));
		sleephours.setBounds(36, 155, 35, 67);
		goalsFrame.getContentPane().add(sleephours);
		
		Label label = new Label("Sleep per night");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(58, 209, 168, 36);
		goalsFrame.getContentPane().add(label);
		
		JLabel runTime = new JLabel(Integer.toString(user.getRunGoal()));
		runTime.setForeground(Color.WHITE);
		runTime.setFont(new Font("Tahoma", Font.BOLD, 40));
		runTime.setBounds(36, 273, 109, 67);
		goalsFrame.getContentPane().add(runTime);
		
		Label runLabel = new Label("Run km");
		runLabel.setForeground(Color.WHITE);
		runLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		runLabel.setBounds(10, 346, 129, 36);
		goalsFrame.getContentPane().add(runLabel);
		
		JButton btnBackToProfile = new JButton("Back to Profile");
		/**display profile screen window
		 * 
		 */
		btnBackToProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ProfileScreen profileScreen = new ProfileScreen();
			profileScreen.displayProfileScreen();
			goalsFrame.setVisible(false);
			}
		});
		btnBackToProfile.setBounds(134, 402, 135, 23);
		goalsFrame.getContentPane().add(btnBackToProfile);
		
		JLabel lblH = new JLabel("h");
		lblH.setForeground(Color.WHITE);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblH.setBounds(85, 155, 35, 67);
		goalsFrame.getContentPane().add(lblH);
		
		Label swimTimeLabel = new Label("Swim Laps");
		swimTimeLabel.setForeground(Color.WHITE);
		swimTimeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		swimTimeLabel.setBounds(145, 346, 129, 36);
		goalsFrame.getContentPane().add(swimTimeLabel);
		
		JLabel swimTime = new JLabel(Integer.toString(user.getSwimGoal()));
		swimTime.setForeground(Color.WHITE);
		swimTime.setFont(new Font("Tahoma", Font.BOLD, 40));
		swimTime.setBounds(160, 273, 109, 67);
		goalsFrame.getContentPane().add(swimTime);
		
		JLabel mLabel = new JLabel("m");
		mLabel.setForeground(Color.WHITE);
		mLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		mLabel.setBounds(179, 155, 43, 67);
		goalsFrame.getContentPane().add(mLabel);
		
		JLabel sleepMinLabel = new JLabel();
		sleepMinLabel.setText(Integer.toString(user.getSleepGoal()%60));
		sleepMinLabel.setForeground(Color.WHITE);
		sleepMinLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		sleepMinLabel.setBounds(142, 155, 49, 67);
		goalsFrame.getContentPane().add(sleepMinLabel);
		goalsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
