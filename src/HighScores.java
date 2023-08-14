import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HighScores extends JPanel implements ActionListener {
    
    JButton back;
    int screenWidth = MainMenu.screenWidth;
    int screenHeight = MainMenu.screenHeight;
    Font highScoresFont = new Font("Sans Serif", Font.BOLD, 35);

    public void initializeButton(JButton b) {
        b.setFont(highScoresFont);
        b.setBackground(Color.BLUE);
        b.setOpaque(true);
        b.addActionListener(this);
    }

    public HighScores() {
        back = new JButton("BACK");
        initializeButton(back);

        back.setBounds(0, 0, (screenHeight/10), screenHeight/10);

        JLabel inProgress = new JLabel("In Progress");
        inProgress.setBounds(screenWidth/2, screenHeight/2, (screenHeight/10), screenHeight/10);
        add(inProgress);

        setLayout(null);
        setBackground(Color.GRAY);
        add(back);
    }

    public void actionPerformed(ActionEvent buttonClick) {
        if (buttonClick.getSource() == back) {
            MainMenu.mainFrame.getContentPane().removeAll();
            MainMenu mm = new MainMenu();
            setVisible(true);
        }
    }

}
