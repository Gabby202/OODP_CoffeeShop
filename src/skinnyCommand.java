
import java.awt.*;
import javax.swing.*;

public class skinnyCommand implements Command {
   private JFrame frame;
   private JPanel p;
   private JLabel drinkImage, outputLabel, ingredientsLabel;
   private CoffeeFactory coffeeFactory;

   public skinnyCommand(CoffeeFactory coffeeFactory, JFrame frame, JPanel p, JLabel drinkImage, JLabel outputLabel, JLabel ingredientsLabel) {
      this.frame = frame;
      this.p = p;
      this.drinkImage = drinkImage;
      this.outputLabel = outputLabel;
      this.ingredientsLabel = ingredientsLabel;
      this.coffeeFactory = coffeeFactory;
   }
   public void Execute() {
	    outputLabel.setText(coffeeFactory.getSkinny().getName());
		ingredientsLabel.setText("Ingredients: " + coffeeFactory.getSkinny().getEspresso() +", "+coffeeFactory.getSkinny().getMilk());
		Icon image = new ImageIcon(coffeeFactory.getSkinny().getImageurl());
		drinkImage.setIcon(image);
		
   }
}
