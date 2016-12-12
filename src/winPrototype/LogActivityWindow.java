package winPrototype;
import win.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogActivityWindow {

	private JFrame logActivityFrame;
	private User user = HomeScreen.getUser();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		displayLogActivityWindow();
//	}

	public static void displayLogActivityWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogActivityWindow window = new LogActivityWindow();
					window.logActivityFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setUser(User user){
		this.user = user;
	}
	/**
	 * Create the application.
	 */
	public LogActivityWindow() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logActivityFrame = new JFrame();
		logActivityFrame.setBounds(100, 100, 295, 475);
		logActivityFrame.getContentPane().setBackground(SystemColor.textHighlight);
		
		
		JButton sleepButton = new JButton("");
		/**call LogSleepWindow if sleepButton is clicked
		 * 
		 */
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogSleepWindow sleepWindow = new LogSleepWindow();
				sleepWindow.displaySleepWindow();
				//sleepWindow.setUser(user);
				logActivityFrame.setVisible(false);
			}
		});
		sleepButton.setIcon(new ImageIcon(LogActivityWindow.class.getResource("/winPrototype/sleepOption.png")));
		
		JLabel logActivityLabel = new JLabel("");
		
		JButton workoutButton = new JButton("");
		/**call LogWorkoutWindow if workoutButton is clicked
		 * 
		 */
		workoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogWorkoutWindow wktWindow = new LogWorkoutWindow();
				wktWindow.displayWorkoutWindow();
				wktWindow.setUser(user);
				logActivityFrame.setVisible(false);
			}
		});
		workoutButton.setIcon(new ImageIcon(LogActivityWindow.class.getResource("/winPrototype/workoutOption.png")));
		
		JLabel workoutLabel = new JLabel("Workout");
		workoutLabel.setForeground(SystemColor.window);
		workoutLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel sleepLabel = new JLabel("Sleep");
		sleepLabel.setForeground(SystemColor.window);
		sleepLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel logPromptLabel = new JLabel("What would you like to log?");
		logPromptLabel.setForeground(SystemColor.window);
		logPromptLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		logPromptLabel.setBounds(29, 70, 135, 75);
		logActivityFrame.getContentPane().add(logPromptLabel);
		
		JButton cancelButton = new JButton("Cancel");
		/**take user back to homepage
		 * 
		 */
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				logActivityFrame.setVisible(false);			}
		});
		
		GroupLayout groupLayout = new GroupLayout(logActivityFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(logActivityLabel)
					.addContainerGap(258, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(logPromptLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(workoutButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(sleepButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addGap(48))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(workoutLabel)
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(sleepLabel))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(logActivityLabel)
					.addGap(69)
					.addComponent(logPromptLabel)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(workoutButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(sleepButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(workoutLabel)
						.addComponent(sleepLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
					.addComponent(cancelButton)
					.addGap(22))
		);
		logActivityFrame.getContentPane().setLayout(groupLayout);
		logActivityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
