package Interface_Graphique;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

public class ErreurConnexion extends JDialog {

	/**
	 * Create the dialog.
	 */
	public ErreurConnexion() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setBounds(100, 100, 450, 92);
		getContentPane().setLayout(new BorderLayout());
		{
			JTextPane txtpnMotDePasse = new JTextPane();
			txtpnMotDePasse.setForeground(Color.RED);
			txtpnMotDePasse.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 24));
			txtpnMotDePasse.setEditable(false);
			getContentPane().add(txtpnMotDePasse, BorderLayout.CENTER);
			txtpnMotDePasse.setText("Mot de passe incorrect ou nom d'utilisateur inconnu");
		}
	
	
		try {
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
