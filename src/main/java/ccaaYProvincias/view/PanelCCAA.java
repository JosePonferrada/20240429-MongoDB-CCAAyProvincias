package ccaaYProvincias.view;

import javax.swing.JPanel;
import ccaaYProvincias.controladores.ControladorCCAA;
import ccaaYProvincias.entities.Ccaa;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCCAA extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;

	private PanelTabla panelTabla;
	private PanelProvincias panelProvincias;
	private Ccaa ccaa;
	

	/**
	 * Create the frame.
	 */
	public PanelCCAA(PanelProvincias panelProvincias, PanelTabla panelTabla) {
		
		this.panelProvincias = panelProvincias;
		this.panelTabla = panelTabla;
		
		this.ccaa = (Ccaa) this.panelProvincias.jcbCcaa.getSelectedItem();
		
		
		setBounds(100, 100, 450, 300);
				
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		JLabel lblGestinDeComunidades = new JLabel("Gestión de Comunidades Autónomas");
		lblGestinDeComunidades.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		lblGestinDeComunidades.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_lblGestinDeComunidades = new GridBagConstraints();
		gbc_lblGestinDeComunidades.gridwidth = 2;
		gbc_lblGestinDeComunidades.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeComunidades.gridx = 0;
		gbc_lblGestinDeComunidades.gridy = 0;
		add(lblGestinDeComunidades, gbc_lblGestinDeComunidades);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 3;
		add(lblCdigo, gbc_lblCdigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setEnabled(false);
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 3;
		add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelCCAA.class.getResource("/ccaaYProvincias/res/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 9;
		add(btnGuardar, gbc_btnGuardar);
		
		
		showInfo();
	}
	
	private void save() {
		Ccaa c = new Ccaa();
		c.setCode(this.jtfCodigo.getText());
		
		if (!this.jtfNombre.getText().isEmpty()) {
			c.setLabel(this.jtfNombre.getText());
		} else {
			JOptionPane.showMessageDialog(null,
					"El nombre no puede estar vacío");;
			return;
		}
		// Guardamos el parent_code del CCAA aunque 
		// no aparezca en pantalla.
		c.setParent_code(ccaa.getParent_code());
		
		ControladorCCAA.getInstance().updateCCAA(c);
		
		updatePanelPrincipal();
		
		JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
	}
	
	private void updatePanelPrincipal() {
		
		this.panelTabla.updateTable();
		this.panelProvincias.loadAllCcaa();
		
		String code = this.panelProvincias.getJtfCode().getText();
		
		this.panelTabla.selectRowByCode(code);
	}

	private void showInfo() {
		this.jtfCodigo.setText(ccaa.getCode());
		if (!ccaa.getLabel().isEmpty()) {
			this.jtfNombre.setText(ccaa.getLabel());
		} else {
			this.jtfNombre.setText("");
		}
	}
	
}
