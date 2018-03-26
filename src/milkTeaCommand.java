import java.awt.*;
import javax.swing.*;

public class milkTeaCommand implements Command {
   private JFrame frame;
   private JPanel p;
   private JLabel drinkImage, outputLabel, ingredientsLabel;
   
   

   public milkTeaCommand(JFrame frame, JPanel p, JLabel drinkImage, JLabel outputLabel, JLabel ingredientsLabel) {
      this.frame = frame;
      this.p = p;
      this.drinkImage = drinkImage;
      this.outputLabel = outputLabel;
      this.ingredientsLabel = ingredientsLabel;
      
  
   }
   public void Execute() {
	   SimpleTeaFactory fac = new SimpleTeaFactory();
		outputLabel.setText(fac.getTea("milk").getName());
		Icon image = new ImageIcon(fac.getTea("milk").getImage());
		drinkImage.setIcon(image);
		ingredientsLabel.setText(""); 
		
   }
}


