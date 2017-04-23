package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.DemoJdbc;
import Principal.Utilisateur;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class CV extends JDialog implements ActionListener{

	public CV(String user) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		Utilisateur a = DemoJdbc.UtilisateurViaId(user);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblCvDeMonsieur = new JLabel("Cv de Monsieur : "+a.getNom()+" "+a.getPrenom()+"");
				lblCvDeMonsieur.setFont(new Font("Tahoma", Font.BOLD, 17));
				panel.add(lblCvDeMonsieur);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
			{
				JButton btnRetour = new JButton("Retour");
				btnRetour.addActionListener(this);
				panel.add(btnRetour);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 0);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
					GridBagConstraints gbc_lblTlphone = new GridBagConstraints();
					gbc_lblTlphone.insets = new Insets(0, 0, 5, 5);
					gbc_lblTlphone.gridx = 1;
					gbc_lblTlphone.gridy = 0;
					panel_1.add(lblTlphone, gbc_lblTlphone);
				}
				{
					JLabel textPane = new JLabel();
					textPane.setText(a.getTel());
					GridBagConstraints gbc_textPane = new GridBagConstraints();
					gbc_textPane.insets = new Insets(0, 0, 5, 5);
					gbc_textPane.fill = GridBagConstraints.BOTH;
					gbc_textPane.gridx = 2;
					gbc_textPane.gridy = 0;
					panel_1.add(textPane, gbc_textPane);
				}
				{
					JLabel lblMail = new JLabel("Mail :");
					GridBagConstraints gbc_lblMail = new GridBagConstraints();
					gbc_lblMail.insets = new Insets(0, 0, 5, 5);
					gbc_lblMail.gridx = 3;
					gbc_lblMail.gridy = 0;
					panel_1.add(lblMail, gbc_lblMail);
				}
				{
					JLabel textPane = new JLabel();
					textPane.setText(a.getTel());
					GridBagConstraints gbc_textPane = new GridBagConstraints();
					gbc_textPane.insets = new Insets(0, 0, 5, 0);
					gbc_textPane.fill = GridBagConstraints.BOTH;
					gbc_textPane.gridx = 4;
					gbc_textPane.gridy = 0;
					panel_1.add(textPane, gbc_textPane);
				}
				{
					JLabel lblAdresse = new JLabel("Adresse :");
					GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
					gbc_lblAdresse.insets = new Insets(0, 0, 0, 5);
					gbc_lblAdresse.gridx = 1;
					gbc_lblAdresse.gridy = 1;
					panel_1.add(lblAdresse, gbc_lblAdresse);
				}
				{
					JLabel textPane = new JLabel();
					textPane.setText(a.getAdr());
					GridBagConstraints gbc_textPane = new GridBagConstraints();
					gbc_textPane.gridwidth = 3;
					gbc_textPane.insets = new Insets(0, 0, 0, 5);
					gbc_textPane.fill = GridBagConstraints.BOTH;
					gbc_textPane.gridx = 2;
					gbc_textPane.gridy = 1;
					panel_1.add(textPane, gbc_textPane);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 1;
				panel.add(panel_1, gbc_panel_1);
			}
		}
	}

	
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
		
	}

}
