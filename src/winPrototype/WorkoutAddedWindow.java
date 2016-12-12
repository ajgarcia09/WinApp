package winPrototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkoutAddedWindow {

	private JFrame workoutAddedFrame;

	/**
	 * Launch the application.
	 */
	public static void displayWorkoutAddedwindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkoutAddedWindow window = new WorkoutAddedWindow();
					window.workoutAddedFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorkoutAddedWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		workoutAddedFrame = new JFrame();
		workoutAddedFrame.getContentPane().setBackground(SystemColor.textHighlight);
		
		JLabel wktAddedLabel = new JLabel("Workout Added!");
		wktAddedLabel.setForeground(SystemColor.window);
		wktAddedLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton backHomeButton = new JButton("Back to Home");
		/**takes user back to the homepage
		 * 
		 */
		backHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				workoutAddedFrame.setVisible(false);
			}
		});
		
		JButton addActivityButton = new JButton("Add Another Activity");
		/**takes user back to LogActivityWindow
		 * 
		 */
		addActivityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogActivityWindow logAct = new LogActivityWindow();
				logAct.displayLogActivityWindow();
				workoutAddedFrame.setVisible(false);
			}
		});
		
		JLabel checkMarkLabel = new JLabel("");
		checkMarkLabel.setBounds(21, 70, 150, 150);
		ImageIcon myImage = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\checkMark_smaller.png");
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(checkMarkLabel.getWidth(), checkMarkLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		checkMarkLabel.setIcon(image);
		
		
		GroupLayout groupLayout = new GroupLayout(workoutAddedFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(checkMarkLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(wktAddedLabel)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(addActivityButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(backHomeButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(checkMarkLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(wktAddedLabel)
					.addGap(52)
					.addComponent(backHomeButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(addActivityButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		workoutAddedFrame.getContentPane().setLayout(groupLayout);
		workoutAddedFrame.setBounds(100, 100, 295, 475);
		workoutAddedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
