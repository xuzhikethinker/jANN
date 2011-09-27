/**
 * Projekt ANNtool 
 *
 * Copyright (c) 2011 github.com/timaschew/jANN
 * 
 * anton
 */
package de.unikassel.ann.gui.sidebar;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 * @author anton
 * 
 */
public class Sidebar extends JPanel {

	private static final long serialVersionUID = 3451251923560791391L;
	public TopologyPanel topolgyPanel;
	public TrainStrategyPanel trainStrategyPanel;
	public StandardOptionsPanel standardOptionsPanel;
	public SelectedSymbolPanel selectedSymbolsPanel;
	public WorkPanel manualTestPanel;

	/**
	 * Create the panel.
	 */
	public Sidebar() {
		setLayout(new BorderLayout());
		setSize(412, 800);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBorder(null);
		add(tabbedPane);

		JPanel wrapper = new JPanel();
		GridBagLayout gbl_wrapper = new GridBagLayout();
		gbl_wrapper.columnWidths = new int[] { 412, 0 };
		gbl_wrapper.rowHeights = new int[] { 339, 350, 90, 224, 160 };
		gbl_wrapper.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_wrapper.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		wrapper.setLayout(gbl_wrapper);

		// topology Panel
		topolgyPanel = new TopologyPanel(this);
		GridBagConstraints gbc_topolgyPanel = new GridBagConstraints();
		gbc_topolgyPanel.anchor = GridBagConstraints.NORTH;
		gbc_topolgyPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_topolgyPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topolgyPanel.gridx = 0;
		gbc_topolgyPanel.gridy = 0;
		wrapper.add(topolgyPanel, gbc_topolgyPanel);
		// Trainstrategy Panel
		trainStrategyPanel = new TrainStrategyPanel();
		GridBagConstraints gbc_trainStrategyPanel = new GridBagConstraints();
		gbc_trainStrategyPanel.anchor = GridBagConstraints.NORTH;
		gbc_trainStrategyPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_trainStrategyPanel.insets = new Insets(0, 0, 5, 0);
		gbc_trainStrategyPanel.gridx = 0;
		gbc_trainStrategyPanel.gridy = 1;
		wrapper.add(trainStrategyPanel, gbc_trainStrategyPanel);
		// Standardoption Panel
		standardOptionsPanel = new StandardOptionsPanel();
		GridBagConstraints gbc_standardOptionsPanel = new GridBagConstraints();
		gbc_standardOptionsPanel.anchor = GridBagConstraints.NORTH;
		gbc_standardOptionsPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_standardOptionsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_standardOptionsPanel.gridx = 0;
		gbc_standardOptionsPanel.gridy = 2;
		wrapper.add(standardOptionsPanel, gbc_standardOptionsPanel);
		// selectedSymbol Panel
		selectedSymbolsPanel = new SelectedSymbolPanel();
		GridBagConstraints gbc_selectedSymbolsPanel = new GridBagConstraints();
		gbc_selectedSymbolsPanel.anchor = GridBagConstraints.NORTH;
		gbc_selectedSymbolsPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectedSymbolsPanel.gridx = 0;
		gbc_selectedSymbolsPanel.gridy = 3;
		wrapper.add(selectedSymbolsPanel, gbc_selectedSymbolsPanel);

		JScrollPane scrollPane = new JScrollPane(wrapper);
		scrollPane.getVerticalScrollBar().setUnitIncrement(100);

		JPanel trainTabPanel = new JPanel();

		JScrollPane scrollPaneTrain = new JScrollPane(trainTabPanel);
		GridBagLayout gbl_trainTabPanel = new GridBagLayout();
		gbl_trainTabPanel.columnWidths = new int[] { 407, 0 };
		gbl_trainTabPanel.rowHeights = new int[] { 235, 350, 0 };
		gbl_trainTabPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_trainTabPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		trainTabPanel.setLayout(gbl_trainTabPanel);

		TrainControlPanel trainControlPanel = new TrainControlPanel();
		GridBagConstraints gbc_trainControlPanel = new GridBagConstraints();
		gbc_trainControlPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_trainControlPanel.insets = new Insets(0, 0, 5, 0);
		gbc_trainControlPanel.gridx = 0;
		gbc_trainControlPanel.gridy = 0;
		trainTabPanel.add(trainControlPanel, gbc_trainControlPanel);

		manualTestPanel = new WorkPanel();
		GridBagConstraints gbc_manualTestPanel = new GridBagConstraints();
		gbc_manualTestPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_manualTestPanel.anchor = GridBagConstraints.NORTH;
		gbc_manualTestPanel.insets = new Insets(0, 0, 5, 0);
		gbc_manualTestPanel.gridx = 0;
		gbc_manualTestPanel.gridy = 1;
		trainTabPanel.add(manualTestPanel, gbc_manualTestPanel);
		scrollPaneTrain.getVerticalScrollBar().setUnitIncrement(100);

		tabbedPane.addTab("Konfiguration", null, scrollPane, null);
		tabbedPane.addTab("Training", null, scrollPaneTrain, null);

	}
}
