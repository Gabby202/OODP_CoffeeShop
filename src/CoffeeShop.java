import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
public class CoffeeShop extends JFrame implements ActionListener{
	
	JButton teaButton, latteButton, cappButton, mochaButton, submitTea;
	JPanel optionSelectPanel, cardTeaPanel, cardLattePanel; //global because it uses actionPerformed to know which options to show
	JRadioButton milkRadioButton, blackRadioButton, skinnyLatteRadioButton, soyLatteRadioButton, decaffLatteRadioButton;
	Tea tea;
	JLabel outputLabel, ingredientsLabel;
	JLabel teaImage, latteImage;
	private CoffeeFactory coffeeFactory = new Latte();
	
	public CoffeeShop() {
		Container c = getContentPane();
		
		//Panel declarations
		JPanel mainContentPanel = new JPanel(); //panel to hold all panels
		JPanel leftPanel = new JPanel(); //panel to hold left buttons
 		JPanel rightPanel = new JPanel(); //panel to hold right content (output)
 		
 		optionSelectPanel = new JPanel(); //panel where user clicks options for drink
 		JPanel outputPanel = new JPanel(); //panel to show finished drink
 
 		//button declarations
 		teaButton = new JButton("Tea");
 		latteButton = new JButton("Latte");
 		cappButton = new JButton("Cappuccino");
 		mochaButton = new JButton("Mocha");
 		
 		//label declarations
 		outputLabel = new JLabel();
 		ingredientsLabel = new JLabel();
 		teaImage = new JLabel();
 		latteImage = new JLabel();
 		//panel modifiers
 		mainContentPanel.setLayout(new BorderLayout());
 		leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
 		rightPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
 		leftPanel.setPreferredSize(new Dimension(200, 600));
 		leftPanel.setLayout(new GridLayout(4,1));
 		rightPanel.setBackground(Color.DARK_GRAY);
 		leftPanel.setBackground(Color.DARK_GRAY);
 		rightPanel.setLayout(new GridLayout(2,1));
 		outputPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
 		outputPanel.setLayout(new BorderLayout());
 		optionSelectPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
 		optionSelectPanel.setLayout(new CardLayout());
 		c.setBackground(Color.DARK_GRAY);
 		outputPanel.add(outputLabel, BorderLayout.NORTH);
 		outputPanel.add(ingredientsLabel, BorderLayout.SOUTH);
 		outputPanel.add(teaImage, BorderLayout.CENTER);
 		

 		//button modifiers
 		formatButton(teaButton);
 		formatButton(latteButton);
 		formatButton(cappButton);
 		formatButton(mochaButton);
 		
 		//add components to panels
		mainContentPanel.add(leftPanel, BorderLayout.WEST);
		mainContentPanel.add(rightPanel, BorderLayout.CENTER);
 		leftPanel.add(teaButton);
 		leftPanel.add(latteButton);
 		leftPanel.add(cappButton);
 		leftPanel.add(mochaButton);
 		
 		cardTeaPanel = new JPanel();
 		cardLattePanel = new JPanel();
 		
 		cardTeaPanel = teaOptions();
 		cardLattePanel = latteOptions();
 		 		
 		optionSelectPanel.add(cardTeaPanel, "teaCard");
 		optionSelectPanel.add(cardLattePanel, "latteCard");
 		
 		
 		
 		rightPanel.add(optionSelectPanel);
 		rightPanel.add(outputPanel);
 		
		//add components to frame
 		c.add(mainContentPanel);
 	
		setSize(800, 600);
		setVisible(true);
		setTitle("Coffee Shop");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == teaButton) {
			clearItems();
			CardLayout cardLayout = (CardLayout) optionSelectPanel.getLayout();
			cardLayout.show(optionSelectPanel, "teaCard");
		} 
		if(e.getSource() == latteButton) {
			clearItems();
			CardLayout cardLayout = (CardLayout) optionSelectPanel.getLayout();
			cardLayout.show(optionSelectPanel, "latteCard");
		}
		
		if(e.getSource() == milkRadioButton) {
			SimpleTeaFactory fac = new SimpleTeaFactory();
			outputLabel.setText(fac.getTea("milk").getName());
			Icon image = new ImageIcon(fac.getTea("milk").getImage());
			teaImage.setIcon(image);
		}
		
