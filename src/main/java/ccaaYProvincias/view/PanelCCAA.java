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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelCCAA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelCCAA frame = new PanelCCAA();
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
	public PanelCCAA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGestinDeComunidades = new JLabel("Gestión de Comunidades Autónomas");
		lblGestinDeComunidades.setFont(new Font("Cascadia Code", Font.BOLD, 14));
		lblGestinDeComunidades.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_lblGestinDeComunidades = new GridBagConstraints();
		gbc_lblGestinDeComunidades.gridwidth = 2;
		gbc_lblGestinDeComunidades.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeComunidades.gridx = 0;
		gbc_lblGestinDeComunidades.gridy = 0;
		contentPane.add(lblGestinDeComunidades, gbc_lblGestinDeComunidades);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 3;
		contentPane.add(lblCdigo, gbc_lblCdigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setEnabled(false);
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 3;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(PanelCCAA.class.getResource("/ccaaYProvincias/res/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 9;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}

}
