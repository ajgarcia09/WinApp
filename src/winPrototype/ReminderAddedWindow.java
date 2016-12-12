package winPrototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import win.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class ReminderAddedWindow {

	private JFrame reminderAddedFrame;
	private User user = HomeScreen.getUser();

	/**
	 * Launch the application.
	 */
	public static void displayReminderAddedWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReminderAddedWindow window = new ReminderAddedWindow();
					window.reminderAddedFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReminderAddedWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		reminderAddedFrame = new JFrame();
		reminderAddedFrame.setBounds(100, 100, 295, 475);
		reminderAddedFrame.getContentPane().setBackground(SystemColor.textHighlight);
		reminderAddedFrame.getContentPane().setLayout(null);
		
		JLabel reminderAddLabel = new JLabel("Reminder Added!");
		reminderAddLabel.setForeground(Color.WHITE);
		reminderAddLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		reminderAddLabel.setBounds(10, 257, 269, 37);
		reminderAddedFrame.getContentPane().add(reminderAddLabel);
		
		JButton homeButton = new JButton("Back to Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				reminderAddedFrame.setVisible(false);
			}
		});
		homeButton.setBounds(46, 305, 183, 33);
		reminderAddedFrame.getContentPane().add(homeButton);
		
		JButton addReminderBtn = new JButton("Add Another Reminder");
		addReminderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetRemindersWindow reminder = new SetRemindersWindow();
				reminder.displaySetRemindersWindow();
				reminderAddedFrame.setVisible(false);
			}
		});
		addReminderBtn.setBounds(46, 352, 183, 33);
		reminderAddedFrame.getContentPane().add(addReminderBtn);
		
		JLabel checkMarkLabel = new JLabel("");
		checkMarkLabel.setBounds(57, 70, 150, 150);
		ImageIcon myImage = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\checkMark_smaller.png");
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(checkMarkLabel.getWidth(), checkMarkLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		checkMarkLabel.setIcon(image);
		
		reminderAddedFrame.getContentPane().add(checkMarkLabel);
		reminderAddedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}

}
