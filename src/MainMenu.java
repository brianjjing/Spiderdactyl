import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    
    public static JFrame mainFrame;
    public static JPanel mainPanel;
    JButton playButton;
    JButton highScores;
    JButton settings;
    JButton quit;
    Font mainMenuFont = new Font("Sans Serif", Font.BOLD, 35);

    public void initializeButton(JButton b) {
        b.setFont(mainMenuFont);
        b.setBackground(Color.BLUE);
        b.setOpaque(true);
        b.addActionListener(this);
    }

    public static int screenWidth = 2240;
    public static int screenHeight = 1260;

    public MainMenu() {
        getContentPane().removeAll();

        mainFrame = new JFrame("Spiderdactyl");
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        pack();

        playButton = new JButton("PLAY");
        initializeButton(playButton);
        highScores = new JButton("HIGH SCORES");
        initializeButton(highScores);
        settings = new JButton("SETTINGS");        
        initializeButton(settings);
        quit = new JButton("QUIT");        
        initializeButton(quit);

        playButton.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*225, (screenWidth/10)*4, screenHeight/10);
        highScores.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*375, (screenWidth/10)*4, screenHeight/10);
        settings.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*525, (screenWidth/10)*4, screenHeight/10);
        quit.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*675, (screenWidth/10)*4, screenHeight/10);
        //50 space between buttons

        mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.GRAY);
        mainPanel.add(playButton);  
        mainPanel.add(highScores);  
        mainPanel.add(settings);  
        mainPanel.add(quit);
        getContentPane().add(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent buttonClick) {
        if (buttonClick.getSource() == playButton) {
            getContentPane().removeAll();
            Games g = new Games();
            getContentPane().add(g);
            setVisible(true);
        }
        else if (buttonClick.getSource() == highScores) {
            getContentPane().removeAll();
            HighScores h = new HighScores();
            getContentPane().add(h);
            setVisible(true);
        }
        else if (buttonClick.getSource() == settings) {
            getContentPane().removeAll();
            Settings s = new Settings();
            getContentPane().add(s);
            setVisible(true);
        }
        else if (buttonClick.getSource() == quit) {
            mainFrame.dispose();
        }
    }

    public static void main(String[] args) {
        MainMenu mm = new MainMenu();
    }
}