package winPrototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import win.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogSleepWindow {

	private JFrame logSleepFrame;
	private JTextField napField;
	private boolean isNap;
	private JLabel howLongLabel;
	private int sleepHrs;
	private int sleepMins;
	private JLabel hitEnterLabel1;
	private JLabel hitEnterLabel2;
	private JButton btnLogSleep;
	//private User user = new User(123, "Ana","female", "ajgarcia09","anita@gmail.com","honeyButterBiscuit",false);
	private JButton goBackButton;
	private JButton cancelButton;
	private static User user = HomeScreen.getUser();
	private JTextField hourField;
	private JLabel label;
	private JTextField minField;
	private JLabel label_1;


	/**
	 * Launch the application.
	 */
	public static void displaySleepWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogSleepWindow window = new LogSleepWindow();
					window.logSleepFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogSleepWindow() {
		initialize();
	}
	
	public void setUser(User user){
		this.user = user;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logSleepFrame = new JFrame();
		logSleepFrame.setBounds(100, 100, 295, 475);
		logSleepFrame.getContentPane().setBackground(SystemColor.textHighlight);
		logSleepFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel sleepLabel = new JLabel("");
		sleepLabel.setIcon(new ImageIcon(LogSleepWindow.class.getResource("/winPrototype/sleepOption.png")));
		
		JLabel napLabel = new JLabel("Did you take a nap?");
		napLabel.setForeground(Color.WHITE);
		napLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		napField = new JTextField();
		/**gets user input from napField,
		 * & updates field isNap
		 * to be used in creating a Sleep object
		 */
		napField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nField = napField.getText();
				if((nField.equals("yes")|| (nField.equals("Yes"))))
					isNap = true;
				if((nField.equals("no")|| (nField.equals("No"))))
					isNap = false;						
			}
		});
		napField.setColumns(10);
		
		howLongLabel = new JLabel("How long did you sleep?");
		howLongLabel.setForeground(Color.WHITE);
		howLongLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		hitEnterLabel1 = new JLabel("Enter \"Yes\" or \"No\" &  hit Enter");
		hitEnterLabel1.setForeground(Color.WHITE);
		hitEnterLabel1.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		hitEnterLabel2 = new JLabel("Enter a value and hit Enter");
		hitEnterLabel2.setForeground(Color.WHITE);
		hitEnterLabel2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnLogSleep = new JButton("Log Sleep");
		/**Creates a new Sleep object (with isNap and 
		 * sleepDuration fields) when logSleepButton is clicked.
		 * It also opens a new window displaying that a Sleep was
		 * successfully logged
		 * 
		 */
		btnLogSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.logSleep(isNap,(sleepHrs*60)+sleepMins);
				SleepAddedWindow sAddedWdw = new SleepAddedWindow();
				sAddedWdw.displaySleepAddedwindow();
				logSleepFrame.setVisible(false);
			}
		});
		
		goBackButton = new JButton("Go Back");
		/**take user back to LogActivityWindow upon clocking goBackButton
		 * 
		 */
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogActivityWindow logWindow = new LogActivityWindow();
				logWindow.displayLogActivityWindow();
				logSleepFrame.setVisible(false);
			}
		});
		
		cancelButton = new JButton("Cancel");
		/**take user back to homepage
		 * 
		 */
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				logSleepFrame.setVisible(false);
			}
		});
		
		hourField = new JTextField("");
		hourField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hours = hourField.getText();
				sleepHrs = Integer.parseInt(hours);
			}
		});
		hourField.setColumns(10);
		
		label = new JLabel("hr");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		minField = new JTextField("");
		minField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mins = minField.getText();
				sleepMins = Integer.parseInt(mins);
			}
		});
		minField.setColumns(10);
		
		label_1 = new JLabel("min");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GroupLayout groupLayout = new GroupLayout(logSleepFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(sleepLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(napField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(napLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(hitEnterLabel2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(howLongLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addComponent(hitEnterLabel1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(hourField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(minField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addComponent(btnLogSleep, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(goBackButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(goBackButton)
					.addGap(4)
					.addComponent(sleepLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(napLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(napField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(hitEnterLabel1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(howLongLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(hourField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(minField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(hitEnterLabel2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnLogSleep, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cancelButton)
					.addGap(18))
		);
		logSleepFrame.getContentPane().setLayout(groupLayout);
	}

}
