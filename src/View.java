import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class View extends JFrame implements Observer{
	
	//Constants
	private static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private static final GridLayout layout = new GridLayout(4,2);
	private static final String title = "Format Article Citations";
	private static final Dimension dimension = new Dimension(400,200);
	private static final String firstNameLabel = "First Name";
	private static final String LastNameLabel = "Last Name";
	private static final String firstOptionButton = "IEEE"; 
	private static final String secondOptionButton = "ACM";
	private static final String submitButtonString = "Submit!";
	private static final String INVALID_INPUT_MESSAGE = "Invalid Input! \nPlease fix and resubmit.";
	
	//Layout Items
	private JTextField firstText;
	private JTextField secondText;
	private JRadioButton firstOption;
	private JRadioButton secondOption;
	private JTextArea outputArea;
	private JButton submitButton;
	
	public View() {
		super(title);
		setLayout(layout);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		makeLayout();
		
		
		pack();
		setSize(dimension);
		setLocation(screen.width/2 - getWidth()/2,screen.height/2 - getHeight()/2);
		setVisible(true);
	}

	private void makeLayout() {
		JLabel first = new JLabel(firstNameLabel);
		add(first);
		
		firstText = new JTextField();
		add(firstText);
		
		JLabel last = new JLabel(LastNameLabel);
		add(last);
		
		secondText = new JTextField();
		add(secondText);
		
		firstOption = new JRadioButton(firstOptionButton);
		add(firstOption);
		
		secondOption = new JRadioButton(secondOptionButton);
		add(secondOption);
		
		ButtonGroup group = new ButtonGroup();
		group.add(firstOption);
		group.add(secondOption);
		
		outputArea = new JTextArea();
		add(outputArea);
		
		submitButton = new JButton(submitButtonString);
		submitButton.setActionCommand(submitButtonString);
		add(submitButton);
	}

	@Override
	public void update(Observable o, Object arg){
		outputArea.setText("" +(String)arg);
	}
	
	public boolean isFirstOption(){
		return firstOption.isSelected();
	}
	
	public boolean isSecondOption(){
		return secondOption.isSelected();
	}

	public String getFirstText() {
		return firstText.getText();
	}

	public String getSecondText() {
		return secondText.getText();
	}

	public void setController(Controller controller) {
		submitButton.addActionListener(controller);
	}
	
	public void popUpError(){
		outputArea.setText("");
		JOptionPane.showMessageDialog(this,
				INVALID_INPUT_MESSAGE,
				"WARNING",
				JOptionPane.ERROR_MESSAGE);
	}
}
