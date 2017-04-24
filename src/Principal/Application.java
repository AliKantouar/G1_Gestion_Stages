package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import Interface_Graphique.choix;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Application extends JFrame {

	 choix choix = new choix();



	 
	public Application() {
		this.setResizable(false);
		this.setVisible(true);
		

		choix = new choix(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(choix);
	}

	
	
}
