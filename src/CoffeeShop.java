import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
public class CoffeeShop extends JFrame implements ActionListener{
	
	JPanel optionSelectPanel, cardTeaPanel, cardLattePanel, cardCappPanel, cardMochaPanel, outputPanel; //global because it uses actionPerformed to know which options to show
	JRadioButton milkRadioButton, blackRadioButton, skinnyLatteRadioButton, soyLatteRadioButton, decaffLatteRadioButton, skinnyCappRadioButton, soyCappRadioButton, decaffCappRadioButton;
	Tea tea;
	JLabel outputLabel, ingredientsLabel;
	JLabel drinkImage;
	skinnyCommand skinnyc;
	decaffCommand decaffc;
	drinkCommand teac, lattec, cappc, mochac;
	soyCommand soyc;
	blackTeaCommand blackTeac;
	milkTeaCommand milkTeac;
	cmdButton skinnyButton, soyButton, decaffButton, teaButton, latteButton, cappButton, mochaButton, blackTeaButton, milkTeaButton;
	private CoffeeFactory LatteCoffeeFactory = new Latte();
	private CoffeeFactory CappCoffeeFactory = new Cappuchino();
	private CoffeeFactory MochaCoffeeFactory = new Mocha();
	
	public CoffeeShop() {
		Container c = getContentPane();
		
		//Panel declarations
		JPanel mainContentPanel = new JPanel(); //panel to hold all panels
		JPanel leftPanel = new JPanel(); //panel to hold left buttons
 		JPanel rightPanel = new JPanel(); //panel to hold right content (output)
 		
 		optionSelectPanel = new JPanel(); //panel where user clicks options for drink
 		outputPanel = new JPanel(); //panel to show finished drink
 
 		//button declarations
 		teaButton = new cmdButton("Tea", this);
 		latteButton = new cmdButton("Latte", this);
 		cappButton = new cmdButton("Cappuccino", this);
 		mochaButton = new cmdButton("Mocha", this);
 		
 		
 		//label declarations
 		outputLabel = new JLabel();
 		outputLabel.setFont(new Font("Roboto", Font.PLAIN, 28));
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
 		cardMochaPanel = new JPanel();
 		
 		cardTeaPanel = teaOptions();
 		cardLattePanel = latteOptions();
 		cardCappPanel = cappOptions();
 		cardMochaPanel = mochaOptions();
 		 		
 		optionSelectPanel.add(cardTeaPanel, "teaCard");
 		optionSelectPanel.add(cardLattePanel, "latteCard");
 		optionSelectPanel.add(cardCappPanel, "cappuchinoCard");
 		optionSelectPanel.add(cardMochaPanel, "mochaCard");
 		
 		teac = new drinkCommand("teaCard", this, optionSelectPanel, drinkImage, outputLabel);
 	    teaButton.setCommand(teac);
 	    
 	    lattec = new drinkCommand("latteCard", this, optionSelectPanel, drinkImage, outputLabel);
	    latteButton.setCommand(lattec);
	    
	    cappc = new drinkCommand("cappuchinoCard", this, optionSelectPanel, drinkImage, outputLabel);
 	    cappButton.setCommand(cappc);
 	    
 	    mochac = new drinkCommand("mochaCard", this, optionSelectPanel, drinkImage, outputLabel);
	    mochaButton.setCommand(mochac);
	    
	    teaButton.addActionListener(this);
	    latteButton.addActionListener(this);
	    cappButton.addActionListener(this);
	    mochaButton.addActionListener(this);
 		
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
				clear();
				CommandHolder obj = (CommandHolder)e.getSource();
			      obj.getCommand().Execute();


	}
	