		if(e.getSource() == blackRadioButton) {
			SimpleTeaFactory fac = new SimpleTeaFactory();
			outputLabel.setText(fac.getTea("black").getName());
			Icon image = new ImageIcon(fac.getTea("black").getImage());
			teaImage.setIcon(image);
		}
		
		if(e.getSource() == submitTea) {
			//outputLabel.setVisible(true);
		}
		
		//latte options
		if(e.getSource() == skinnyLatteRadioButton){
			outputLabel.setText(coffeeFactory.getSkinny().getName());
			ingredientsLabel.setText("Ingredients: " + coffeeFactory.getSkinny().getEspresso() +", "+coffeeFactory.getSkinny().getMilk());
			Icon image = new ImageIcon(coffeeFactory.getSkinny().getImageurl());
			teaImage.setIcon(image);
		}
		
		if(e.getSource() == soyLatteRadioButton){
			outputLabel.setText(coffeeFactory.getSoy().getName());
			ingredientsLabel.setText("Ingredients: " + coffeeFactory.getSoy().getEspresso() +", "+coffeeFactory.getSoy().getMilk());
			Icon image = new ImageIcon(coffeeFactory.getSoy().getImageurl());
			teaImage.setIcon(image);
		}
		
		if(e.getSource() == decaffLatteRadioButton){
			outputLabel.setText(coffeeFactory.getDecaff().getName());
			ingredientsLabel.setText("Ingredients: " + coffeeFactory.getDecaff().getEspresso() +", "+coffeeFactory.getDecaff().getMilk());
			Icon image = new ImageIcon(coffeeFactory.getDecaff().getImageurl());
			teaImage.setIcon(image);
		}

	}
	
	public static void main(String[] args) {
		new CoffeeShop();
	}

	/*
	 * takes jbutton and makes it look nice
	 * returns the nice button
	 */
	public JButton formatButton(JButton button) {
		
 		button.addActionListener(this);
 		//button.setPreferredSize(new Dimension(150, 40));
 		button.setFont(new Font("Roboto", Font.PLAIN, 24));
 		button.setBackground(Color.DARK_GRAY);
 		button.setForeground(Color.white);
 		button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		return button;
	}

	/*
	 * puts this panel into the optionSelectPanel if teaButton is clicked
	 */
	public JPanel teaOptions() {
		SimpleTeaFactory teaFactory = new SimpleTeaFactory();
		
		JPanel panel = new JPanel();
		JPanel panelContent = new JPanel();
		milkRadioButton = new JRadioButton("Milk");
		blackRadioButton = new JRadioButton("Black");
		
		submitTea = new JButton("Submit");
		
		milkRadioButton.addActionListener(this);
		blackRadioButton.addActionListener(this);
		
		//choosing one of these returns a certain object
		//simple factory
		ButtonGroup bg = new ButtonGroup();
		bg.add(milkRadioButton);
		bg.add(blackRadioButton);
		
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("How would you like your tea?");
		label.setFont(new Font("Roboto", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panelContent.add(milkRadioButton);
		panelContent.add(blackRadioButton);
		panel.add(panelContent, BorderLayout.CENTER);
		panel.add(submitTea, BorderLayout.SOUTH);
		
		return panel;
	}
	
	public JPanel latteOptions() {
		
		JPanel panel = new JPanel();
		JPanel panelContent = new JPanel();
		
		
		 skinnyLatteRadioButton = new JRadioButton("Skinny");
		 soyLatteRadioButton = new JRadioButton("Soy");
		 decaffLatteRadioButton = new JRadioButton("Decaf");
		
		
		 skinnyLatteRadioButton.addActionListener(this);
		 soyLatteRadioButton.addActionListener(this);
		 decaffLatteRadioButton.addActionListener(this);
		
		//choosing one of these returns a certain object
		//simple factory
		ButtonGroup bg = new ButtonGroup();
		bg.add(skinnyLatteRadioButton);
		bg.add(soyLatteRadioButton);
		bg.add(decaffLatteRadioButton);
		
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("How would you like your Latte?");
		label.setFont(new Font("Roboto", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panelContent.add(skinnyLatteRadioButton);
		panelContent.add(soyLatteRadioButton);
		panelContent.add(decaffLatteRadioButton);
		panel.add(panelContent, BorderLayout.CENTER);
		return panel;
	}
	
	public void clearItems() {
		teaImage.setIcon(null);
		outputLabel.setText("");
	}
}
