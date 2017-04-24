package Interface_Graphique;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Action_Listener.AllerPage;
import Action_Listener.ModifierCV;
import Principal.Application;
import Principal.DAO;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class modifCV extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
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
	Application a;
	private JTextField textField_4;
	/**
	 * Create the panel.
	 */
	public modifCV(Application a,String user) {
		this.a=a;
		this.user=user;
		this.a.setPreferredSize(new Dimension(800, 600));
		this.a.pack();
		this.a.setLocationRelativeTo(null);
		this.a.setVisible(true);
		setLayout(new BorderLayout(0, 0));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{41, 226, 33, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel lblNewLabel = new JLabel("Modification CV :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 53, 0, 69, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 46, 52, 64, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E9l\u00E9phonne :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 1;
		panel_2.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 2;
		gbc_lblAdresse.gridy = 1;
		panel_2.add(lblAdresse, gbc_lblAdresse);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 1;
		panel_2.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mail :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFormation = new JLabel("Formation :");
		GridBagConstraints gbc_lblFormation = new GridBagConstraints();
		gbc_lblFormation.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFormation.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormation.gridx = 0;
		gbc_lblFormation.gridy = 3;
		panel_2.add(lblFormation, gbc_lblFormation);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblComptences = new JLabel("Comp\u00E9tences :");
		GridBagConstraints gbc_lblComptences = new GridBagConstraints();
		gbc_lblComptences.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblComptences.insets = new Insets(0, 0, 5, 5);
		gbc_lblComptences.gridx = 0;
		gbc_lblComptences.gridy = 4;
		panel_2.add(lblComptences, gbc_lblComptences);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 4;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblExprience = new JLabel("Exp\u00E9rience :");
		GridBagConstraints gbc_lblExprience = new GridBagConstraints();
		gbc_lblExprience.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblExprience.insets = new Insets(0, 0, 5, 5);
		gbc_lblExprience.gridx = 0;
		gbc_lblExprience.gridy = 5;
		panel_2.add(lblExprience, gbc_lblExprience);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 5;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);
		
		textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JLabel lblDescriptio = new JLabel("Interets:");
		GridBagConstraints gbc_lblDescriptio = new GridBagConstraints();
		gbc_lblDescriptio.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescriptio.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescriptio.gridx = 0;
		gbc_lblDescriptio.gridy = 6;
		panel_2.add(lblDescriptio, gbc_lblDescriptio);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridwidth = 3;
		gbc_scrollPane_3.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 6;
		panel_2.add(scrollPane_3, gbc_scrollPane_3);
		
		textArea_3 = new JTextArea();
		scrollPane_3.setViewportView(textArea_3);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		JButton btnNewButton = new JButton("Valider");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ModifierCV(this.a,this,user));
		
		
		JButton btnNewButton_1 = new JButton("Retour");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new AllerPage(this.a,7,user));
	
		DAO.initModifCV(this);
		
	
	
	}
	public JTextField getTextField_4() {
		return textField_4;
	}
	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JTextArea getTextArea_1() {
		return textArea_1;
	}
	public void setTextArea_1(JTextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}
	public JTextArea getTextArea_2() {
		return textArea_2;
	}
	public void setTextArea_2(JTextArea textArea_2) {
		this.textArea_2 = textArea_2;
	}
	public JTextArea getTextArea_3() {
		return textArea_3;
	}
	public void setTextArea_3(JTextArea textArea_3) {
		this.textArea_3 = textArea_3;
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
	public JTextField getTextField_2() {
		return textField_2;
	}
	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
}
