package winPrototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import win.User;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogRunWindow {

	private JFrame logRunFrame;
	private JTextField runDistanceField;
	private int runDistance;
	private int runHrs;
	private int runMins;
	private User user = HomeScreen.getUser();
	private JTextField hourField;
	private JTextField minField;
	//private User user = new User(123, "Ana", "female", "ajgarcia09","anita@gmail.com","honeyButterBiscuit",false);

	/**
	 * Launch the application.
	 */
	public static void displayRunWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogRunWindow window = new LogRunWindow();
					window.logRunFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogRunWindow() {
		initialize();
	}
	
	public void setUser(User user){
		this.user = user;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logRunFrame = new JFrame();
		logRunFrame.setBounds(100, 100, 295, 475);
		logRunFrame.getContentPane().setBackground(SystemColor.textHighlight);
		logRunFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		hourField = new JTextField("");
		hourField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hours = hourField.getText();
				runHrs = Integer.parseInt(hours);
			}
		});
		
		
		
		JLabel label = new JLabel("hr");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel label_1 = new JLabel("min");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		minField = new JTextField("");
		minField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mins = minField.getText();
				runMins = Integer.parseInt(mins);
			}
		});
		
		
		JLabel runLengthLabel = new JLabel("How long was your run?");
		runLengthLabel.setForeground(Color.WHITE);
		runLengthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblHowManyKm = new JLabel("How many km did you run?");
		lblHowManyKm.setForeground(Color.WHITE);
		lblHowManyKm.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton logRunButton = new JButton("Log Run");
		/**Creates a new Run object (with runDistance
		 * and runDuration fields) when logRunButton is clicked.
		 * It also opens a new window displaying that a workout was
		 * successfully logged
		 * 
		 */
		logRunButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.logRun(runDistance, (runHrs*60)+runMins);
				WorkoutAddedWindow wktAdded = new WorkoutAddedWindow();
				wktAdded.displayWorkoutAddedwindow();
				logRunFrame.setVisible(false);
			}
		});
		logRunButton.setBounds(82, 366, 111, 33);
		logRunFrame.getContentPane().add(logRunButton);
		
		runDistanceField = new JTextField();
		/**gets user input from runDistanceField,
		 * parses it into an int, & updates field runDistance
		 * to be used in creating a Run object
		 */
		runDistanceField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rDistance = runDistanceField.getText();
				runDistance = Integer.parseInt(rDistance);
			}
		});
		runDistanceField.setColumns(10);
		
		JLabel runImageLabel = new JLabel("");
		runImageLabel.setIcon(new ImageIcon(LogRunWindow.class.getResource("/winPrototype/runIcon.png")));
		
		JLabel hitEnterLabel = new JLabel("Enter a value and hit Enter");
		hitEnterLabel.setForeground(SystemColor.window);
		hitEnterLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel hitEnterLabel2 = new JLabel("Enter a value and hit Enter");
		hitEnterLabel2.setForeground(Color.WHITE);
		hitEnterLabel2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton goBackButton = new JButton("Go Back");
		/**takes user back to LogWorkoutWindow
		 * 
		 */
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogWorkoutWindow logWorkout = new LogWorkoutWindow();
				logWorkout.displayWorkoutWindow();
				logRunFrame.setVisible(false);
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		/**takes user back to home page
		 * 
		 */
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileScreen ProfileScreen = new ProfileScreen();
				ProfileScreen.displayProfileScreen();
				logRunFrame.setVisible(false);
			}
		});
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(logRunFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(runLengthLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(hitEnterLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(hourField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(runDistanceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHowManyKm, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(hitEnterLabel2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(goBackButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(runImageLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(runImageLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(goBackButton)))
					.addGap(30)
					.addComponent(runLengthLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(hourField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(minField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(hitEnterLabel)
					.addGap(27)
					.addComponent(lblHowManyKm, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(runDistanceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(hitEnterLabel2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
					.addComponent(cancelButton)
					.addContainerGap())
		);
		logRunFrame.getContentPane().setLayout(groupLayout);
	}

}
