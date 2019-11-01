package insam;

import java.awt.*;
import javax.swing.*;

public class loadpage extends JFrame{
	JScrollPane scrollPane;
    ImageIcon icon;
    public loadpage() {
    	icon = new ImageIcon("images/load.jpg");
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
		}
    };
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    background.add(button1);
    background.add(button2);
    background.add(button3);
    background.add(button4);
    background.setLayout(null);
    button1.setBounds(490, 416, 100, 40);
    button2.setBounds(490, 466, 100, 40);
    button3.setBounds(490, 516, 100, 40);
    button4.setBounds(490, 566, 100, 40);
    

    scrollPane = new JScrollPane(background);
    setContentPane(scrollPane);
    }
}


