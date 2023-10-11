package Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class gramss extends JFrame {

    private JPanel contentPane;
    private Random random = new Random();

    private String[] correctSentences = {
    	    "I am going to the market.",
    	    "He is taller than she is.",
    	    "The cat lies on the mat.",
    	    "You should bring your coat.",
    	    "She writes beautifully.",
    	    "They're going to the store.",
    	    "He's better at this than I am.",
    	    "Who are you?",
    	    "Whose book is this?",
    	    "I could have done better.",
    	    "I have fewer pencils than you.",
    	    "She has less money.",
    	    "It's raining outside.",
    	    "They're all good options.",
    	    "I'll take two pieces of cake.",
    	    "There are many reasons.",
    	    "You're looking well.",
    	    "I've been waiting for an hour.",
    	    "She was affected by the news.",
    	    "They're over there with their friends.",
    	    "The company is laying off workers.",
    	    "The principal is your pal.",
    	    "It's a serious problem.",
    	    "You and I should go.",
    	    "She neither called nor wrote."
    	};

    	private String[] incorrectSentences = {
    	    "I am go to the market.",
    	    "He is taller then she is.",
    	    "The cat lays on the mat.",
    	    "You should take you're coat.",
    	    "She writes good.",
    	    "Their going to the store.",
    	    "He's better at this then me am.",
    	    "Who is you?",
    	    "Who's book is this?",
    	    "I could of done better.",
    	    "I have less pencils then you.",
    	    "She has fewer money.",
    	    "Its raining outside.",
    	    "There all good options.",
    	    "I'll take to pieces of cake.",
    	    "There is many reasons.",
    	    "Your looking good.",
    	    "I've been waiting since an hour.",
    	    "She was effected by the news.",
    	    "Their over they're with there friends.",
    	    "The company is lieing off workers.",
    	    "The principle is your pal.",
    	    "Its a serious problem.",
    	    "You and me should go.",
    	    "She neither called or wrote."
    	};

    	private String[] explanations = {
    	    "The correct form is 'going to', not 'go to'.",
    	    "'Than' is the correct word when making comparisons, not 'then'.",
    	    "'Lies' is the correct word when there is no direct object.",
    	    "'Your' is possessive; 'you're' means 'you are'.",
    	    "'Beautifully' is the correct adverb form of 'beautiful'.",
    	    "'They're' is short for 'they are'; 'their' is possessive.",
    	    "'Than' is used for comparison; 'I am' is the correct pronoun and verb.",
    	    "'Who' is the correct subject pronoun.",
    	    "'Whose' is possessive; 'who's' means 'who is' or 'who has'.",
    	    "'Could have' is correct; 'could of' is incorrect.",
    	    "'Fewer' is for countable objects; 'than' is for comparison.",
    	    "'Less' is for uncountable objects.",
    	    "'It's' means 'it is'; 'its' is possessive.",
    	    "'They're' means 'they are'; 'all' refers to 'options'.",
    	    "'Two' is the correct spelling; 'pieces' is the correct plural form.",
    	    "'There are' is correct for plural objects.",
    	    "'You're looking well' is correct for describing health.",
    	    "'For an hour' is correct; 'since' is used with a specific past time.",
    	    "'Affected' is the correct word; 'effected' means 'brought about'.",
    	    "'They're' means 'they are'; 'over there' is a location; 'their' is possessive.",
    	    "'Laying off' is the correct form; 'lieing' is not a word.",
    	    "'Principal' is a head or leader; 'pal' is a mnemonic device.",
    	    "'It's' means 'it is'; 'its' is possessive.",
    	    "'You and I' is the correct subject; 'should go' is the correct verb phrase.",
    	    "'Neither' is paired with 'nor', not 'or'."
    	};


    private int currentQuestionIndex;
    private JLabel explain;
    private JButton sentence1;
    private JButton sentence2;
    private int correctAnswers = 0;
    private int totalQuestions = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gramss frame = new gramss();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public gramss() {
        setTitle("LangLearn! - Grammar");
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
                dispose();
            }
        });
        btnNewButton.setBounds(0, 0, 50, 50);
        contentPane.add(btnNewButton);

        sentence1 = new JButton("New button");
        sentence1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        sentence1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(sentence1.getText());
            }
        });
        sentence1.setBounds(169, 174, 1261, 175);
        contentPane.add(sentence1);

        sentence2 = new JButton("New button");
        sentence2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        sentence2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(sentence2.getText());
            }
        });
        sentence2.setBounds(169, 360, 1261, 175);
        contentPane.add(sentence2);


        explain = new JLabel("New label");
        explain.setFont(new Font("Tahoma", Font.PLAIN, 30));
        explain.setHorizontalAlignment(SwingConstants.CENTER);
        explain.setBounds(169, 566, 1261, 157);
        contentPane.add(explain);

        JButton next = new JButton("Next");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadNewQuestion();
            }
        });
        next.setBounds(756, 777, 89, 73);
        contentPane.add(next);

        loadNewQuestion();
    }
    
    private void loadNewQuestion() {
        currentQuestionIndex = random.nextInt(correctSentences.length);
        if (random.nextBoolean()) {
            sentence1.setText(correctSentences[currentQuestionIndex]);
            sentence2.setText(incorrectSentences[currentQuestionIndex]);
        } else {
            sentence1.setText(incorrectSentences[currentQuestionIndex]);
            sentence2.setText(correctSentences[currentQuestionIndex]);
        }
        
        explain.setText("");
        sentence1.setBackground(null);
        sentence2.setBackground(null);
    }

    private void checkAnswer(String selectedSentence) {
        Color softGreen = new Color(144, 238, 144);  // A softer green color
        Color softRed = new Color(255, 102, 102);    // A softer red color

        if (selectedSentence.equals(correctSentences[currentQuestionIndex])) {
            correctAnswers++;
            explain.setText("Correct! " + explanations[currentQuestionIndex]);
            sentence1.setBackground(selectedSentence.equals(sentence1.getText()) ? softGreen : null);
            sentence2.setBackground(selectedSentence.equals(sentence2.getText()) ? softGreen : null);
        } else {
            explain.setText("Incorrect! " + explanations[currentQuestionIndex]);
            sentence1.setBackground(selectedSentence.equals(sentence1.getText()) ? softRed : null);
            sentence2.setBackground(selectedSentence.equals(sentence2.getText()) ? softRed : null);
        }
        totalQuestions++;
    }

}
