package winPrototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Reminders extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static Reminders frame;
	private JTextField reminder;
	private JTextField dateAndTime;
	HashMap<String, String> reminders = new HashMap<String, String>();
	private String rem;
	private String time;

	/**
	 * Launch the application.
	 */
	public static void displayRemindersWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Reminders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reminders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		reminder = new JTextField();
		reminder.setColumns(10);
		
		dateAndTime = new JTextField();
		dateAndTime.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MenuWindow logWindow = new MenuWindow();
            	frame.setVisible(false);
				logWindow.displayMenuWindow();
				
            }
        });
		JButton btnAddReminder = new JButton("Add Reminder");
		String rem = reminder.getText();
	    String time = reminder.getText();
		btnAddReminder.addActionListener(this);
		
		JLabel lblEnterReminder = new JLabel("Enter Reminder");
		
		JLabel lblEnterDateDdmmyy = new JLabel("Enter Date: dd/mm/yy HH:MM(24 hr format)");
		
		JLabel lblExample = new JLabel("Example: 11/12/16 14:20");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(reminder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(168)
					.addComponent(lblEnterReminder)
					.addContainerGap(177, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addComponent(lblEnterDateDdmmyy)
					.addGap(71))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addComponent(lblExample)
					.addContainerGap(143, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(148)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddReminder)
						.addComponent(dateAndTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack)
					.addContainerGap(323, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack)
					.addGap(28)
					.addComponent(lblEnterReminder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reminder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEnterDateDdmmyy)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblExample)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateAndTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnAddReminder)
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public HashMap<String, String> getReminders() {
		return reminders;
	}	

	public void turnOnNotification(String date) {
		String message = reminders.get(date);
		JOptionPane.showMessageDialog(null, "Reminder: " + message);
	    }	

	@Override
	public void actionPerformed(ActionEvent e) {
		reminders.put(rem, time);
		JOptionPane.showMessageDialog(null, "Succesfully added");
		}
}