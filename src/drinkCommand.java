import java.awt.*;
import javax.swing.*;

public class drinkCommand implements Command {
   private JFrame frame;
   private JPanel p;
   private JLabel drinkImage, outputLabel;
   private String panelName;
   

   public drinkCommand(String panelName, JFrame frame, JPanel p, JLabel drinkImage, JLabel outputLabel) {
      this.frame = frame;
      this.p = p;
      this.drinkImage = drinkImage;
      this.outputLabel = outputLabel;
      this.panelName = panelName;
  
   }
   public void Execute() {
	   drinkImage.setIcon(null);
	   outputLabel.setText("");
	   CardLayout cardLayout = (CardLayout) p.getLayout();
	   cardLayout.show(p, panelName);
		
   }
}


