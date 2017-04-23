package Principal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interface_Graphique.PanneauAdmin;
import Interface_Graphique.choix;

public class Application extends JFrame {

	 choix choix = new choix();
	 PanneauAdmin panneauA = new PanneauAdmin();
	 DemoJdbc jd = new DemoJdbc();

	 
	public Application() {
		this.setResizable(false);
		this.setVisible(true);
		
		panneauA = new PanneauAdmin(this);
		choix = new choix(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(choix);
	}

	
	
}
