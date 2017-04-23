package Interface_Graphique;

import javax.swing.JPanel;

import Action_Listener.AllerPage;
import Principal.Application;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListePostulation extends JPanel {

	/**
	 * Create the panel.
	 */
	Application a ;
	String user ;
	public ListePostulation(Application a , String user) {
		this.a=a;
		this.user=user;
		this.a.setPreferredSize(new Dimension(800, 600));
		this.a.pack();
		this.a.setLocationRelativeTo(null);
		this.a.setVisible(true);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblListeDesCandidatures = new JLabel("Liste des Candidatures :");
		panel.add(lblListeDesCandidatures);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new AllerPage(this.a,11));
		panel_1.add(btnNewButton);

	}

}
