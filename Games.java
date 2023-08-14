import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Games extends JPanel implements ActionListener {

    JButton PTF;
    JButton io;
    JButton back;
    int screenWidth = MainMenu.screenWidth;
    int screenHeight = MainMenu.screenHeight;
    Font gamesFont = new Font("Sans Serif", Font.BOLD, 35);

    public void initializeButton(JButton b) {
        b.setFont(gamesFont);
        b.setBackground(Color.BLUE);
        b.setOpaque(true);
        b.addActionListener(this);
    }

    public Games(){
        PTF = new JButton("PROTECT THE FORT");
        initializeButton(PTF);
        io = new JButton("SPIDAC.IO");
        initializeButton(io);
        back = new JButton("BACK");
        initializeButton(back);
        
        setLayout(null);
        PTF.setBounds(screenWidth/2 - (screenWidth/5), (screenHeight/1000)*375, (screenWidth/5)*2, screenHeight/10);
        io.setBounds(screenWidth/2 - (screenWidth/5), (screenHeight/1000)*525, (screenWidth/5)*2, screenHeight/10);
        back.setBounds(0, 0, (screenHeight/10), screenHeight/10);
        //50 space between buttons

        setBackground(Color.GRAY);
        add(PTF);
        add(io);
        add(back);
    }
 
    public void actionPerformed(ActionEvent buttonClick) {
        if (buttonClick.getSource() == PTF) {
            MainMenu.mainFrame.getContentPane().removeAll();
            ProtectTheFort ptf = new ProtectTheFort();    
            MainMenu.mainFrame.getContentPane().add(ptf);
            MainMenu.mainFrame.repaint();
            MainMenu.mainFrame.setVisible(true);
        }
        else if (buttonClick.getSource() == io) {
            Spidacio sio = new Spidacio();
            MainMenu.mainFrame.setVisible(true);
        }
        else if (buttonClick.getSource() == back) {
            MainMenu.mainFrame.getContentPane().removeAll();
            MainMenu mm = new MainMenu();
            MainMenu.mainFrame.repaint();
        }
    } 
} 