	public void clear() {
		outputLabel.setText("");
		ingredientsLabel.setText("");
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
		
		
		milkTeaButton = new cmdButton("Milk", this);
	    milkTeac = new milkTeaCommand(this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
	    milkTeaButton.setCommand(milkTeac);
	    
	    blackTeaButton = new cmdButton("No Milk", this);
	    blackTeac = new blackTeaCommand(this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
	    blackTeaButton.setCommand(blackTeac);
	    
	    
	    
	    milkTeaButton.addActionListener(this);
	    blackTeaButton.addActionListener(this);
		

		
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("How would you like your Tea?");
		label.setFont(new Font("Roboto", Font.PLAIN, 28));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panelContent.add(milkTeaButton);
		panelContent.add(blackTeaButton);
		
		panel.add(panelContent, BorderLayout.CENTER);
		return panel;
	}
	
	public JPanel latteOptions() {
		
		JPanel panel = new JPanel();
		JPanel panelContent = new JPanel();
		
		
		skinnyButton = new cmdButton("Skinny", this);
	    skinnyc = new skinnyCommand(LatteCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
	    skinnyButton.setCommand(skinnyc);
	    
	    soyButton = new cmdButton("Soy", this);
	    soyc = new soyCommand(LatteCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
	    soyButton.setCommand(soyc);
	    
	    decaffButton = new cmdButton("Decaff", this);
	    decaffc = new decaffCommand(LatteCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
	    decaffButton.setCommand(decaffc);
	    
	    skinnyButton.addActionListener(this);
	    soyButton.addActionListener(this);
	    decaffButton.addActionListener(this);
		

		
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("How would you like your Latte?");
		label.setFont(new Font("Roboto", Font.PLAIN, 28));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panelContent.add(skinnyButton);
		panelContent.add(soyButton);
		panelContent.add(decaffButton);
		panel.add(panelContent, BorderLayout.CENTER);
		return panel;
	}
	
public JPanel cappOptions() {
		
	JPanel panel = new JPanel();
	JPanel panelContent = new JPanel();
	
	
	skinnyButton = new cmdButton("Skinny", this);
    skinnyc = new skinnyCommand(CappCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
    skinnyButton.setCommand(skinnyc);
    
    soyButton = new cmdButton("Soy", this);
    soyc = new soyCommand(CappCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
    soyButton.setCommand(soyc);
    
    decaffButton = new cmdButton("Decaff", this);
    decaffc = new decaffCommand(CappCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
    decaffButton.setCommand(decaffc);
    
    skinnyButton.addActionListener(this);
    soyButton.addActionListener(this);
    decaffButton.addActionListener(this);
	

	
	panel.setLayout(new BorderLayout());
	JLabel label = new JLabel("How would you like your Cappuchino?");
	label.setFont(new Font("Roboto", Font.PLAIN, 28));
	label.setHorizontalAlignment(JLabel.CENTER);
	panel.add(label, BorderLayout.NORTH);
	panelContent.add(skinnyButton);
	panelContent.add(soyButton);
	panelContent.add(decaffButton);
	panel.add(panelContent, BorderLayout.CENTER);
	return panel;
	}

public JPanel mochaOptions() {
	
	JPanel panel = new JPanel();
	JPanel panelContent = new JPanel();
	
	
	skinnyButton = new cmdButton("Skinny", this);
    skinnyc = new skinnyCommand(MochaCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
    skinnyButton.setCommand(skinnyc);
    
    soyButton = new cmdButton("Soy", this);
    soyc = new soyCommand(MochaCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
    soyButton.setCommand(soyc);
    
    decaffButton = new cmdButton("Decaff", this);
    decaffc = new decaffCommand(MochaCoffeeFactory, this, outputPanel, drinkImage, outputLabel, ingredientsLabel);
    decaffButton.setCommand(decaffc);
    
    skinnyButton.addActionListener(this);
    soyButton.addActionListener(this);
    decaffButton.addActionListener(this);
	

	
	panel.setLayout(new BorderLayout());
	JLabel label = new JLabel("How would you like your Mocha?");
	label.setFont(new Font("Roboto", Font.PLAIN, 28));
	label.setHorizontalAlignment(JLabel.CENTER);
	panel.add(label, BorderLayout.NORTH);
	panelContent.add(skinnyButton);
	panelContent.add(soyButton);
	panelContent.add(decaffButton);
	panel.add(panelContent, BorderLayout.CENTER);
	return panel;
	
	
}



	
	
}
