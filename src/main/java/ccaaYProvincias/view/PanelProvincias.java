package ccaaYProvincias.view;

import javax.swing.JPanel;
import ccaaYProvincias.controladores.ControladorCCAA;
import ccaaYProvincias.controladores.ControladorProvincia;
import ccaaYProvincias.entities.Ccaa;
import ccaaYProvincias.entities.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelProvincias extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCode;
	private JTextField jtfLabel;
	JComboBox<Ccaa> jcbCcaa;
	private JButton btnVerCcaa;
	private JButton btnGuardar;

	private PanelTabla panelTabla;
	
	public PanelTabla setPanelTabla(PanelTabla panelTabla) {
		return this.panelTabla = panelTabla;
	}
	

	/**
	 * Create the frame.
	 */
	public PanelProvincias() {
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{82, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		JLabel lblGestinDeProvincias = new JLabel("Gestión de provincias");
		lblGestinDeProvincias.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		GridBagConstraints gbc_lblGestinDeProvincias = new GridBagConstraints();
		gbc_lblGestinDeProvincias.gridwidth = 2;
		gbc_lblGestinDeProvincias.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeProvincias.gridx = 0;
		gbc_lblGestinDeProvincias.gridy = 0;
		add(lblGestinDeProvincias, gbc_lblGestinDeProvincias);
		
		JLabel lblCode = new JLabel("Code:");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 1;
		add(lblCode, gbc_lblCode);
		
		jtfCode = new JTextField();
		jtfCode.setEnabled(false);
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 1;
		add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblLabel = new JLabel("Label:");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.anchor = GridBagConstraints.EAST;
		gbc_lblLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 2;
		add(lblLabel, gbc_lblLabel);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 2;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JLabel lblCcaa = new JLabel("CCAA:");
		GridBagConstraints gbc_lblCcaa = new GridBagConstraints();
		gbc_lblCcaa.anchor = GridBagConstraints.EAST;
		gbc_lblCcaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCcaa.gridx = 0;
		gbc_lblCcaa.gridy = 3;
		add(lblCcaa, gbc_lblCcaa);
		
		jcbCcaa = new JComboBox<Ccaa>();
		GridBagConstraints gbc_jcbCcaa = new GridBagConstraints();
		gbc_jcbCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCcaa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCcaa.gridx = 1;
		gbc_jcbCcaa.gridy = 3;
		add(jcbCcaa, gbc_jcbCcaa);
		
		btnVerCcaa = new JButton("Ver CCAA");
		btnVerCcaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showJDialog();
			}
		});
		btnVerCcaa.setBackground(new Color(153, 193, 241));
		GridBagConstraints gbc_btnVerCcaa = new GridBagConstraints();
		gbc_btnVerCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerCcaa.gridwidth = 2;
		gbc_btnVerCcaa.gridx = 0;
		gbc_btnVerCcaa.gridy = 5;
		add(btnVerCcaa, gbc_btnVerCcaa);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelProvincias.class.getResource("/ccaaYProvincias/res/guardar.png")));
		btnGuardar.setSelectedIcon(null);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 7;
		add(btnGuardar, gbc_btnGuardar);
		
		loadAllCcaa();
		
	}
	
	public void loadAllCcaa() {
		
		this.jcbCcaa.removeAllItems();
		
		List<Ccaa> lista = (List<Ccaa>) ControladorCCAA
				.getInstance().getAllCcaa();
		for (Ccaa ccaa : lista) {
			this.jcbCcaa.addItem(ccaa);
		}
		
	}

	private void showJDialog() {
		
		JDialog dialogo = new JDialog();
		dialogo.setResizable(true);
		dialogo.setTitle("Gestión de usuario");
		dialogo.setContentPane(new PanelCCAA(this, panelTabla));
		dialogo.pack();
		dialogo.setModal(true);
		dialogo.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		dialogo.setVisible(true);
	}
	
	public void save() {
		
		Provincia p = new Provincia();
		
		// Guardamos todos los datos de Provincia del panel.
		p.setCode(this.jtfCode.getText());
		
		if (!this.jtfLabel.getText().isEmpty()) {
			p.setLabel(this.jtfLabel.getText());
		}else {
			JOptionPane.showMessageDialog(null,
					"Introduce una descripción");
			return;
		}
		
		p.setParent_code(((Ccaa)this.jcbCcaa.getSelectedItem()).getCode());
		
		// Guardamos los datos nuevos.
		ControladorProvincia.getInstance()
			.updateProvincia(p);
		
		// Actualizamos los datos de la tabla.
		// A continuación, seleccionamos en la tabla dicho registro.
		this.panelTabla.updateTable();
		this.panelTabla.selectRowByCode(this.jtfCode.getText());
		
		JOptionPane.showMessageDialog(null, 
				"La provincia ha sido actualizada");
	}
	
	public void muestraEnPantalla(Provincia p) {
		if (p != null) {
			this.jtfCode.setText(p.getCode());
			
			if (p.getLabel() != null) {
				this.jtfLabel.setText(p.getLabel());
			} else {
				this.jtfLabel.setText("");
			}
			
			for (int i = 0; i < this.jcbCcaa.getItemCount(); i++) {
				if (this.jcbCcaa.getItemAt(i).getCode()
						.equals(p.getParent_code())) {
					this.jcbCcaa.setSelectedIndex(i);
				}
			}
		}
	}


	public JTextField getJtfCode() {
		return jtfCode;
	}


	public void setJtfCode(JTextField jtfCode) {
		this.jtfCode = jtfCode;
	}
	
}
