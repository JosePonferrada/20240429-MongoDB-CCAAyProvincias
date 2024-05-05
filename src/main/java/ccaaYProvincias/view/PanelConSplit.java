package ccaaYProvincias.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PanelConSplit extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelConSplit() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		splitPane.setResizeWeight(0.5);
		
		PanelProvincias panelProvincia = new PanelProvincias();
		splitPane.setRightComponent(panelProvincia);

		PanelTabla panelTabla = new PanelTabla(panelProvincia);
		splitPane.setLeftComponent(panelTabla);
		
		panelProvincia.setPanelTabla(panelTabla);
	}

}
