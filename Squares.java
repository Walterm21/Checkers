import java.util.*;
import objectdraw.DrawingCanvas;
import objectdraw.FilledRect;
import objectdraw.Location;
import java.awt.*;


public class Squares extends FilledRect {
	
	//variables for the value of the piece, row, and column
	//row and column should not be changed after initialization
	private int value = 0;
	private int row = 0;
	private int col = 0;
	
	
	private Location loc;
	  
	private double size;
	  
	private FilledRect square;
	  
	private DrawingCanvas canvas;
	  
	private int gridVal;
	  
	public Squares(double lX, double lY, double s, int gridV, int val, DrawingCanvas c){
	    
		super (lX, lY, s, s, c);


		loc = new Location(lX, lY);
		size = s;
	    canvas = c;
	    	square = new FilledRect(loc,size,size,canvas);

	    
	    gridVal = gridV;
	    
	    
	    value = val;
	   
	    
	    
	    row = this.getRow();
	    col = this.getCol();

	    if (row%2 == 0){
	      if (gridV%2 == 0){
	        square.setColor(Color.WHITE);
	      }
	      else {
	        square.setColor(Color.BLACK);
	      }
	    }
	    else {
	      if (gridV%2 == 0){
	        square.setColor(Color.BLACK);
	      }
	      else {
	        square.setColor(Color.WHITE);
	      }
	    }
	}
	
	/*
	 * takes an int (value) for the piece (1, 2, 3, 4, 0... see pieces class)
	 * 
	 * row and col are used for the squares position
	 * 
	 * 
	 * note: 
	 * values not between 1 and 4 will result in a value = 0
	 * row and col not between 1 and 8 will result in row = 0 and col = 0 
	 * 
	 * row and col should never be changed
	 * value should hold that of the piece that occupies the square
	 * 
	 */
	
	
	

	//Accessor methods
	public int getValue() {
		return value;
	}
	
	
	
	public int getCol() {
	    
	    if ((gridVal+1)%8==0)
	      return 7;
	    
	    else if ((gridVal+2)%8==0)
	      return 6;
	   
	    else if ((gridVal+3)%8==0)
	      return 5;
	    
	    else if ((gridVal+4)%8==0)
	      return 4;
	    
	    else if ((gridVal-3)%8==0)
	      return 3;
	    
	    else if ((gridVal-2)%8==0)
	      return 2;
	    
	    else if ((gridVal-1)%8==0)
	      return 1;
	    
	    else 
	      return 0;
	    
	}

	
	
	public int getRow() {

		if (gridVal < 8)
	      return 0;
	    
	    else if (gridVal < 16)
	      return 1;
	    
	    else if (gridVal < 24)
	      return 2;
	    
	    else if (gridVal < 32)
	      return 3;
	    
	    else if (gridVal < 40)
	      return 4;
	    
	    else if (gridVal < 48)
	      return 5;
	    
	    else if (gridVal < 56)
	      return 6;
		
	    else 
	      return 7;  
	
	}
	
	
	
	
	
	//Mutator methods
	//Makes sure values are between specified range
	
	public void setValue(int value) {
		if (value > 0 && value <= 4)
			this.value = value;
		else this.value = 0;
	}
	
	
	public void setColor(Color c1, Color c2){
	   
		
	    if (row%2 == 0){
	      if (gridVal%2 == 0)
	        square.setColor(c1);
	      
	      else 
	        square.setColor(c2);
	      
	    }
	    else {
	      if (gridVal%2 == 0)
	        square.setColor(c2);
	      
	      else 
	        square.setColor(c1);
	      
	    }    
	    
	}
	
	
	
	
}
