

package Interface_Graphique;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import Action_Listener.AjouterE;
import Action_Listener.AllerPage;
import Action_Listener.ModifierCV;
import Action_Listener.ModifierEntreprise;
import Principal.Application;
import Principal.DemoJdbc;

import javax.swing.JTextArea;

public class modifEnt extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea ;
	Application a;
	String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Application getA() {
		return a;
	}
	public void setA(Application a) {
		this.a = a;
	}
	
	/**
	 * Create the panel.
	 */
	public modifEnt(Application a,String user) {
		// TODO Auto-generated constructor stub
		this.a=a;
		this.user=user;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Ajouter une Entreprise");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ModifierEntreprise(this.a,this,user));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new AllerPage(this.a,11));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{115, 30, 46, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 7, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00E9l\u00E9phonne :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_2.add(textField, gbc_textField_3);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Addresse :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_2.add(textField_1, gbc_textField_2);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Commentaires :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridwidth = 5;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		panel_2.add(textArea, gbc_textArea);
		
		DemoJdbc.initModifEnt(this);
		
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


	public JTextArea getTextArea() {
		return textArea;
	}



	public void setTextArea(JTextArea textArea) {
		this.textArea= textArea;
	}




	
	}

