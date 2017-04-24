package Interface_Graphique;

import javax.swing.JPanel;

import Action_Listener.AllerPage;
import Principal.Application;
import Principal.DAO;
import Principal.Offres;
import Principal.Postulation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JScrollPane;

public class ListePostulation extends JPanel {

	/**
	 * Create the panel.
	 */
	GridBagConstraints gbc ;
	JPanel Pane;
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
		lblListeDesCandidatures.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(lblListeDesCandidatures);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new AllerPage(this.a,11,user));
		panel_1.add(btnNewButton);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout(0, 0));
		add(panel2, BorderLayout.CENTER);
		
		Pane = new JPanel();
		GridBagLayout grille = new GridBagLayout();
		 gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.insets=new Insets(10,10,10,10);
		Pane.setLayout(grille);
		gbc.gridy=0;
		Icon Ent = new ImageIcon("ressources/Ent.png"); 
		ArrayList<Postulation> postulations = DAO.listePostulation(user);
		
		for(int i = 0;i<postulations.size();i++)
		{
			
			gbc.gridy=i;
			gbc.gridx=0;
			Postulation p = postulations.get(i);
			JLabel z = new JLabel(p.AfficherS());
			z.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
			z.setIcon(Ent);
			Pane.add(z,gbc);
			gbc.gridx++;
		//	Pane.add(new JButton("Accepter"),gbc);
			Pane.add(new VoirCV("Voir CV",p.getUser()),gbc);
			if(p.getEtat()=='F'||p.getEtat()=='A')
			{
				gbc.gridx++;
				Pane.add(new AccepterPostulation("Accepter",p),gbc);
			}
			if(p.getEtat()!='F')
			{

				gbc.gridx++;
				Pane.add(new RefuserPostulation("Refuser",p),gbc);
					
			}
		}
		
		Pane.validate();
		Pane.repaint();
		
		
		JScrollPane scrollPane = new JScrollPane(Pane);
		panel2.add(scrollPane, BorderLayout.CENTER);
	
		
		this.validate();
		this.repaint();
	}

}
