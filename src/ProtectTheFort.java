import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProtectTheFort extends JPanel implements KeyListener {
    public ImageIcon fort;
    public JLabel fortLabel;
    public ImageIcon spiderdactyl;
    public JLabel spiderdactylLabel;
    int screenWidth = MainMenu.screenWidth;
    int screenHeight = MainMenu.screenHeight;
    Timer gameTimer;
    int health;
    int spawnRate;
    
    public ProtectTheFort() {
        fort = new ImageIcon("/Users/brian/Documents/Java/Project3 - Spiderdactyl/Icon Images/Full Health Fort.png");
        Image scaledFort = fort.getImage().getScaledInstance(screenWidth/10, screenHeight/10, Image.SCALE_SMOOTH);
        fort = new ImageIcon(scaledFort);
        fortLabel = new JLabel(fort);
        fortLabel.setBounds(screenWidth/2 - screenWidth/20, screenHeight/2 - screenHeight/20, screenWidth/10, screenHeight/10);

        setFocusable(true);
        setLayout(null);
        setBackground(Color.GREEN);
        add(fortLabel);
        addKeyListener(this);
        setVisible(true);

        health = 3;
        spawnRate = 2000;
        IconMovement iconMovement = new IconMovement();
        gameTimer = new Timer(spawnRate, iconMovement);
        gameTimer.start();   
    }

    public class IconMovement implements ActionListener {
        int direction;
        int speed;

        public IconMovement() {
            initializeSpiderdactyl();
        }  

        public void initializeSpiderdactyl() {
            direction = ((int)(Math.random() * 8) + 1); 

            spiderdactyl = new ImageIcon("/Users/brian/Documents/Java/Project3 - Spiderdactyl/Icon Images/_SpiderdactylPos" + String.valueOf(direction) + ".png");
            Image scaledspiderdactyl = spiderdactyl.getImage().getScaledInstance(screenWidth/10, screenHeight/10, Image.SCALE_SMOOTH);
            spiderdactyl = new ImageIcon(scaledspiderdactyl);
            spiderdactylLabel = new JLabel(spiderdactyl);

            //try to make this algorithm shorter
            if (direction % 4 == 0) {
                spiderdactylLabel.setBounds((screenWidth - screenWidth/10)*(1 - direction/8), screenHeight/2 - screenHeight/20, screenWidth/10, screenHeight/10);
            }
            else if (direction % 2 == 0) {
                spiderdactylLabel.setBounds(screenWidth/2 - screenWidth/20, (screenHeight - screenHeight/10)*(direction/6), screenWidth/10, screenHeight/10);
            }
            else if  (direction < 4) {
                spiderdactylLabel.setBounds((screenWidth - screenWidth/10)*(direction/3), 0, screenWidth/10, screenHeight/10);
            }
            else {
                spiderdactylLabel.setBounds((screenWidth - screenWidth/10)*(1 - direction/7), screenHeight - screenHeight/10, screenWidth/10, screenHeight/10);
            }
            
            add(spiderdactylLabel);

            speed = 100;
        }

        //FOR EVERY SPIDER:
        public void actionPerformed(ActionEvent e) {     
            initializeSpiderdactyl();
            
            if (direction % 4 == 0) {
                Timer horizontalMovement = new Timer(speed, new HorizontalMovement());
                horizontalMovement.start();
            }
            else if (direction % 2 == 0) {
                Timer verticalMovement = new Timer(speed, new VerticalMovement());
                verticalMovement.start();
            }
            /*else {
                //find some way
            }*/
        }

        class HorizontalMovement implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (direction == 4) {
                    if (spiderdactylLabel.getX() > (screenWidth/2 + screenWidth/20)) {
                        spiderdactylLabel.setBounds(spiderdactylLabel.getX() - screenWidth/100, screenHeight/2 - screenHeight/20, screenWidth/10, screenHeight/10);
                        repaint();
                        setVisible(true);
                    }
                    else {
                        //remove(spiderdactylLabel);
                        repaint();
                        setVisible(true);
                        return;
                    }
                }
                else {
                    if (spiderdactylLabel.getX() < (screenWidth/2 - screenWidth/20)) {
                        spiderdactylLabel.setBounds(spiderdactylLabel.getX() + screenWidth/100, screenHeight/2 - screenHeight/20, screenWidth/10, screenHeight/10);
                        repaint();
                        setVisible(true);
                    }
                    else {
                        //remove(spiderdactylLabel);
                        repaint();
                        setVisible(true);
                        return;
                    }
                }
            }
        }

        class VerticalMovement implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (direction == 2) {
                    if (spiderdactylLabel.getY() < (screenHeight/2 - screenHeight/20)) {
                        spiderdactylLabel.setBounds(screenWidth/2 - screenWidth/20, spiderdactylLabel.getY() + screenHeight/100, screenWidth/10, screenHeight/10);
                        repaint();
                        setVisible(true);
                    }
                    else {
                        //remove(spiderdactylLabel);
                        repaint();
                        setVisible(true);
                        return;
                    }
                }
                else {
                    if (spiderdactylLabel.getY() > (screenHeight/2 + screenHeight/20)) {
                        spiderdactylLabel.setBounds(screenWidth/2 - screenWidth/20, spiderdactylLabel.getY() - screenHeight/100, screenWidth/10, screenHeight/10);
                        repaint();
                        setVisible(true);
                    }
                    else {
                        //remove(spiderdactylLabel);
                        repaint();
                        setVisible(true);
                        return;
                    }
                }
            }
        }  
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            health = 0;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            
        }
    }

    public void keyTyped(KeyEvent e) {
        //nothing
    }

    public void keyReleased(KeyEvent e) {
        //nothing
    }
}