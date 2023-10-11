package Project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class voca extends JFrame {

    private JPanel contentPane;
    private JLabel givenWord;
    private JButton choice1;
    private JButton choice2;
    private JButton redo;
    private JLabel vocabProg;

    private int correctAnswers = 0;
    private int totalAnswers = 0;

    private HashMap<String, String> vocabulary = new HashMap<String, String>() {{
        put("Incessant", "Uninterrupted");
        put("Aptitude", "Natural ability");
        put("Perfidy", "Betrayal");
        put("Impartial", "Unbiased");
        put("Affinity", "Natural attraction");
        put("Ambiguous", "Open to more than one interpretation");
        put("Benevolent", "Well-meaning and kind");
        put("Capitulate", "To surrender, often after negotiation");
        put("Dubious", "Hesitating or doubting; not to be relied upon");
        put("Eloquent", "Fluent or persuasive in speaking or writing");
        put("Fickle", "Changing frequently, especially in loyalties");
        put("Gregarious", "Fond of company; sociable");
        put("Harangue", "A lengthy and aggressive speech");
        put("Ineffable", "Too great or extreme to be expressed in words");
        put("Juxtapose", "Place or deal with close together for contrasting effect");
        put("Kaleidoscope", "A constantly changing pattern or sequence of elements");
        put("Languid", "Lacking spirit or liveliness");
        put("Malleable", "Capable of being shaped or bent");
        put("Nefarious", "Wicked or criminal");
        put("Obfuscate", "Render obscure, unclear, or unintelligible");
        put("Palliate", "To make less severe or unpleasant without removing the cause");
        put("Quintessential", "Representing the most perfect example of a quality");
        put("Rhetoric", "Effective writing or speaking");
        put("Sycophant", "A person who acts obsequiously toward someone to gain advantage");
        put("Tenacious", "Tending to keep a firm hold of something; clinging or adhering closely");
        put("Ubiquitous", "Present, appearing, or found everywhere");
        put("Vex", "To annoy, frustrate, or worry");
        put("Whimsical", "Playfully quaint or fanciful, especially in an appealing and amusing way");
        put("Xenophobic", "Having or showing a dislike of or prejudice against people from other countries");
        put("Yearn", "To have an intense feeling of desire for something, typically something that one has lost or been separated from");
        put("Zealous", "Having or showing zeal; fervent");
        put("Apathetic", "Showing or feeling no interest, enthusiasm, or concern");
        put("Blasé", "Unimpressed or indifferent to something because one has experienced or seen it so often before");
        put("Cognizant", "Having knowledge or being aware of");
        put("Dearth", "A scarcity or lack of something");
        put("Exacerbate", "To make a situation worse");
        put("Facetious", "Treating serious issues with deliberately inappropriate humor");
        put("Gravitas", "Dignity, seriousness, or solemnity of manner");
        put("Hubris", "Excessive pride or self-confidence");
        put("Intricate", "Very complicated or detailed");
        put("Jovial", "Cheerful and friendly");
        put("Knack", "An acquired or natural skill at performing a task");
        put("Lucrative", "Producing a great deal of profit");
        put("Myriad", "A countless or extremely great number");
        put("Nuance", "A subtle difference in or shade of meaning, expression, or sound");
        put("Opaque", "Not able to be seen through; not transparent");
        put("Pernicious", "Having a harmful effect, especially in a gradual or subtle way");
        put("Quintuple", "Consisting of five parts or things");
        put("Rambunctious", "Uncontrollably exuberant; boisterous");
        put("Sagacious", "Having or showing keen mental discernment and good judgment; wise");
        put("Taciturn", "Reserved or uncommunicative in speech; saying little");
        put("Voracious", "Wanting or devouring great quantities of food; having a very eager approach to an activity");
        put("Wistful", "Having or showing a feeling of vague or regretful longing");
        put("Zealot", "A person who is fanatical and uncompromising in pursuit of their religious, political, or other ideals");
    }};

    private String correctWord;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    voca frame = new voca();
                    frame.setVisible(true);
                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            frame.saveProgress();
                        }
                    });
                    frame.refreshQuiz();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public voca() {
        loadProgress();
        setTitle("LangLearn! - Vocabulary");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 1600, 900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        
        
        
        
        
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
				// Close the current window
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 50, 50);
		contentPane.add(btnNewButton);
        
        
        
        
        
        
        
        

        choice1 = new JButton("New button");
        choice1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        choice1.setBounds(131, 246, 1341, 170);
        choice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                totalAnswers++;
                if (choice1.getText().equals(vocabulary.get(correctWord))) {
                    correctAnswers++;
                    givenWord.setForeground(Color.GREEN);
                } else {
                    givenWord.setForeground(Color.RED);
                }
                updateProgressLabel();
                choice1.setEnabled(false);
                choice2.setEnabled(false);
            }
        });
        contentPane.add(choice1);

        choice2 = new JButton("New button");
        choice2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        choice2.setBounds(131, 469, 1341, 170);
        choice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                totalAnswers++;
                if (choice2.getText().equals(vocabulary.get(correctWord))) {
                    correctAnswers++;
                    givenWord.setForeground(Color.GREEN);
                } else {
                    givenWord.setForeground(Color.RED);
                }
                updateProgressLabel();
                choice1.setEnabled(false);
                choice2.setEnabled(false);
            }
        });
        contentPane.add(choice2);

        givenWord = new JLabel("New label");
        givenWord.setHorizontalAlignment(SwingConstants.CENTER);
        givenWord.setFont(new Font("Tahoma", Font.PLAIN, 18));
        givenWord.setBounds(606, 66, 390, 142);
        contentPane.add(givenWord);

        redo = new JButton("NEXT");
        redo.setBounds(737, 712, 133, 81);
        redo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshQuiz();
                choice1.setEnabled(true);  // Re-enable the button
                choice2.setEnabled(true);  // Re-enable the button
            }
        });
        contentPane.add(redo);

        vocabProg = new JLabel("New label");
        vocabProg.setBounds(1519, 18, 55, 14);
        contentPane.add(vocabProg);
        
        JLabel lable123 = new JLabel("Correct:");
        lable123.setBounds(1463, 18, 46, 14);
        contentPane.add(lable123);
        
        updateProgressLabel();
        refreshQuiz();
    }

    public void refreshQuiz() {
        Random rand = new Random();
        Object[] keys = vocabulary.keySet().toArray();
        correctWord = (String) keys[rand.nextInt(keys.length)];
        String correctDefinition = vocabulary.get(correctWord);

        List<String> wrongDefinitions = new ArrayList<>(vocabulary.values());
        wrongDefinitions.remove(correctDefinition);

        String wrongDefinition = wrongDefinitions.get(rand.nextInt(wrongDefinitions.size()));
        givenWord.setText(correctWord);
        givenWord.setForeground(Color.BLACK);

        if (rand.nextBoolean()) {
            choice1.setText(correctDefinition);
            choice2.setText(wrongDefinition);
        } else {
            choice2.setText(correctDefinition);
            choice1.setText(wrongDefinition);
        }
    }

    private void updateProgressLabel() {
        float progress = (totalAnswers == 0) ? 0 : ((float) correctAnswers / totalAnswers) * 100;
        vocabProg.setText(String.format("%.1f%%", progress));
    }

    private void saveProgress() {
        try (FileWriter writer = new FileWriter("progress.txt", false)) {
            writer.write(correctAnswers + "," + totalAnswers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadProgress() {
        try (BufferedReader reader = new BufferedReader(new FileReader("progress.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                correctAnswers = Integer.parseInt(parts[0]);
                totalAnswers = Integer.parseInt(parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}