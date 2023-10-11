package Project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class phra extends JFrame {

	private JPanel contentPane;
	private String[] phrases = {
			"Break the ice",
			"Bite the bullet",
			"Cut corners",
			"Hit the nail on the head",
			"Let the cat out of the bag",
			"The ball is in your court",
			"Get your act together",
			"Pull yourself together",
			"Jump on the bandwagon",
			"Wrap your head around it",
			"Get out of hand",
			"Break a leg",
			"Call it a day",
			"Go back to the drawing board",
			"Get something out of your system",
			"Burning the midnight oil",
			"Cutting it close",
			"Read between the lines",
			"Add fuel to the fire",
			"Sit tight",
			"Bite off more than you can chew",
			"Break the bank",
			"Don't cry over spilled milk",
			"Kill two birds with one stone",
			"Give the benefit of the doubt",
			"Take it with a grain of salt",
			"Go down in flames",
			"Hit the sack",
			"Out of the frying pan into the fire",
			"You can't make an omelet without breaking a few eggs"
		};

		private String[] meanings = {
			"To initiate social interaction",
			"To face a difficult situation with courage",
			"To do something in the easiest or cheapest way",
			"To describe exactly what is causing a situation or problem",
			"To accidentally reveal a secret",
			"It is your decision now",
			"Work seriously and responsibly",
			"Calm down",
			"Join a popular activity",
			"Understand something complicated",
			"Get out of control",
			"Good luck",
			"Stop working for the day",
			"Start over",
			"Do the thing you've been wanting to do",
			"Work late into the night",
			"Finish just barely on time",
			"Look for deeper or hidden meaning",
			"Worsen a bad situation",
			"Wait patiently",
			"Take on a task that is too big",
			"Expend a lot of effort or money",
			"Don't dwell on past mistakes",
			"Achieve two objectives with one action",
			"Trust someone's honesty",
			"Be skeptical",
			"Fail spectacularly",
			"Go to sleep",
			"Go from one problem to another",
			"It's impossible to achieve something significant without making sacrifices"
		};

	
	private int currentIndex = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public phra() {
		setTitle("LangLearn! - Phrasebook");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1600, 900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel phraBox = new JLabel(phrases[currentIndex]);
		phraBox.setHorizontalAlignment(SwingConstants.CENTER);
		phraBox.setFont(new Font("Tahoma", Font.PLAIN, 50));
		phraBox.setBounds(425, 60, 731, 418);
		contentPane.add(phraBox);

		JLabel defBox = new JLabel(meanings[currentIndex]);
		defBox.setHorizontalAlignment(SwingConstants.CENTER);
		defBox.setFont(new Font("Tahoma", Font.PLAIN, 35));
		defBox.setBounds(417, 488, 739, 213);
		contentPane.add(defBox);

		JButton nxtBtn = new JButton("Next");
		nxtBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nxtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIndex++;
				if (currentIndex >= phrases.length) {
					currentIndex = 0;
				}
				phraBox.setText(phrases[currentIndex]);
				defBox.setText(meanings[currentIndex]);
			}
		});
		nxtBtn.setBounds(1342, 61, 126, 748);
		contentPane.add(nxtBtn);
		
		JButton prevBtn = new JButton("Previous");
		prevBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIndex--;
				if (currentIndex < 0) {
					currentIndex = phrases.length - 1;
				}
				phraBox.setText(phrases[currentIndex]);
				defBox.setText(meanings[currentIndex]);
			}
		});
		prevBtn.setBounds(121, 61, 126, 748);
		contentPane.add(prevBtn);
		
		JButton btnNewButton = new JButton("←");
		btnNewButton.addActionListener(new ActionListener() {
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
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 50, 50);
		contentPane.add(btnNewButton);
	}
}
