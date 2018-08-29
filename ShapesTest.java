// Fig. 5.27: Shapes.java
// Drawing a cascade of shapes based on the user’s choice.
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Shapes extends JPanel
{
      private int choice; // user's choice of which shape to draw

      // constructor sets the user's choice
      public Shapes(int userChoice)
      {
        choice = userChoice;
      }

     // draws a cascade of shapes starting from the top-left corner  
      public void paintComponent(Graphics g)
      {
        super.paintComponent(g);
   
        for (int i = 0; i < 10; i++)
        {
            // pick the shape based on the user's choice
            switch (choice)
            {
                  case 1: // draw rectangles
                  g.drawRect(10 + i * 10, 10 + i * 10,
                      50 + i * 10, 50 + i * 10);
                  break;
                  case 2: // draw ovals
                  g.drawOval(10 + i * 10, 10 + i * 10,
                  50 + i * 10, 50 + i * 10);
                  break;
        
            }
        }
    }
} // end class Shapes


public class ShapesTest
{
     public static void main(String[] args)
     {
     // obtain user's choice
     String input = JOptionPane.showInputDialog("Enter 1 to draw rectangles. \n " + "Enter 2 to draw ovals.");

     int choice = Integer.parseInt(input); // convert input to int

     // create the panel with the user's input
     Shapes panel = new Shapes(choice);
     JFrame application = new JFrame(); // creates a new JFrame

     application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     application.add(panel);
     application.setSize(300, 300);
     application.setVisible(true);
     }
} // end class ShapesTest