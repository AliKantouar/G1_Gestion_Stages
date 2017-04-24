package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Action_Listener.AllerPage;
import Principal.Application;
import Principal.DAO;
import Principal.Postulation;

public class AccepterPostulation extends JButton implements ActionListener {

	
	GridBagConstraints gbc ;
	JPanel Pane;
	Postulation p;
	ListePostulation lp;
	Application a;
	String user;
	Icon Ent;
	public AccepterPostulation(String string, Postulation p,ListePostulation lp, Application a, String user)
	{
		this.p=p;
		this.lp=lp;
		this.a=a;
		this.user=user;
		this.setText(string);
		this.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		DAO.modifPostulation(p,true);
		
		
		
		//////////////////////////////////////////////////////////////////////////
		Pane = new JPanel();
		GridBagLayout grille = new GridBagLayout();
		 gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.insets=new Insets(10,10,10,10);
		Pane.setLayout(grille);
		gbc.gridy=0;
		Ent = new ImageIcon("ressources/post.jpg"); 
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
				Pane.add(new AccepterPostulation("Accepter",p,this.lp, a , user),gbc);
			}
			if(p.getEtat()!='F')
			{

				gbc.gridx++;
				Pane.add(new RefuserPostulation("Refuser",p, lp, a, user),gbc);
					
			}
		}
		
		Pane.validate();
		Pane.repaint();
		JScrollPane scrollPane = new JScrollPane(Pane);
		this.lp.panel2.removeAll();
		this.lp.panel2.add(scrollPane, BorderLayout.CENTER);
	
		
		this.lp.validate();
		this.lp.repaint();
	}
		
		

}
