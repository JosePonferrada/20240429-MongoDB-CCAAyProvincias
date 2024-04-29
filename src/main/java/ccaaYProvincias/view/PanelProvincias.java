package ccaaYProvincias.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PanelProvincias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfCode;
	private JTextField jtfLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelProvincias frame = new PanelProvincias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelProvincias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{82, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGestinDeProvincias = new JLabel("Gestión de provincias");
		lblGestinDeProvincias.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		GridBagConstraints gbc_lblGestinDeProvincias = new GridBagConstraints();
		gbc_lblGestinDeProvincias.gridwidth = 2;
		gbc_lblGestinDeProvincias.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeProvincias.gridx = 0;
		gbc_lblGestinDeProvincias.gridy = 0;
		contentPane.add(lblGestinDeProvincias, gbc_lblGestinDeProvincias);
		
		JLabel lblCode = new JLabel("Code:");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 1;
		contentPane.add(lblCode, gbc_lblCode);
		
		jtfCode = new JTextField();
		jtfCode.setEnabled(false);
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 1;
		contentPane.add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblLabel = new JLabel("Label:");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.anchor = GridBagConstraints.EAST;
		gbc_lblLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 2;
		contentPane.add(lblLabel, gbc_lblLabel);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 2;
		contentPane.add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JLabel lblCcaa = new JLabel("CCAA:");
		GridBagConstraints gbc_lblCcaa = new GridBagConstraints();
		gbc_lblCcaa.anchor = GridBagConstraints.EAST;
		gbc_lblCcaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCcaa.gridx = 0;
		gbc_lblCcaa.gridy = 3;
		contentPane.add(lblCcaa, gbc_lblCcaa);
		
		JComboBox jcbCcaa = new JComboBox();
		GridBagConstraints gbc_jcbCcaa = new GridBagConstraints();
		gbc_jcbCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCcaa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCcaa.gridx = 1;
		gbc_jcbCcaa.gridy = 3;
		contentPane.add(jcbCcaa, gbc_jcbCcaa);
		
		JButton btnVerCcaa = new JButton("Ver CCAA");
		btnVerCcaa.setBackground(new Color(153, 193, 241));
		GridBagConstraints gbc_btnVerCcaa = new GridBagConstraints();
		gbc_btnVerCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerCcaa.gridwidth = 2;
		gbc_btnVerCcaa.gridx = 0;
		gbc_btnVerCcaa.gridy = 5;
		contentPane.add(btnVerCcaa, gbc_btnVerCcaa);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(PanelProvincias.class.getResource("/ccaaYProvincias/res/guardar.png")));
		btnGuardar.setSelectedIcon(null);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 7;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}

}
