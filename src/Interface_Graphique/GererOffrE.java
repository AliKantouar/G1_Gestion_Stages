package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Action_Listener.AllerPage;
import Action_Listener.Recherche;
import Principal.Application;
import Principal.DAO;
import Principal.Offres;

public class GererOffrE extends JPanel {
	
	
	private JTextField textField;
	private JTextField textField_1;
	Application a;
	JRadioButton rdbtnNewRadioButton_p;
	GridBagConstraints gbc ;
	JRadioButton rdbtnNewRadioButton_D;
	JRadioButton rdbtnNewRadioButtonE;

	JPanel Pane;
	JPanel panel_2;
	JScrollPane scrollPane;

	private int nbr = DAO.listeO().size();
	String user;
	
	public GererOffrE(Application a, String user )
	{
		this.a=a;
		this.a.setPreferredSize(new Dimension(800, 600));
		this.a.pack();
		this.a.setLocationRelativeTo(null);
		this.a.setVisible(true);
		this.user=user;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Liste des offres de Stage ("+this.getNbr()+") :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new AllerPage(this.a,11,user));
		panel_1.add(btnNewButton_1);
		
		panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{75, 65, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 128, 142, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		
		
		
	
		
		
	
	
		
		
		
		
		
			
		
		
		ArrayList<Offres> list=ListeOffres();
		afficherliste(list);
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public Application getA() {
		return a;
	}

	public void setA(Application a) {
		this.a = a;
	}

	public JRadioButton getRdbtnNewRadioButton_p() {
		return rdbtnNewRadioButton_p;
	}

	public void setRdbtnNewRadioButton_p(JRadioButton rdbtnNewRadioButton_p) {
		this.rdbtnNewRadioButton_p = rdbtnNewRadioButton_p;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public void setGbc(GridBagConstraints gbc) {
		this.gbc = gbc;
	}

	public JRadioButton getRdbtnNewRadioButton_D() {
		return rdbtnNewRadioButton_D;
	}

	public void setRdbtnNewRadioButton_D(JRadioButton rdbtnNewRadioButton_D) {
		this.rdbtnNewRadioButton_D = rdbtnNewRadioButton_D;
	}

	public JRadioButton getRdbtnNewRadioButtonE() {
		return rdbtnNewRadioButtonE;
	}

	public void setRdbtnNewRadioButtonE(JRadioButton rdbtnNewRadioButtonE) {
		this.rdbtnNewRadioButtonE = rdbtnNewRadioButtonE;
	}

	

	public JPanel getPane() {
		return Pane;
	}

	public void setPane(JPanel pane) {
		Pane = pane;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public int getNbr() {
		return nbr;
	}

	private ArrayList<Offres> ListeOffres() {
		// TODO Auto-generated method stub
		return DAO.listeO();
	}

	

	
	
	
	public void afficherliste(ArrayList<Offres> offres)
	{
		Pane = new JPanel();
		GridBagLayout grille = new GridBagLayout();
		 gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.insets=new Insets(10,10,10,10);
		Pane.setLayout(grille);
		gbc.gridy=0;
		Icon Ent = new ImageIcon("ressources/offres.jpg"); 
		
	for(int i = 0;i<offres.size();i++)
	{if(offres.get(i).getEnt().equals(user)){
		gbc.gridy=i;
		gbc.gridx=0;
		Offres o = offres.get(i);
		JLabel z = new JLabel(o.AfficherS());
		z.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		z.setIcon(Ent);
		Pane.add(z,gbc);
		gbc.gridx++;
		Pane.add(new SupprimerOffre("Supprimer", o, this),gbc);
	}}


	
	Pane.validate();
	Pane.repaint();
	
	gbc.gridy=1;
	gbc.gridx=0;
	scrollPane = new JScrollPane(Pane);
	panel_2.add(scrollPane, gbc);
	
	this.validate();
	this.repaint();
	
		
	}
	

}
