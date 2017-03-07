import javax.swing.*;

public class GameGUI{
   public static void main(String [] args){
      new GameGUI();
   }
   
   public GameGUI(){
   
      /*
      * JMenuBar
      * Contains actions for Size Presets, Saving and Resetting the game.
      */
      
      // New JMenuBar
      
         // File Menu
         
            // Menu Items (Save, Reset)
            
            // Add Menu Items to Menu
            
         // Resize Menu
         
            // Menu Items (Size Presets)
            
            // Add Menu Items to Menu
         
         // Add Menus to MenuBar
      
      // Add MenuBar to JFrame (this)
      
      /*
      * Northern Panel
      * Contains Turn timers/indicators
      */
      
      // New 3Col GridLayout JPanel (this: north)
      
         // New 3Row GridLayout JPanel (north: left)
         
            // New JLabel 1st Row (White)
            
            // New JLabel 2nd Row (Score indicator)
            
            // New JLabel 3rd Row (Turn Timer)
            
            // Add JLabels to Left-JPanel
            
         // Add JPanel to Northern JPanel
         
         // New JPanel (north: middle)
            
            //New JLabel (Turn indicator)
         
         // Add JPanel to Northern JPanel
         
         // New 3Row GridLayout JPanel (north: right)
            
            // New JLabel 1st Row (Black)
            
            // New JLabel 2nd Row (Score indicator)
            
            // New JLabel 3rd Row (Turn Timer)
            
            // Add JLabels to Right-JPanel
         
         // Add JPanel to Northern JPanel
      
      /*
      * Central Panel
      * Contains gameboard
      */
      
      // New gameboard object
      
   }
}