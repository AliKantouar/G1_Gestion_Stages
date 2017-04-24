package Interface_Graphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.DAO;
import Principal.Utilisateur;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;

public class CV extends JDialog implements ActionListener{


	public CV(String user) {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		Utilisateur a = DAO.UtilisateurViaId(user);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblCvDeMonsieur = new JLabel("<html><b><u>Cv de Monsieur :</b></u> "+a.getNom()+" "+a.getPrenom()+"</html>");
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
				gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 110, 110, 110, 100, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblTlphone = new JLabel("<html><b><u>T\u00E9l\u00E9phone :</b></u></html>");
					GridBagConstraints gbc_lblTlphone = new GridBagConstraints();
					gbc_lblTlphone.anchor = GridBagConstraints.NORTHEAST;
					gbc_lblTlphone.insets = new Insets(0, 0, 5, 5);
					gbc_lblTlphone.gridx = 0;
					gbc_lblTlphone.gridy = 0;
					panel_1.add(lblTlphone, gbc_lblTlphone);
				}
				{
					JLabel textPane = new JLabel();
					textPane.setText(a.getTel());
					GridBagConstraints gbc_textPane = new GridBagConstraints();
					gbc_textPane.insets = new Insets(0, 0, 5, 5);
					gbc_textPane.fill = GridBagConstraints.BOTH;
					gbc_textPane.gridx = 1;
					gbc_textPane.gridy = 0;
					panel_1.add(textPane, gbc_textPane);
				}
				{
					JLabel lblMail = new JLabel("<html><b><u>Mail :</b></u></html>");
					GridBagConstraints gbc_lblMail = new GridBagConstraints();
					gbc_lblMail.insets = new Insets(0, 0, 5, 5);
					gbc_lblMail.gridx = 2;
					gbc_lblMail.gridy = 0;
					panel_1.add(lblMail, gbc_lblMail);
				}
				{
					JLabel textPane = new JLabel();
					textPane.setText(a.getMail());
					GridBagConstraints gbc_textPane = new GridBagConstraints();
					gbc_textPane.insets = new Insets(0, 0, 5, 0);
					gbc_textPane.fill = GridBagConstraints.BOTH;
					gbc_textPane.gridx = 3;
					gbc_textPane.gridy = 0;
					panel_1.add(textPane, gbc_textPane);
				}
				{
					JLabel lblAdresse = new JLabel("<html><b><u>Adresse :</b></u></html>");
					GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
					gbc_lblAdresse.anchor = GridBagConstraints.NORTHEAST;
					gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
					gbc_lblAdresse.gridx = 0;
					gbc_lblAdresse.gridy = 1;
					panel_1.add(lblAdresse, gbc_lblAdresse);
				}
				{
					JLabel textPane = new JLabel();
					textPane.setText(a.getAdr());
					GridBagConstraints gbc_textPane = new GridBagConstraints();
					gbc_textPane.insets = new Insets(0, 0, 5, 0);
					gbc_textPane.anchor = GridBagConstraints.NORTH;
					gbc_textPane.gridwidth = 3;
					gbc_textPane.fill = GridBagConstraints.HORIZONTAL;
					gbc_textPane.gridx = 1;
					gbc_textPane.gridy = 1;
					panel_1.add(textPane, gbc_textPane);
				}
				{
					JLabel lblNewLabel = new JLabel("<html><b><u>Formation :</b></u></html>");
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
					gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel.gridx = 0;
					gbc_lblNewLabel.gridy = 2;
					panel_1.add(lblNewLabel, gbc_lblNewLabel);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridwidth = 3;
					gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
					gbc_scrollPane.gridx = 1;
					gbc_scrollPane.gridy = 2;
					panel_1.add(scrollPane, gbc_scrollPane);
					{
						JTextPane txtpn = new JTextPane();
						txtpn.setText(a.getFormation());
						scrollPane.setViewportView(txtpn);
						txtpn.setEditable(false);
					}
				}
				{
					JLabel lblNewLabel_1 = new JLabel("<html><b><u>Exp\u00E9riences :</b></u></html>");
					GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
					gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
					gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_1.gridx = 0;
					gbc_lblNewLabel_1.gridy = 3;
					panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridwidth = 3;
					gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
					gbc_scrollPane.gridx = 1;
					gbc_scrollPane.gridy = 3;
					panel_1.add(scrollPane, gbc_scrollPane);
					{
						JTextPane txtpn1 = new JTextPane();
						txtpn1.setText(a.getExp());
						scrollPane.setViewportView(txtpn1);
						txtpn1.setEditable(false);;
					}
				}
				{
					JLabel lblNewLabel_2 = new JLabel("<html><b><u>Comp\u00E9tences :</b></u></html>");
					GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
					gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHEAST;
					gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_2.gridx = 0;
					gbc_lblNewLabel_2.gridy = 4;
					panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridwidth = 3;
					gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
					gbc_scrollPane.gridx = 1;
					gbc_scrollPane.gridy = 4;
					panel_1.add(scrollPane, gbc_scrollPane);
					{
						JTextPane txtpn2 = new JTextPane();
						txtpn2.setText(a.getCompetence());
						scrollPane.setViewportView(txtpn2);
						txtpn2.setEditable(false);
					}
				}
				{
					JLabel lblNewLabel_3 = new JLabel("<html><b><u>Interets :</b></u></html>");
					GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
					gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
					gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
					gbc_lblNewLabel_3.gridx = 0;
					gbc_lblNewLabel_3.gridy = 5;
					panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					GridBagConstraints gbc_scrollPane = new GridBagConstraints();
					gbc_scrollPane.fill = GridBagConstraints.BOTH;
					gbc_scrollPane.gridwidth = 3;
					gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
					gbc_scrollPane.gridx = 1;
					gbc_scrollPane.gridy = 5;
					panel_1.add(scrollPane, gbc_scrollPane);
					{
						JTextPane txtpn3 = new JTextPane();
						txtpn3.setText(a.getInte());
						scrollPane.setViewportView(txtpn3);
						txtpn3.setEditable(false);
					}
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