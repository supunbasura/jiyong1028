package Project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.net.URL;

public class topi extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
    }

    /**
     * Create the frame.
     */
    public topi() {
        setTitle("LangLearn! - Topics");
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
        contentPane.add(btnNewButton);

        // Additional debugging information
        URL url = getClass().getResource("/Project/Topics.jpg");
        if (url == null) {
            System.out.println("Image URL is null");
        } else {
            System.out.println("Image URL is " + url.toString());
        }

        ImageIcon imageIcon = new ImageIcon(url);
        if (imageIcon.getImage().getWidth(null) == -1) {
            System.out.println("Image not found");
        } else {
            System.out.println("Image found");
        }

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(400, 100, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        contentPane.add(imageLabel);
    }
}
