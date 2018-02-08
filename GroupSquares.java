import objectdraw.*;
import java.awt.*;

public class GroupSquares extends FilledRect {

	  
	  private Location loc;
	  
	  private double side;
	  
	  private String name;
	  
	  private FilledRect square;
	  
	  private DrawingCanvas canvas;
	  
	  private double gridVal;
	  

	  public GroupSquares(double lX, double lY, double s, double v, String n, DrawingCanvas c){
	    
	     super (lX, lY, s, s, c);



	    loc = new Location(lX, lY);
	    side = s;
	    gridVal = v;
	    name = n;
	    canvas = c;
	    
	    square = new FilledRect(loc,side,side,canvas);
	    
	    double row = this.getRow();

	    if (row%2 == 0){
	      if (v%2 == 0){
	        square.setColor(Color.WHITE);
	      }
	      else {
	        square.setColor(Color.BLACK);
	      }
	    }
	    else {
	      if (v%2 == 0){
	        square.setColor(Color.BLACK);
	      }
	      else {
	        square.setColor(Color.WHITE);
	      }
	    }

	    
	    
	  }
	  
	  public GroupSquares(Location point, double s, double v, String n, DrawingCanvas c){
	    

	     super (point, s, s, c);

	    loc = new Location(point.getX(), point.getY());
	    side = s;
	    gridVal = v;
	    name = n;
	    canvas = c;
	    
	    new GroupSquares(point.getX(), point.getY(), s, v, n, c);
	    
	  }

	    
	  
	  public String getPosition() {
	    
		  return name;
		  
	  }


	public int getCol(){
	    
	    if ((gridVal+1)%8==0){
	      return 7;
	    }
	    else if ((gridVal+2)%8==0){
	      return 6;
	    }
	    else if ((gridVal+3)%8==0){
	      return 5;
	    }
	    else if ((gridVal+4)%8==0){
	      return 4;
	    }
	    else if ((gridVal-3)%8==0){
	      return 3;
	    }
	    else if ((gridVal-2)%8==0){
	      return 2;
	    }
	    else if ((gridVal-1)%8==0){
	      return 1;
	    }
	    else {
	      return 0;
	    }
	  }

	  public int getRow(){

	    if (gridVal < 8){
	      return 0;
	    }
	    else if (gridVal < 16){
	      return 1;
	    }
	    else if (gridVal < 24){
	      return 2;
	    }
	    else if (gridVal < 32){
	      return 3;
	    }
	    else if (gridVal < 40){
	      return 4;
	    }
	    else if (gridVal < 48){
	      return 5;
	    }
	    else if (gridVal < 56){
	      return 6;
	    }
	    else {
	      return 7;
	    }
	  }



	  public void setColor(Color oneColor, Color twoColor){
	    
	    int row = this.getRow();

	    if (row%2 == 0){
	      if (gridVal%2 == 0){
	        square.setColor(oneColor);
	      }
	      else {
	        square.setColor(twoColor);
	      }
	    }
	    else {
	      if (gridVal%2 == 0){
	        square.setColor(twoColor);
	      }
	      else {
	        square.setColor(oneColor);
	      }
	    }
	    
	    
	    
	  }

	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*  
  private Location loc;
  
  private double side;
  
  private String name;
  
  private FilledRect square;
  
  private DrawingCanvas canvas;
  
  private double rowVal, colVal;
  

  public GroupSquares(double lX, double lY, double s, double rowV, double colV, String n, DrawingCanvas c){
	  super (lX,lY, s, s, c);
	  loc = new Location(lX, lY);
	  side = s;
	  rowVal = rowV;
	  colVal = colV;
	  name = n;
	  canvas = c;
    
	  square = new FilledRect(loc,side,side,canvas);
    
    
    
	  if (rowVal%2 == 0){
		  if (colVal%2 == 0) {
			  square.setColor(Color.RED);
		  }
		  else {
			  square.setColor(Color.BLACK);
		  }
	  }
	  
	  else {
		  if (colVal%2 == 0) {
			  square.setColor(Color.BLACK);
		  }
		  else {
			  square.setColor(Color.RED);
		  }
	  }
    
    
  }
  
