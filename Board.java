import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Board extends JPanel{
   public static final int SQUARE_SIZE = 95;
   
   public static final int EMPTY = 0;
   public static final int BLACK = 1;
   public static final int WHITE = 2;
   
   public int[][] pieces =  {{0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0},
                              {0,0,0,1,2,0,0,0},
                              {0,0,0,2,1,0,0,0},
                              {0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0},
                              {0,0,0,0,0,0,0,0}};
   
   public Board(){
      //super(new 
   }
   public void paint(Graphics g){
   
      for(int y=0;y<8;y++){
         for(int x=0;x<8;x++){
            g.setColor(Color.BLACK);
            g.fillRect(x*SQUARE_SIZE,y*SQUARE_SIZE,SQUARE_SIZE,SQUARE_SIZE);
            g.setColor(new Color(20,200,20));//green
            g.fillRect(x*SQUARE_SIZE+(int)(SQUARE_SIZE*.01),y*SQUARE_SIZE-(int)(SQUARE_SIZE*.01),SQUARE_SIZE-(int)(SQUARE_SIZE*.02),SQUARE_SIZE-(int)(SQUARE_SIZE*.02));
         }
      }
      
      
      for(int y=0;y<8;y++){
         for(int x=0;x<8;x++){
            if(pieces[x][y] == BLACK){
               g.setColor(Color.WHITE);
               g.fillOval(x*SQUARE_SIZE+(int)(SQUARE_SIZE*.09),y*SQUARE_SIZE+(int)(SQUARE_SIZE*.09),(int)(SQUARE_SIZE*.77),(int)(SQUARE_SIZE*.77));
               
               g.setColor(Color.BLACK);
               g.fillOval(x*SQUARE_SIZE+(int)(SQUARE_SIZE*.10),y*SQUARE_SIZE+(int)(SQUARE_SIZE*.10),(int)(SQUARE_SIZE*.75),(int)(SQUARE_SIZE*.75));
            }
            else if(pieces[x][y] == WHITE){
               g.setColor(Color.BLACK);
               g.fillOval(x*SQUARE_SIZE+(int)(SQUARE_SIZE*.09),y*SQUARE_SIZE+(int)(SQUARE_SIZE*.09),(int)(SQUARE_SIZE*.77),(int)(SQUARE_SIZE*.77));
            
               g.setColor(Color.WHITE);
               g.fillOval(x*SQUARE_SIZE+(int)(SQUARE_SIZE*.10),y*SQUARE_SIZE+(int)(SQUARE_SIZE*.10),(int)(SQUARE_SIZE*.75),(int)(SQUARE_SIZE*.75));
            }
            else{
            
            }
         }
      }
   
   
         
   }
   public void drawBoard(){
      Graphics g = this.getGraphics();
      this.setSize(800,800);
   
   }
   public void addPiece(int x, int y,int color){
      pieces[x][y] = color;
   
   }
   public void flip(int x, int y){
      if(pieces[x][y] == WHITE){
         pieces[x][y] = BLACK;
      }
      else if(pieces[x][y] == BLACK){
         pieces[x][y] = WHITE;
      }
   }
}

/**
Check if the game is over

for(int x=0;x<8;x++){
      for(int y=0;y<8;y++){
         if(isLegalMove(x,y,DRAWER.WHITE)){
            return true;
         }
      }
    }
    return false;
    
    for(int x=0;x<8;x++){
      for(int y=0;y<8;y++){
         isLegalMove(x,y,DRAWER.BLACK);
      }
    }


*/