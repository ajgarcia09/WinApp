package winPrototype;

import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JFrame;
import win.*;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayWorkoutsWindow {

	private JFrame showWktFrame;
	private User user = HomeScreen.getUser();

	/**
	 * Launch the application.
	 */
	public static void displayWorkoutsWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayWorkoutsWindow window = new DisplayWorkoutsWindow();
					window.showWktFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayWorkoutsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		showWktFrame = new JFrame();
		showWktFrame.setBounds(100, 100, 295, 475);
		showWktFrame.getContentPane().setBackground(SystemColor.textHighlight);
		showWktFrame.getContentPane().setLayout(null);
		
		Label minWorkout = new Label("10 Minute Workout");
		minWorkout.setForeground(Color.WHITE);
		minWorkout.setFont(new Font("Tahoma", Font.BOLD, 20));
		minWorkout.setBounds(10, 21, 206, 36);
		showWktFrame.getContentPane().add(minWorkout);
		
		Label enduranceLabel = new Label("Endurance Training");
		enduranceLabel.setForeground(Color.WHITE);
		enduranceLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		enduranceLabel.setBounds(10, 211, 206, 36);
		showWktFrame.getContentPane().add(enduranceLabel);
		
		JLabel plankLabel = new JLabel("1 minute elbow plank");
		plankLabel.setForeground(Color.WHITE);
		plankLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		plankLabel.setBounds(41, 63, 133, 13);
		showWktFrame.getContentPane().add(plankLabel);
		
		JLabel leftPlankLbl = new JLabel("1 minute left arm plank");
		leftPlankLbl.setForeground(Color.WHITE);
		leftPlankLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		leftPlankLbl.setBounds(41, 88, 156, 13);
		showWktFrame.getContentPane().add(leftPlankLbl);
		
		JLabel rightPlankLbl = new JLabel("1 minute right arm plank");
		rightPlankLbl.setForeground(Color.WHITE);
		rightPlankLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		rightPlankLbl.setBounds(41, 112, 156, 13);
		showWktFrame.getContentPane().add(rightPlankLbl);
		
		JLabel squatLbl = new JLabel("15 jump squats");
		squatLbl.setForeground(Color.WHITE);
		squatLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		squatLbl.setBounds(41, 138, 156, 13);
		showWktFrame.getContentPane().add(squatLbl);
		
		JLabel crunchesLbl = new JLabel("15 crunches");
		crunchesLbl.setForeground(Color.WHITE);
		crunchesLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		crunchesLbl.setBounds(41, 162, 156, 13);
		showWktFrame.getContentPane().add(crunchesLbl);
		
		JLabel pushUpsLbl = new JLabel("15 push ups");
		pushUpsLbl.setForeground(Color.WHITE);
		pushUpsLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		pushUpsLbl.setBounds(41, 186, 156, 13);
		showWktFrame.getContentPane().add(pushUpsLbl);
		
		JLabel jumpLabel = new JLabel("15 jumping jacks");
		jumpLabel.setForeground(Color.WHITE);
		jumpLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		jumpLabel.setBounds(41, 253, 133, 13);
		showWktFrame.getContentPane().add(jumpLabel);
		
		JLabel lungesLbl = new JLabel("15 lunges (each leg)");
		lungesLbl.setForeground(Color.WHITE);
		lungesLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lungesLbl.setBounds(41, 277, 133, 13);
		showWktFrame.getContentPane().add(lungesLbl);
		
		JLabel burpeeLbl = new JLabel("10 burpees");
		burpeeLbl.setForeground(Color.WHITE);
		burpeeLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		burpeeLbl.setBounds(41, 302, 133, 13);
		showWktFrame.getContentPane().add(burpeeLbl);
		
		JLabel mountainLbl = new JLabel("30 second mountain climbers");
		mountainLbl.setForeground(Color.WHITE);
		mountainLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		mountainLbl.setBounds(41, 326, 206, 13);
		showWktFrame.getContentPane().add(mountainLbl);
		
		JLabel japaneseLabels = new JLabel("10 japanese push ups");
		japaneseLabels.setForeground(Color.WHITE);
		japaneseLabels.setFont(new Font("Tahoma", Font.BOLD, 12));
		japaneseLabels.setBounds(41, 350, 175, 13);
		showWktFrame.getContentPane().add(japaneseLabels);
		
		JLabel jumpLungeLbl = new JLabel("10 jump lunges (each leg)");
		jumpLungeLbl.setForeground(Color.WHITE);
		jumpLungeLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		jumpLungeLbl.setBounds(41, 376, 175, 13);
		showWktFrame.getContentPane().add(jumpLungeLbl);
		
		JButton button = new JButton("Back to Profile");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileScreen profile = new ProfileScreen();
				showWktFrame.setVisible(false);
				ProfileScreen.displayProfileScreen();
			}
		});
		button.setBounds(134, 402, 135, 23);
		showWktFrame.getContentPane().add(button);
		showWktFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
