package Project;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.Properties;

import javax.swing.JOptionPane;

public class old_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	

	private void saveUserInfo(String userName, String userId, String userEmail, String userAge, String userLevel) {
	    Properties properties = new Properties();
	    properties.setProperty("userName", userName);
	    properties.setProperty("userId", userId);
	    properties.setProperty("userEmail", userEmail);
	    properties.setProperty("userAge", userAge);
	    properties.setProperty("userLevel", userLevel);

	    try (FileOutputStream out = new FileOutputStream("userInfo.properties")) {
	        properties.store(out, "User Information");
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Handle the exception appropriately
	    }
	}
	
	

	private void loadUserInfo() {
	    Properties properties = new Properties();
	    try (FileInputStream in = new FileInputStream("userInfo.properties")) {
	        properties.load(in);
	        textField.setText(properties.getProperty("userName"));
	        textField_1.setText(properties.getProperty("userId"));
	        textField_2.setText(properties.getProperty("userEmail"));
	        textField_3.setText(properties.getProperty("userAge"));
	        textField_4.setText(properties.getProperty("userLevel"));
	    } catch (IOException e) {
	        // Handle the exception appropriately
	        e.printStackTrace();
	        
	        
	    }
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					old_user frame = new old_user();
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
	public old_user() {
		setTitle("LangLearn! - User");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1600, 900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				if (getExtendedState() != JFrame.MAXIMIZED_BOTH) {
					// If window is not maximized, give it fixed padding
					int padding = 50; // Adjust this value as per your requirement
					setBounds(padding, padding,
							Toolkit.getDefaultToolkit().getScreenSize().width - 2 * padding,
							Toolkit.getDefaultToolkit().getScreenSize().height - 2 * padding);
				}
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton back_button = new JButton();
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/Project/back.png"));

		back_button.setBounds(10, 10, 50, 50);
		back_button.setIcon(backIcon);
		back_button.setOpaque(false);
		back_button.setContentAreaFilled(false);
		back_button.setBorderPainted(false);


		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// Set the cursor to a hand cursor when the mouse enters the button
				back_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Set the cursor back to the default cursor when the mouse exits the button
				back_button.setCursor(Cursor.getDefaultCursor());
			}
		});

		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LanguageLearningMain frame = new LanguageLearningMain();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// Close the current window
				dispose();
			}
		});

		contentPane.add(back_button);



		JButton btnSave = new JButton("Save");
		btnSave.setBounds(646, 620, 100, 25); // Position the button as per your layout
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String userName = textField.getText();
		        String userId = textField_1.getText();
		        String userEmail = textField_2.getText();
		        String userAge = textField_3.getText();
		        String userLevel = textField_4.getText();

		        // Save the Project.user information
		        saveUserInfo(userName, userId, userEmail, userAge, userLevel);

		        // Optional: Provide feedback to the Project.user
		        JOptionPane.showMessageDialog(null, "User information saved!");
		    }
		});



		contentPane.setLayout(null);

		JLabel pfpHolder = new JLabel("pfp place");
		pfpHolder.setBounds(592, 60, 400, 400);
		try {
			URL imgURL = getClass().getResource("/Project/pfphold.jpg");
			if (imgURL != null) {
				ImageIcon originalIcon = new ImageIcon(imgURL);
				Image scaledImage = originalIcon.getImage().getScaledInstance(pfpHolder.getWidth(), pfpHolder.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon scaledIcon = new ImageIcon(scaledImage);
				pfpHolder.setIcon(scaledIcon);
			} else {
				System.err.println("Couldn't find file: " + "/Project/pfphold.jpg");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		contentPane.add(pfpHolder);
		


		textField = new JTextField();
		textField.setBounds(646, 501, 360, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(646, 524, 360, 20);
		textField_1.setColumns(10);
		textField_1.setEditable(false); // Make the Project.user ID field non-editable
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(646, 546, 360, 20);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(646, 569, 360, 20);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(646, 592, 360, 20);
		textField_4.setColumns(10);
		textField_4.setEditable(false); // Make the Project.user level field non-editable
		contentPane.add(textField_4);
		
		lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(535, 501, 400, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setBounds(535, 524, 400, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("User Email");
		lblNewLabel_2.setBounds(535, 546, 400, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("User Age");
		lblNewLabel_3.setBounds(535, 569, 400, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("User Level");
		lblNewLabel_4.setBounds(535, 592, 400, 14);
		contentPane.add(lblNewLabel_4);
		
		loadUserInfo(); // Load the previously saved Project.user info

	}
}