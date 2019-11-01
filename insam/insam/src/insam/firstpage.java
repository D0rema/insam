package insam;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionListener;
public class firstpage extends JFrame{
	private chanepanel cp;
	JScrollPane scrollPane;
    ImageIcon icon;
    public firstpage() {
    	icon = new ImageIcon("images/start.jpg");
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
		}
    };
    JButton button1 = new JButton("새로하기");
    JButton button2 = new JButton("불러오기");
    JButton button3 = new JButton("설정");
    JButton button4 = new JButton("종료");
    background.add(button1);
    background.add(button2);
    background.add(button3);
    background.add(button4);
    background.setLayout(null);
    button1.setBounds(490, 416, 100, 40);
    button2.setBounds(490, 466, 100, 40);
    button3.setBounds(490, 516, 100, 40);
    button4.setBounds(490, 566, 100, 40);
 
    
    button1.addActionListener(new MyActionListener());
    scrollPane = new JScrollPane(background);
    setContentPane(scrollPane);
    cp= new chanepanel();
    }
    
     class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cp.changepage();
	
		}
    };
}


