package winPrototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ConnectBand {

	private JFrame connectBandFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectBand window = new ConnectBand();
					window.connectBandFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectBand() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connectBandFrame = new JFrame();
		connectBandFrame.setBounds(100, 100, 295, 475);
		connectBandFrame.getContentPane().setBackground(SystemColor.textHighlight);
		connectBandFrame.getContentPane().setLayout(null);
		connectBandFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Label bandLabel = new Label("Connect Your Fit Band");
		bandLabel.setForeground(SystemColor.window);
		bandLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		bandLabel.setBounds(22, 10, 235, 75);
		connectBandFrame.getContentPane().add(bandLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ConnectBand.class.getResource("/winPrototype/fitBandicon.png")));
		lblNewLabel.setBounds(22, 109, 235, 213);
		connectBandFrame.getContentPane().add(lblNewLabel);
		
		JButton connectButton = new JButton("Connect Band");
		connectButton.setBounds(88, 349, 106, 35);
		connectBandFrame.getContentPane().add(connectButton);
		
		JTextArea instructionArea = new JTextArea();
		instructionArea.setText("Make sure your band is charged and your device's Bluetooth is enabled");
		instructionArea.setBounds(54, 60, 140, 50);
		connectBandFrame.getContentPane().add(instructionArea);
		
	}
}
