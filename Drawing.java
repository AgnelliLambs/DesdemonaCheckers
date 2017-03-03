import javax.swing.*;
import java.awt.event.*;

public class Drawing extends JFrame implements MouseListener{
   Drawer board; 
   private boolean whiteTurn = false;
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
         if(isLegalMove(x,y)){
            board.addPiece(x,y,board.WHITE);
            flipPieces(x,y,board.WHITE);
         }
      }
      else{
         if(isLegalMove(x,y)){
            board.addPiece(x,y,board.BLACK);
            flipPieces(x,y,board.BLACK);
         }
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
   
   public void flipPieces(int x1,int y1,int col){
   //<!-- NOTE : If board.pieces[var][var] == 0 break, set x and y to -1 -->
   //check left
      int firstLeft = -1;
      for(int i=x1-1;i>=0;i--){//find the first board of similar color to the left of this board
         if(board.pieces[i][y1] == Drawer.EMPTY){
            firstLeft=-1;
            break;
         }
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
         if(board.pieces[i][y1] == Drawer.EMPTY){
            firstRight=-1;
         }
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
         if(board.pieces[x1][i] == Drawer.EMPTY){
            firstUp=-1;
         }
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
         if(board.pieces[x1][i] == Drawer.EMPTY){
            firstDown=-1;
         }
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
         if(board.pieces[firstUpLeftX][firstUpLeftY] == Drawer.EMPTY){ 
            firstUpLeftX=-1;
            firstUpLeftY=-1;
            break;
         }
         
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
         
         if(board.pieces[firstUpRightX][firstUpRightY] == Drawer.EMPTY){
            firstUpRightX = -1;
            firstUpRightY = -1;
            break;
         }
         
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
         
         if(board.pieces[downLeftX][downLeftY] == Drawer.EMPTY){
            downLeftX = -1;
            downLeftY = -1;
            break;
         }
         
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
         
         if(board.pieces[downRightX][downRightY] == Drawer.EMPTY){
            downRightX = -1;
            downRightY = -1;
            break;
         }
         
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
   /**
    * Returns whether or not the move move is legal
    * @params int x - the x coordinate of the move
    * @params int y - the y coodinate of the move
    * @return boolean - true if the move is legal, otherwise, false
    */
    
   public boolean isLegalMove(int x,int y){
      if(board.pieces[x][y]!=0){
         System.out.println("1");
         return false;
      }
      else{
      //left
         try{
            if(board.pieces[x-1][y]!=0){
               System.out.println("2");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //right
         try{
            if(board.pieces[x+1][y]!=0){
               System.out.println("3");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //up
         try{
            if(board.pieces[x][y-1]!=0){
               System.out.println("4");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //down
         try{
            if(board.pieces[x][y+1]!=0){
               System.out.println("5");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //upleft
         try{
            if(board.pieces[x-1][y-1]!=0){
               System.out.println("6");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //upright
         try{
            if(board.pieces[x+1][y-1]!=0){
               System.out.println("7");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //downleft
         try{
            if(board.pieces[x-1][y+1]!=0){
               System.out.println("8");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
         //downright
         try{
            if(board.pieces[x+1][y+1]!=0){
               System.out.println("9");
               return true;
            }
         }
         catch(ArrayIndexOutOfBoundsException aioobe){}
      }
      System.out.println("10");
      return false;
   }
}