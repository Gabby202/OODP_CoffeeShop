

import java.awt.*;
import javax.swing.*;

public class decaffCommand implements Command {
   private JFrame frame;
   private JPanel p;
   private JLabel drinkImage, outputLabel, ingredientsLabel;
   private CoffeeFactory coffeeFactory;

   public decaffCommand(CoffeeFactory coffeeFactory, JFrame frame, JPanel p, JLabel drinkImage, JLabel outputLabel, JLabel ingredientsLabel) {
      this.frame = frame;
      this.p = p;
      this.drinkImage = drinkImage;
      this.outputLabel = outputLabel;
      this.ingredientsLabel = ingredientsLabel;
      this.coffeeFactory = coffeeFactory;
   }
   public void Execute() {
	    outputLabel.setText(coffeeFactory.getDecaff().getName());
		ingredientsLabel.setText("Ingredients: " + coffeeFactory.getDecaff().getEspresso() +", "+coffeeFactory.getDecaff().getMilk());
		ingredientsLabel.setFont(new Font("Roboto", Font.PLAIN, 28));
		Icon image = new ImageIcon(coffeeFactory.getDecaff().getImageurl());
		drinkImage.setIcon(image);
		
   }
}
