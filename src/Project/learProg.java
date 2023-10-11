package Project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class learProg extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
    }

    /**
     * Create the frame.
     */
    public learProg() {
        setTitle("LangLearn! - Learning Progress");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 1600, 900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("←");
        btnNewButton.setBounds(0, 0, 50, 50);
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
        contentPane.add(btnNewButton);

        JPanel pieChart = new JPanel();
        pieChart.setBounds(1113, 64, 378, 390);
        contentPane.add(pieChart);

        JLabel lblNewLabel = new JLabel("User Name");
        lblNewLabel.setBounds(136, 64, 486, 37);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("User ID");
        lblNewLabel_1.setBounds(136, 112, 486, 37);
        contentPane.add(lblNewLabel_1);

        JButton calBtn = new JButton("Calendar");
        calBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            calend frame = new calend();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        calBtn.setBounds(1063, 575, 289, 136);
        contentPane.add(calBtn);

        JLabel lblNewLabel_2 = new JLabel("Days Studied");
        lblNewLabel_2.setBounds(108, 533, 295, 188);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Last Studied");
        lblNewLabel_2_1.setBounds(416, 533, 295, 188);
        contentPane.add(lblNewLabel_2_1);
    }
}
