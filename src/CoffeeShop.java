import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
public class CoffeeShop extends JFrame implements ActionListener{
	
	JButton teaButton, latteButton, cappButton, mochaButton;
	JPanel optionSelectPanel, cardTeaPanel, cardLattePanel, cardCappPanel; //global because it uses actionPerformed to know which options to show
	JRadioButton milkRadioButton, blackRadioButton, skinnyLatteRadioButton, soyLatteRadioButton, decaffLatteRadioButton, skinnyCappRadioButton, soyCappRadioButton, decaffCappRadioButton;
	Tea tea;
	JLabel outputLabel, ingredientsLabel;
	JLabel drinkImage;
	private CoffeeFactory LatteCoffeeFactory = new Latte();
	private CoffeeFactory CappCoffeeFactory = new Cappuchino();
	
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
 		drinkImage = new JLabel();
 		
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
 		outputPanel.add(drinkImage, BorderLayout.CENTER);
 		

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
 		cardCappPanel = new JPanel();
 		
 		cardTeaPanel = teaOptions();
 		cardLattePanel = latteOptions();
 		cardCappPanel = cappOptions();
 		 		
 		optionSelectPanel.add(cardTeaPanel, "teaCard");
 		optionSelectPanel.add(cardLattePanel, "latteCard");
 		optionSelectPanel.add(cardCappPanel, "cappuchinoCard");
 		
 		
 		
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
		
		if(e.getSource() == cappButton) {
			clearItems();
			CardLayout cardLayout = (CardLayout) optionSelectPanel.getLayout();
			cardLayout.show(optionSelectPanel, "cappuchinoCard");
		}
		
		if(e.getSource() == milkRadioButton) {
			SimpleTeaFactory fac = new SimpleTeaFactory();
			outputLabel.setText(fac.getTea("milk").getName());
			Icon image = new ImageIcon(fac.getTea("milk").getImage());
			drinkImage.setIcon(image);
			ingredientsLabel.setText(""); 
		}
		
		if(e.getSource() == blackRadioButton) {
			SimpleTeaFactory fac = new SimpleTeaFactory();
			outputLabel.setText(fac.getTea("black").getName());
			Icon image = new ImageIcon(fac.getTea("black").getImage());
			drinkImage.setIcon(image);
			ingredientsLabel.setText(""); 
		}
		
		
		//latte options
		if(e.getSource() == skinnyLatteRadioButton){
			outputLabel.setText(LatteCoffeeFactory.getSkinny().getName());
			ingredientsLabel.setText("Ingredients: " + LatteCoffeeFactory.getSkinny().getEspresso() +", "+LatteCoffeeFactory.getSkinny().getMilk());
			Icon image = new ImageIcon(LatteCoffeeFactory.getSkinny().getImageurl());
			drinkImage.setIcon(image);
		}
		
		if(e.getSource() == soyLatteRadioButton){
			outputLabel.setText(LatteCoffeeFactory.getSoy().getName());
			ingredientsLabel.setText("Ingredients: " + LatteCoffeeFactory.getSoy().getEspresso() +", "+LatteCoffeeFactory.getSoy().getMilk());
			Icon image = new ImageIcon(LatteCoffeeFactory.getSoy().getImageurl());
			drinkImage.setIcon(image);
		}
		
		if(e.getSource() == decaffLatteRadioButton){
			outputLabel.setText(LatteCoffeeFactory.getDecaff().getName());
			ingredientsLabel.setText("Ingredients: " + LatteCoffeeFactory.getDecaff().getEspresso() +", "+LatteCoffeeFactory.getDecaff().getMilk());
			Icon image = new ImageIcon(LatteCoffeeFactory.getDecaff().getImageurl());
			drinkImage.setIcon(image);
		}
		
		//lcapp options
				if(e.getSource() == skinnyCappRadioButton){
					outputLabel.setText(CappCoffeeFactory.getSkinny().getName());
					ingredientsLabel.setText("Ingredients: " + CappCoffeeFactory.getSkinny().getEspresso() +", "+CappCoffeeFactory.getSkinny().getMilk());
					Icon image = new ImageIcon(CappCoffeeFactory.getSkinny().getImageurl());
					drinkImage.setIcon(image);
				}
				
				if(e.getSource() == soyCappRadioButton){
					outputLabel.setText(CappCoffeeFactory.getSoy().getName());
					ingredientsLabel.setText("Ingredients: " + CappCoffeeFactory.getSoy().getEspresso() +", "+CappCoffeeFactory.getSoy().getMilk());
					Icon image = new ImageIcon(CappCoffeeFactory.getSoy().getImageurl());
					drinkImage.setIcon(image);
				}
				
				if(e.getSource() == decaffCappRadioButton){
					outputLabel.setText(CappCoffeeFactory.getDecaff().getName());
					ingredientsLabel.setText("Ingredients: " + CappCoffeeFactory.getDecaff().getEspresso() +", "+CappCoffeeFactory.getDecaff().getMilk());
					Icon image = new ImageIcon(CappCoffeeFactory.getDecaff().getImageurl());
					drinkImage.setIcon(image);
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
	
public JPanel cappOptions() {
		
		JPanel panel = new JPanel();
		JPanel panelContent = new JPanel();
		
		
		 skinnyCappRadioButton = new JRadioButton("Skinny");
		 soyCappRadioButton = new JRadioButton("Soy");
		 decaffCappRadioButton = new JRadioButton("Decaf");
		
		
		 skinnyCappRadioButton.addActionListener(this);
		 soyCappRadioButton.addActionListener(this);
		 decaffCappRadioButton.addActionListener(this);
		
		//choosing one of these returns a certain object
		//simple factory
		ButtonGroup bg = new ButtonGroup();
		bg.add(skinnyCappRadioButton);
		bg.add(soyCappRadioButton);
		bg.add(decaffCappRadioButton);
		
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("How would you like your Cappuchino?");
		label.setFont(new Font("Roboto", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panelContent.add(skinnyCappRadioButton);
		panelContent.add(soyCappRadioButton);
		panelContent.add(decaffCappRadioButton);
		panel.add(panelContent, BorderLayout.CENTER);
		return panel;
	}
	
	public void clearItems() {
		drinkImage.setIcon(null);
		outputLabel.setText("");
	}
}
