package insam;

import java.awt.*;
import javax.swing.*;

public class chanepanel extends JFrame {
	public loadpage loadpage = null;
	public firstpage firstpage = null;

	public void changepage() {
		
		getContentPane().removeAll();
		getContentPane().add(loadpage);
		loadpage = new loadpage();
	
		setVisible(true);
		System.out.println(234);
}
}

