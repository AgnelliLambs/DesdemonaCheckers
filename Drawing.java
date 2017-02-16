import javax.swing.*;
import java.awt.event.*;

public class Drawing extends JFrame implements MouseListener{
   Drawer board; 
   private boolean whiteTurn = true;
   public static void main(String args[]){
      new Drawing();
   }
   public Drawing(){
   
      
      this.addMouseListener(this);
      board  = new Drawer();
      this.add(board);
      board.repaint();
      this.setSize(800,800);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
   @Override
   public void mouseClicked(MouseEvent e){
      int x = e.getX()/Drawer.SQUARE_SIZE;
      int y = e.getY()/Drawer.SQUARE_SIZE;
      if(whiteTurn){
         board.addPiece(x,y,board.WHITE);
         flipPeices(x,y,board.WHITE);
      }
      else{
         board.addPiece(x,y,board.BLACK);
         flipPeices(x,y,board.BLACK);
      }
      board.repaint();
      System.out.println("x: "+x+",y: "+y);
      
      whiteTurn=!whiteTurn;
   }
   @Override
   public void mouseExited(MouseEvent e){}
   @Override
   public void mouseEntered(MouseEvent e){}
   @Override
   public void  mouseReleased(MouseEvent e){}
   @Override
   public void mousePressed(MouseEvent e){}
   
   public void flipPeices(int x1,int y1,int col){
   //<!-- NOTE : If board.pieces[var][var] == 0 break, set x and y to -1 -->
   //check left
      int firstLeft = -1;
      for(int i=x1-1;i>=0;i--){//find the first board of similar color to the left of this board
         if(board.pieces[i][y1] == col){
            firstLeft=i;
            break;
         }
      }
      System.out.println("firstLeft: "+firstLeft);
      if(firstLeft>-1){
      //flip everything between them
         for(int i=x1-1;i>firstLeft;i--){
            board.flip(i,y1);   
         }
      }
   //check right
      int firstRight = -1;
      for(int i=x1+1;i<8;i++){//find the first board of similar color to the right of this board
         if(board.pieces[i][y1] == col){
            firstRight=i;
            break;
         }
      }
      System.out.println("firstRight: "+firstRight);
      if(firstRight>-1){
      //flip everything between them
         for(int i=x1+1;i<firstRight;i++){
            board.flip(i,y1);   
         }
      }
   
   //check up
   
      int firstUp = -1;
      for(int i=y1-1;i>=0;i--){//find the first board of similar color to above 
         if(board.pieces[x1][i] == col){
            firstUp=i;
            break;
         }
      }
      System.out.println("firstUp: "+firstUp);
      if(firstUp>-1){
      //flip everything between them
         for(int i=y1-1;i>firstUp;i--){
            board.flip(x1,i);   
         }
      }
   
   //check down
   
      int firstDown = -1;
      for(int i=y1+1;i<8;i++){//find the first board of similar color to the below the clicked location
         if(board.pieces[x1][i] == col){
            firstDown=i;
            break;
         }
      }
      System.out.println("firstDown: "+firstDown);
      if(firstDown>-1){
      //flip everything between them
         for(int i=y1+1;i<firstDown;i++){//find the first board of similar color to the right of this board
            board.flip(x1,i);   
         }
      }
   
   
   //check upleft
   
      int firstUpLeftY = y1;
      int firstUpLeftX = x1;
      
      firstUpLeftX--;
      firstUpLeftY--;
      
      while(firstUpLeftX > -1 && firstUpLeftY>-1){
         
         if(board.pieces[firstUpLeftX][firstUpLeftY] == col){ //find the first piece up and to the left
            break;
         }
         firstUpLeftX--;
         firstUpLeftY--;
      
      }
      System.out.println("firstUpLeftY: "+firstUpLeftY);
      System.out.println("firstUpLeftX: "+firstUpLeftX);
   
      if(firstUpLeftX>-1 && firstUpLeftY>-1){
      //flip everything between them
         firstUpLeftX++;
         firstUpLeftY++;
         while(firstUpLeftX<x1 && firstUpLeftY<y1){
            board.flip(firstUpLeftX,firstUpLeftY);
            firstUpLeftX++;
            firstUpLeftY++;
         }
      }
   
   
   //check upright
      int firstUpRightX = x1;
      int firstUpRightY = y1;
      
      firstUpRightX++;
      firstUpRightY--;
      
      //find the first piece
      while(firstUpRightX < 8 && firstUpRightY>-1){
         
         if(board.pieces[firstUpRightX][firstUpRightY] == col){
            break;
         }
         
         firstUpRightX++;
         firstUpRightY--;
      
      }
      
      System.out.println("firstUpRightX: "+firstUpRightX);
      System.out.println("firstUpRightY: "+firstUpRightY);
      
      //flip everything between them
      if(firstUpRightX<8 && firstUpRightY>-1){
         firstUpRightX--;
         firstUpRightY++;
         while(firstUpLeftX<x1 && firstUpRightY<y1){
            board.flip(firstUpRightX,firstUpRightY);
            firstUpRightX--;
            firstUpRightY++;
         }
      }
   
   
   //check downleft
      int downLeftX = x1;
      int downLeftY = y1;
      
      downLeftX--;
      downLeftY++;
      
      //find the first piece
      while(downLeftX >-1 && downLeftY<8){
         
         if(board.pieces[downLeftX][downLeftY] == col){
            break;
         }
         
         downLeftX--;
         downLeftY++;
      
      }
      
      System.out.println("downLeftX: "+downLeftX);
      System.out.println("downLeftY: "+downLeftY);
      
      //flip everything between them
      if(downLeftX>-1 && downLeftY<8){
         downLeftX++;
         downLeftY--;
         while(downLeftX<x1 && downLeftY>y1){
            board.flip(downLeftX,downLeftY);
            downLeftX++;
            downLeftY--;
         }
      }


   //check downright
      int downRightX = x1;
      int downRightY = y1;
      
      downRightX++;
      downRightY++;
      
      //find the first piece
      while(downRightX <8 && downRightY<8){
         
         if(board.pieces[downRightX][downRightY] == col){
            break;
         }
         
         downRightX++;
         downRightY++;
      
      }
      
      System.out.println("downRightX: "+downRightX);
      System.out.println("downRightY: "+downRightY);
      
      //flip everything between them
      if(downRightX<8 && downRightY<8){
         downRightX--;
         downRightY--;
         while(downRightX>x1 && downRightY>y1){
            board.flip(downRightX,downRightY);
            downRightX--;
            downRightY--;
         }
      }
   }

}
