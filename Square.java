import java.util.*;
import objectdraw.DrawingCanvas;
import objectdraw.FilledRect;
import objectdraw.Location;
import java.awt.*;


public class Square extends FilledRect {
	
	//variables for the value of the piece, row, and column
	//row and column should not be changed after initialization
	private int value = 0, 
			row = 0,
			col = 0;
	
	
	  //Used for visual implementation
	 
	private Location loc;
	  
	private int size;
	  
	private FilledRect square;
	  
	private DrawingCanvas canvas;
	
	
	public Square(int value, int row, int col, Location loc, int size, DrawingCanvas canvas) {
		super (loc, size, size, canvas);
		super.hide();
		this.square = new FilledRect(loc,size,size,canvas);
		
		
		this.value = value;
		this.row = row;
		this.col = col;
		
		
		this.loc = loc;
		this.size = size;
		this.canvas = canvas;
	
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
	    return col;
	}

	
	
	public int getRow() {
		return row;
	}
	
	public boolean contains(Location point) {
		return square.contains(point);
	}
	
	
	public FilledRect getSquare() {
		return square;
	}
	
	
	
	
	//Mutator methods
	//Makes sure values are between specified range
	
	public void setValue(int value) {
		if (value > 0 && value <= 4)
			this.value = value;
		else this.value = 0;
	}
	
	
	public void setColor(Color c1) {
		square.setColor(c1);
	}
	
	public void setColor(Color c1, Color c2){
		if (row % 2 == 0) {
	    		if (col % 2 == 0) {
	    			square.setColor(c2);
	    			System.out.println(1);
	    		}
	    
	    		else {
	    			square.setColor(c1);
	    			System.out.println(2);
	    		}
	    }
	    else {
	    		if (col % 2 == 0) {
	    			square.setColor(c1);
	    			System.out.println(3);
	    		}
	    		else { 
	    			square.setColor(c2);
	    			System.out.println(4);
	    		}
	    }    
	    
	}
	
	
	
	
}
