package Interface_Graphique;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;

import Action_Listener.AllerPage;
import Action_Listener.Recherche;
import Principal.Application;
import Principal.DemoJdbc;
import Principal.Offres;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ListeCv extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	Application a;
	String user;
	JRadioButton rdbtnNewRadioButton_p;
	GridBagConstraints gbc ;
	JRadioButton rdbtnNewRadioButton_D;
	JRadioButton rdbtnNewRadioButtonE;
	JComboBox comboBox_1;
	JPanel Pane;
	JPanel panel_2;
	JScrollPane scrollPane;
	JComboBox comboBox;
	private int nbr = DemoJdbc.listeO().size();
	
	
	public JComboBox getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}


	public GridBagConstraints getGbc() {
		return gbc;
	}


	public void setGbc(GridBagConstraints gbc) {
		this.gbc = gbc;
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


	public JComboBox getComboBox_1() {
		return comboBox_1;
	}


	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}


	/**
	Enfaite c'est list des offres rien à voir avec les cvs
		 */
	public ListeCv(Application a, String user) {
		this.a=a;
		this.user=user;
		this.a.setPreferredSize(new Dimension(800, 600));
		this.a.pack();
		this.a.setLocationRelativeTo(null);
		this.a.setVisible(true);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Recherche d'offre de Stage ("+this.getNbr()+") :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Recherche");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Postuler");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new AllerPage(this.a,7,user));
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
		
		rdbtnNewRadioButtonE = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		panel_4.add(rdbtnNewRadioButtonE, gbc_rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("Entreprise :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		ArrayList<String> listE=DemoJdbc.liste();
		String[] liste = new String[listE.size()];
		for(int j=0;j<listE.size();j++)
		{
			liste[j]=listE.get(j);
		}
		comboBox = new JComboBox(liste);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		panel_4.add(comboBox, gbc_comboBox);
		
		rdbtnNewRadioButton_D = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton_D = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_D.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_D.gridx = 0;
		gbc_rdbtnNewRadioButton_D.gridy = 1;
		panel_4.add(rdbtnNewRadioButton_D, gbc_rdbtnNewRadioButton_D);
		
		JLabel lblDure = new JLabel("Dur\u00E9e(min/max) :");
		GridBagConstraints gbc_lblDure = new GridBagConstraints();
		gbc_lblDure.insets = new Insets(0, 0, 5, 5);
		gbc_lblDure.gridx = 1;
		gbc_lblDure.gridy = 1;
		panel_4.add(lblDure, gbc_lblDure);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		rdbtnNewRadioButton_p = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 2;
		panel_4.add(rdbtnNewRadioButton_p, gbc_rdbtnNewRadioButton_2);
		
		JLabel lblPoste = new JLabel("Poste:");
		GridBagConstraints gbc_lblPoste = new GridBagConstraints();
		gbc_lblPoste.insets = new Insets(0, 0, 0, 5);
		gbc_lblPoste.gridx = 1;
		gbc_lblPoste.gridy = 2;
		panel_4.add(lblPoste, gbc_lblPoste);
	
		
		ArrayList<String> listEo=DemoJdbc.listeP();
		
		String[] listeo = new String[listEo.size()];
		for(int j=0;j<listEo.size();j++)
		{
			listeo[j]=listEo.get(j);
		}
		
		
		comboBox_1 = new JComboBox(listeo);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		panel_4.add(comboBox_1, gbc_comboBox_1);
		btnNewButton.addActionListener(new Recherche(this));
			
		
		
		ArrayList<Offres> list=ListeOffres();
		afficherliste(list);
		
	}


	private int getNbr() {
		// TODO Auto-generated method stub
		return this.nbr;
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


	public JRadioButton getRdbtnNewRadioButton_p() {
		return rdbtnNewRadioButton_p;
	}


	public void setRdbtnNewRadioButton_p(JRadioButton rdbtnNewRadioButton_p) {
		this.rdbtnNewRadioButton_p = rdbtnNewRadioButton_p;
	}


	public JRadioButton getRdbtnNewRadioButton_D() {
		return rdbtnNewRadioButton_D;
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
		Icon Ent = new ImageIcon("ressources/Ent.png"); 
	
	
	for(int i = 0;i<offres.size();i++)
	{
		gbc.gridy=i;
		gbc.gridx=0;
		Offres o = offres.get(i);
		JLabel z = new JLabel(o.AfficherS());
		z.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		z.setIcon(Ent);
		Pane.add(z,gbc);
		gbc.gridx++;
		if(DemoJdbc.premierPostulation(user,o.getEnt(),o.poste(),o.getDur()))	
		{Pane.add(new Postuler("Postuler",offres.get(i),user),gbc);}
		else{Pane.add(new AnnulerPostulation("Postuler",offres.get(i),user),gbc);}


	}
	Pane.validate();
	Pane.repaint();
	
	gbc.gridy=1;
	gbc.gridx=0;
	scrollPane = new JScrollPane(Pane);
	panel_2.add(scrollPane, gbc);
	
	this.validate();
	this.repaint();
	
		
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


	private ArrayList<Offres> ListeOffres() {
		// TODO Auto-generated method stub
		return DemoJdbc.listeO();
	}

	private ArrayList<String> ListeEntreprises() {
		// TODO Auto-generated method stub
		return DemoJdbc.liste();
	}


	public void setNbr(int size) {
		// TODO Auto-generated method stub
		this.nbr =size;
	}


}