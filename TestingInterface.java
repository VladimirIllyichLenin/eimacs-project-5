package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TestingInterface implements ActionListener {
	private JPanel mainPanel, mySetupPanel, myRunPanel, myResultsPanel;
	@SuppressWarnings("rawtypes")
	private JComboBox mySortChoices;
	private JTextField arrSizeField, nTestsField;
	private JTextArea results;
	final String[] SORT_ALGORITHMS = { "Choose one...", "Selection",
			"Insertion", "Merge" };

	// Class constructor
	public TestingInterface() {
		// create sub-panels of main panel
		mySetupPanel = new JPanel(new GridLayout(3, 2, 6, 6));
		myRunPanel = new JPanel();
		myResultsPanel = new JPanel();
		// add widgets to sub-panels
		addWidgets();
		// create main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		// add sub-panels and horizontal separators to main panel
		mainPanel.add(mySetupPanel);
		mainPanel.add(new JSeparator());
		mainPanel.add(myRunPanel);
		mainPanel.add(new JSeparator());
		mainPanel.add(myResultsPanel);
		// create the tester window and display it
		JFrame testerFrame = new JFrame("Sort Algorithm Tester");
		testerFrame.setContentPane(mainPanel);
		testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testerFrame.pack();
		testerFrame.setLocation(50, 50);
		testerFrame.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void addWidgets() {
		// labels for the setup panel
		String[] labels = { "Sorting algorithm: ", "ArrayList size: ",
				"Number of tests: " };
		// create combo box with sorting algorithm choices
		mySortChoices = new JComboBox(SORT_ALGORITHMS);
		mySortChoices.setSelectedIndex(0);
		/*
		 * create label for combo box; add label and combo box to mySetupPanel;
		 * activate a listener for the combo box
		 */
		JLabel sortChoicesLabel = new JLabel(labels[0], JLabel.TRAILING);
		mySetupPanel.add(sortChoicesLabel);
		sortChoicesLabel.setLabelFor(mySortChoices);
		mySetupPanel.add(mySortChoices);
		mySortChoices.addActionListener(this);
		/*
		 * create label and text field to specify ArrayList size; add label and
		 * text field to mySetupPanel; activate a listener for the text field
		 */
		JLabel arrSizeLabel = new JLabel(labels[1], JLabel.TRAILING);
		mySetupPanel.add(arrSizeLabel);
		arrSizeField = new JTextField(6);
		arrSizeLabel.setLabelFor(arrSizeField);
		mySetupPanel.add(arrSizeField);
		arrSizeField.addActionListener(this);
		/*
		 * create label and text field to specify number of tests; add label and
		 * text field to mySetupPanel; activate a listener for the text field
		 */
		JLabel arrTimes = new JLabel(labels[2], JLabel.TRAILING);
		mySetupPanel.add(arrTimes);
		nTestsField = new JTextField(6);
		arrTimes.setLabelFor(nTestsField);
		mySetupPanel.add(nTestsField);
		nTestsField.addActionListener(this);
		mySetupPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		/*
		 * create a button for the run panel, add it to myRunPanel, and activate
		 * a listener for it
		 */
		JButton runBtn = new JButton("Run tests");
		myRunPanel.add(runBtn);
		runBtn.addActionListener(this);
		// mySetupPanel.setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 )
		// );
		/*
		 * create a text area for the results panel and add it to myResultsPanel
		 */
		results = new JTextArea(2, 20);
		myResultsPanel.add(results);
	}

	public void actionPerformed(ActionEvent e) {
		String actionName = e.getActionCommand();
		// erase myResultsPanel upon each action on the interface
		results.setText("");
		// If Run tests button has been clicked...
		if ("Run tests".equals(actionName)) {
			// read user input
			String algoName = (String) mySortChoices.getSelectedItem();
			String arrSizeStr = arrSizeField.getText();
			String nTestsStr = nTestsField.getText();
			// run the tests and display the result
			int arrSize = Integer.parseInt(arrSizeStr);
			int nTests = Integer.parseInt(nTestsStr);
			String report = runTests(algoName, nTests, arrSize);
			results.setText(report);
		}
	}

	public String runTests(String algoName, int nTests, int arrSize) {
		APTimer timer = new APTimer();
		ArrayList<ArrayList<Integer>> list = SortingTest.arrayListOfArrayList(
				nTests, arrSize);
		Sort sort;
		if (algoName.equals("Selection")) {
			sort = new SelectionSort();
		} else if (algoName.equals("Insertion")) {
			sort = new InsertionSort();
		} else {
			sort = new MergeSort();
		}

		timer.start();

		for (ArrayList<Integer> x : list) {
			sort.sortList(x);
		}

		timer.stop();

		return Double.parseDouble(timer.toString()) / 1000
				+ " seconds for a Selection Sort";
	}
}
