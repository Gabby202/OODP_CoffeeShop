
import java.awt.*;
import javax.swing.*;

public class soyCommand implements Command {
   private JFrame frame;
   private JPanel p;
   private JLabel drinkImage, outputLabel, ingredientsLabel;
   private CoffeeFactory coffeeFactory;

   public soyCommand(CoffeeFactory coffeeFactory, JFrame frame, JPanel p, JLabel drinkImage, JLabel outputLabel, JLabel ingredientsLabel) {
      this.frame = frame;
      this.p = p;
      this.drinkImage = drinkImage;
      this.outputLabel = outputLabel;
      this.ingredientsLabel = ingredientsLabel;
      this.coffeeFactory = coffeeFactory;
   }
   public void Execute() {
	    outputLabel.setText(coffeeFactory.getSoy().getName());
		ingredientsLabel.setText("Ingredients: " + coffeeFactory.getSoy().getEspresso() +", "+coffeeFactory.getSoy().getMilk());
		ingredientsLabel.setFont(new Font("Roboto", Font.PLAIN, 28));
		Icon image = new ImageIcon(coffeeFactory.getSoy().getImageurl());
		drinkImage.setIcon(image);
		
   }
}
