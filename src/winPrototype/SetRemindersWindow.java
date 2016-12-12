package winPrototype;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import win.*;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetRemindersWindow {

	private JFrame remindersFrame;
	private static User user = HomeScreen.getUser();
	private JTextField dateField;
	private JTextField nameField;
	private JTextField timeField;

	/**
	 * Launch the application.
	 */
	public static void displaySetRemindersWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetRemindersWindow window = new SetRemindersWindow();
					window.remindersFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetRemindersWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the remindersFrame.
	 */
	private void initialize() {
		remindersFrame = new JFrame();
		remindersFrame.setBounds(100, 100, 295, 475);
		remindersFrame.getContentPane().setBackground(SystemColor.textHighlight);
		remindersFrame.getContentPane().setLayout(null);
		
		Label remindersLabel = new Label("Set Reminders");
		remindersLabel.setForeground(Color.WHITE);
		remindersLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		remindersLabel.setBounds(10, 10, 154, 36);
		remindersFrame.getContentPane().add(remindersLabel);
		
		JButton menuButton = new JButton("");
		/**takes the user to the menu window
		 * 
		 */
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuWindow menuWindow = new MenuWindow();
				menuWindow.displayMenuWindow();
				remindersFrame.setVisible(false);
				
			}
		});
		menuButton.setBounds(231, 10, 38, 36);
		remindersFrame.getContentPane().add(menuButton);
		ImageIcon menuIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\menu-icon.png");
		Image menuImg = menuIcon.getImage();
		Image resizedMenu = menuImg.getScaledInstance(menuButton.getWidth(), menuButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedMenuIcon = new ImageIcon(resizedMenu);
		menuButton.setIcon(resizedMenuIcon);
		
		JLabel newReminderLbl = new JLabel("New Reminder");
		newReminderLbl.setForeground(Color.WHITE);
		newReminderLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		newReminderLbl.setBounds(10, 78, 184, 19);
		remindersFrame.getContentPane().add(newReminderLbl);
		
		JLabel dateLabel = new JLabel("Enter date in the form dd/mm/yy and hit enter");
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		dateLabel.setBounds(10, 292, 246, 13);
		remindersFrame.getContentPane().add(dateLabel);
		
		dateField = new JTextField("");
		String reminderDate = dateField.getText();
		dateField.setColumns(10);
		dateField.setBounds(10, 261, 86, 20);
		remindersFrame.getContentPane().add(dateField);
		
		nameField = new JTextField("");
		String reminderName = nameField.getText();
		nameField.setColumns(10);
		nameField.setBounds(10, 119, 86, 20);
		remindersFrame.getContentPane().add(nameField);
		
		JLabel nameLabel = new JLabel("Give your reminder a name and hit enter");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		nameLabel.setBounds(10, 150, 246, 13);
		remindersFrame.getContentPane().add(nameLabel);
		
		timeField = new JTextField("");
		String reminderTime = timeField.getText();
		timeField.setColumns(10);
		timeField.setBounds(10, 191, 86, 20);
		remindersFrame.getContentPane().add(timeField);
		
		JLabel timeLabel = new JLabel("Enter time in the form hh:mm-am/pm and hit enter");
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		timeLabel.setBounds(10, 222, 259, 13);
		remindersFrame.getContentPane().add(timeLabel);
		
		JButton setReminderBttn = new JButton("Set Reminder");
		setReminderBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.getReminders().setReminder(reminderDate.concat(reminderTime),reminderName);
				ReminderAddedWindow reminderAdded = new ReminderAddedWindow();
				reminderAdded.displayReminderAddedWindow();
				remindersFrame.setVisible(false);
			}
		});
		setReminderBttn.setBounds(82, 360, 112, 23);
		remindersFrame.getContentPane().add(setReminderBttn);
		remindersFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
