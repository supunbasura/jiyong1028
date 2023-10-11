package Project;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LanguageLearningMain extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public LanguageLearningMain() {
		setTitle("LangLearn!");
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




		JButton btnNewButton = new JButton("User");
		btnNewButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 30));
		btnNewButton.setBounds(1292, 47, 250, 250);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							user frame = new user();
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
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Vocabulary");
		btnNewButton_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							voca frame = new voca();
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
		btnNewButton_1.setBounds(47, 47, 1224, 250);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Grammer");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							gram frame = new gram();
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
		btnNewButton_1_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 30));
		btnNewButton_1_1.setBounds(47, 308, 1224, 250);
		getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Phrasebook");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							phra frame = new phra();
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
		btnNewButton_1_2.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 30));
		btnNewButton_1_2.setBounds(47, 569, 1224, 250);
		getContentPane().add(btnNewButton_1_2);

		JButton btnLearning = new JButton("<html>Learning<br />Progress</html>");
		btnLearning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							learProg frame = new learProg();
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
		btnLearning.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 30));
		btnLearning.setBounds(1292, 308, 250, 250);
		getContentPane().add(btnLearning);

		JButton btnTopic = new JButton("topic");
		btnTopic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							topi frame = new topi();
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
		btnTopic.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 30));
		btnTopic.setBounds(1292, 569, 250, 250);
		getContentPane().add(btnTopic);
	}
}
