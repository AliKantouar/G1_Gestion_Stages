package Interface_Graphique;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class Erreur extends JDialog {

	
	public Erreur(String message) {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setBounds(100, 100, 450, 173);
		getContentPane().setLayout(new BorderLayout());
		
		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setIcon(new ImageIcon("ressources\\error.jpg"));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
	
	
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
