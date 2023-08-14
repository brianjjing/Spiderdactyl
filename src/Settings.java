import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JPanel implements ActionListener {

    JButton customization;
    JButton controls;
    JButton video;
    JButton audio;
    JButton back;
    int screenWidth = MainMenu.screenWidth;
    int screenHeight = MainMenu.screenHeight;
    Font settingsFont = new Font("Sans Serif", Font.BOLD, 35);

    public void initializeButton(JButton b) {
        b.setFont(settingsFont);
        b.setBackground(Color.BLUE);
        b.setOpaque(true);
        b.addActionListener(this);
    }

    public Settings(){
        customization = new JButton("CUSTOMIZATION");
        initializeButton(customization);
        controls = new JButton("CONTROLS");
        initializeButton(controls);
        video = new JButton("VIDEO");
        initializeButton(video);
        audio = new JButton("AUDIO");
        initializeButton(audio);
        back = new JButton("BACK");
        initializeButton(back);

        
        customization.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*225, (screenWidth/10)*4, screenHeight/10);
        //customization = skins and colors and such
        controls.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*375, (screenWidth/10)*4, screenHeight/10);
        //controls = keybinds and hud and stuff
        video.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*525, (screenWidth/10)*4, screenHeight/10);
        //video = brightness and fov and distance and stuff
        audio.setBounds(screenWidth/2 - (screenWidth/10)*2, (screenHeight/1000)*675, (screenWidth/10)*4, screenHeight/10);
        //sounds and volume and stuff
        back.setBounds(0, 0, (screenHeight/10), screenHeight/10);
        //50 space between buttons

        setLayout(null);
        setBackground(Color.GRAY);
        add(customization);
        add(controls);
        add(video);
        add(audio);
        add(back);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent buttonClick) {
        if (buttonClick.getSource() == customization) {
            
        }
        else if (buttonClick.getSource() == controls) {
            
        }
        else if (buttonClick.getSource() == video) {
            
        }
        else if (buttonClick.getSource() == audio) {
            
        }
        else if (buttonClick.getSource() == back) {
            MainMenu.mainFrame.getContentPane().removeAll();
            MainMenu mm = new MainMenu();
            MainMenu.mainFrame.repaint();
            //no need to set content pane here
        }
    }   
}
