package winPrototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import win.*;

public class LogWorkoutWindow {
	private JFrame logWorkoutFrame;
	private static User user = HomeScreen.getUser();

	/**
	 * Launch the application.
	 */
	public static void displayWorkoutWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogWorkoutWindow window = new LogWorkoutWindow();
					window.logWorkoutFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogWorkoutWindow() {
		initialize();
	}
	
	public void setUser(User user){
		this.user = user;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logWorkoutFrame = new JFrame();
		logWorkoutFrame.setBounds(100, 100, 295, 475);
		logWorkoutFrame.getContentPane().setBackground(SystemColor.textHighlight);
		logWorkoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton swimButton = new JButton("");
		/**display LogSwimWindow if swimButton is clicked
		 * 
		 */
		swimButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogSwimWindow swimWindow = new LogSwimWindow();
				swimWindow.displaySwimWindow();
				logWorkoutFrame.setVisible(false);
			}
		});
		swimButton.setIcon(new ImageIcon(LogWorkoutWindow.class.getResource("/winPrototype/swimIcon.png")));
		
		JButton runButton = new JButton("");
		/**display LogSwimWindow if swimButton is clicked
		 * 
		 */
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogRunWindow runWindow = new LogRunWindow();
				runWindow.displayRunWindow();
				runWindow.setUser(user);
				logWorkoutFrame.setVisible(false);
			}
		});
		runButton.setIcon(new ImageIcon(LogWorkoutWindow.class.getResource("/winPrototype/workoutOption.png")));
		
		JLabel kindWorkoutLabel = new JLabel("What kind of workout did you do?");
		kindWorkoutLabel.setForeground(SystemColor.window);
		kindWorkoutLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		kindWorkoutLabel.setBounds(29, 70, 135, 75);
		logWorkoutFrame.getContentPane().add(kindWorkoutLabel);
		
		JLabel lblSwim = new JLabel("Swim");
		lblSwim.setForeground(SystemColor.window);
		lblSwim.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRun = new JLabel("Run");
		lblRun.setForeground(SystemColor.window);
		lblRun.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton GoBackButton = new JButton("Go Back");
		/**takes user back to the LogActivity window
		 * 
		 */
		GoBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogActivityWindow logWindow = new LogActivityWindow();
				logWindow.displayLogActivityWindow();
				logWorkoutFrame.setVisible(false);
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		/**takes user back to the home page
		 * 
		 */
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				logWorkoutFrame.setVisible(false);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(logWorkoutFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(swimButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(runButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(lblSwim)
							.addGap(74)
							.addComponent(lblRun)))
					.addContainerGap(54, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(kindWorkoutLabel, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(GoBackButton)
					.addContainerGap(198, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(GoBackButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(kindWorkoutLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(swimButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(runButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSwim)
						.addComponent(lblRun))
					.addGap(180)
					.addComponent(cancelButton)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		logWorkoutFrame.getContentPane().setLayout(groupLayout);
	}

}