  public GroupSquares(Location point, double s, double rowV, double colV, String n, DrawingCanvas c){
	  super (point, s, s, c);
	  loc = new Location(point.getX(), point.getY());
	  side = s;
	  rowVal = rowV;
	  colVal = colV;
	  name = n;
	  canvas = c;
    
	  new GroupSquares(point.getX(), point.getY(), s, rowV, colV, n, c);
    
  }

    

  
  public String getPosition() {
    
	  return name;
	  
}


  public double getRow(double rowVal){

    if (rowVal < 8){
      return 0;
    }
    else if (rowVal < 16){
      return 1;
    }
    else if (rowVal < 24){
      return 2;
    }
    else if (rowVal < 32){
      return 3;
    }
    else if (rowVal < 40){
      return 4;
    }
    else if (rowVal < 48){
      return 5;
    }
    else if (rowVal < 56){
      return 6;
    }
    else {
      return 7;
    }
  }

  
  public double getCol(double colVal){

	    if (colVal < 8){
	      return 0;
	    }
	    else if (colVal < 16){
	      return 1;
	    }
	    else if (colVal < 24){
	      return 2;
	    }
	    else if (colVal < 32){
	      return 3;
	    }
	    else if (colVal < 40){
	      return 4;
	    }
	    else if (colVal < 48){
	      return 5;
	    }
	    else if (colVal < 56){
	      return 6;
	    }
	    else {
	      return 7;
	    }
	  }

}

	  
	  private Location loc;
	  
	  private double side;
	  
	  private String name;
	  
	  private FilledRect square;
	  
	  private DrawingCanvas canvas;
	  
	  private double gridVal;
	  

	  public GroupSquares(double lX, double lY, double s, double v, String n, DrawingCanvas c){
	    super (lX, lY, s, s, c);
	    loc = new Location(lX, lY);
	    side = s;
	    gridVal = v;
	    name = n;
	    canvas = c;
	    
	    square = new FilledRect(loc,side,side,canvas);
	    
	    double row = this.getRow();

	    if (row%2 == 0){
	      if (gridVal%2 == 0){
	        square.setColor(Color.WHITE);
	      }
	      else {
	        square.setColor(Color.BLACK);
	      }
	    }
	    else {
	      if (gridVal%2 == 0){
	        square.setColor(Color.BLACK);
	      }
	      else {
	        square.setColor(Color.WHITE);
	      }
	    }

	    
	    
	  }
	  
	  public GroupSquares(Location point, double s, double v, String n, DrawingCanvas c){
	    super (point, s, s, c);
	    loc = new Location(point.getX(), point.getY());
	    side = s;
	    gridVal = v;
	    name = n;
	    canvas = c;
	    
	    new GroupSquares(point.getX(), point.getY(), s, v, n, c);
	    
	  }

	    
	  
	  public String getPosition() {
	    
		  return name;
		  
	  }


	  public double getRow(){

	    if (gridVal < 8){
	      return 0;
	    }
	    else if (gridVal < 16){
	      return 1;
	    }
	    else if (gridVal < 24){
	      return 2;
	    }
	    else if (gridVal < 32){
	      return 3;
	    }
	    else if (gridVal < 40){
	      return 4;
	    }
	    else if (gridVal < 48){
	      return 5;
	    }
	    else if (gridVal < 56){
	      return 6;
	    }
	    else {
	      return 7;
	    }
	  }

	  public double getCol(){
		    
		    if ((gridVal+1)%8==0){
		      return 7;
		    }
		    else if ((gridVal+2)%8==0){
		      return 6;
		    }
		    else if ((gridVal+3)%8==0){
		      return 5;
		    }
		    else if ((gridVal+4)%8==0){
		      return 4;
		    }
		    else if ((gridVal-3)%8==0){
		      return 3;
		    }
		    else if ((gridVal-2)%8==0){
		      return 2;
		    }
		    else if ((gridVal-1)%8==0){
		      return 1;
		    }
		    else {
		      return 0;
		    }
		  }

		  



		  public void setColor(Color oneColor, Color twoColor){
		    
		    double row = this.getRow();

		    if (row%2 == 0){
		      if (gridVal%2 == 0){
		        square.setColor(oneColor);
		      }
		      else {
		        square.setColor(twoColor);
		      }
		    }
		    else {
		      if (gridVal%2 == 0){
		        square.setColor(twoColor);
		      }
		      else {
		        square.setColor(oneColor);
		      }
		    }

	    
	    
	    
	  }
*/
	

