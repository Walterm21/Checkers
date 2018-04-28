import objectdraw.*;
import java.awt.*;
import java.util.*;
public class Piece extends FilledOval {		
	
	private int value = 0,
			row = 0,
			col = 0;
	
	private Location loc;
	  
	private int size;
	  
	private FilledOval circle, 
			kingCircle;
	  
	private DrawingCanvas canvas;
	
	private boolean onBoard = true;
	//if the piece is still alive in the game
	//will be changed to false when it is taken
	
	
	/*
	 * pieces constructor
	 * has an int for piece : 1 = blue, 2 = red, 3 = blue king, 4 = red king
	 * other values will result in a 0 piece (empty / null piece)
	 * 
	 * row and col are for the coordinates
	 */
	public Piece(int value, int row, int col, Location loc, int size, DrawingCanvas canvas) {
		super (loc, size, size, canvas);
		//super makes a filled oval, but I made a variable 'circle' to refrer to the oval i will use in the game
		super.removeFromCanvas();
		
		this.circle = new FilledOval(loc,size,size,canvas);
		if (value == 1) {
			this.circle.setColor(Color.BLUE);
		}
		
		else if (value == 2) {
			this.circle.setColor(Color.GREEN);
		}
		
		
		
		
		this.loc = loc;
		this.size = size;
		this.canvas = canvas;
	
		//setting value, row, and col
		if (value >= 1 & value <= 4)
			this.value = value;
		else this.value = 0;
		
		
		if (row >= 1 & row <= 8)
			this.row = row;
		else this.row = 0;
		
		
		if (col >= 1 & col <= 8)
			this.col = col;
		else this.col = 0;
		
	}
	
	//--------------------------------------------------------------------------------------------------------
	//accessors
	//--------------------------------------------------------------------------------------------------------
	
	public int getValue() {
		return value;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public Location getLoc() {
		return loc;
	}
	
	public boolean getOnBoard() {
		return onBoard;
	}
	
	public boolean contains(Location point) {
		return circle.contains(point);
	}
	
	public FilledOval getCircle() {
		return circle;
	}
	
	
	//--------------------------------------------------------------------------------------------------------
	//mutators
	//--------------------------------------------------------------------------------------------------------
	
	
	//note: this mutator should not be used in the regular playing of the game
	public void setValue(int value) {
		if (value >= 1 & value <= 4)
			this.value = value;
	}
	
	public void setRow(int row) {
		if (row >= 1 & row <= 8) {
			this.row = row;
			loc.translate(loc.getX() - row, 0);
		}
	}
	
	public void setCol(int col) {
		if (col >= 1 & col <= 8) {
			this.col = col;
			loc.translate(0, loc.getY() - col);
		}
	}
	
	public void setLoc(int row, int col) {
		if (row >= 1 & row <= 8)
			if (col >= 1 & col <= 8) {
				//this.row = row;
				//this.col = col;
				loc = new Location(row, col);
			}
	}
	
	public void setColor(Color c) {
		circle.setColor(c);
	}
	
	public void moveTo(Square[][] squares, int row, int col) {
		//Col is x, row is Y
		if ((this.row >= 1 && this.row <= 8) && (this.col >= 1 && this.col <= 8)) {
		squares[this.col][this.row].setValue(0);
		}
		else System.out.print("Something went wrong");
		//sets the position of the piece using the square it is on
		
		setRow(row);
		setCol(col);
		setLoc(row * size, col * size);//squares[row][col].getRow(), squares[row][col].getCol());
		
		circle.moveTo(row * size - size, col * size - size);
		
		//sets the value of the square using the piece on the square
		squares[col][row].setValue(value);
	}
	
	public static void startingPos(Piece[][] pieces, Square[][] squares) {
	
		int row = 1, col = 1;
		//blue pieces
		for (int j = 0; j < 12; j++) {
			//red pieces only occupy the first 3 rows at start
			//if the row is odd, set the pieces to col 1, 3, 5, 7 
			
			if (col > 8) {
				row++;
				col = 1;
			}
			
			if (row % 2 == 1) {
				col++;
				pieces[0][j].moveTo(squares, col, row);
				col++;
			}
				
			//if the row is even, set the pieces to col 2, 4, 6 , 8
			else {
				pieces[0][j].moveTo(squares, col, row);
				col+=2;
			}
		}
				
		row = 6; col = 1;
		//red pieces
		for (int j = 0; j < 12; j++) {
			//green pieces only occupy last 3 rows at start
//if the row is odd, set the pieces to col 1, 3, 5, 7 
			
			if (col > 8) {
				row++;
				col = 1;
			}
			
			if (row % 2 == 1) {
				col++;
				pieces[1][j].moveTo(squares, col, row);
				col++;
			}
				
			//if the row is even, set the pieces to col 2, 4, 6 , 8
			else {
				pieces[1][j].moveTo(squares, col, row);
				col+=2;
			}
		}
		
		
	
	}
	
	
	
	public void taken() {
		onBoard = false;
		value = 0;
		circle.moveTo(0-size, 0 - size);
	}
	
	
	public boolean isValidMove(Square squares, Square[][] squaresArray) {
		
		int rowDif = row - squares.getRow(), colDif = col - squares.getCol();
		
		//if the square is not empty, you cannot move there!!!
		if (squares.getValue() != 0) { 
			//System.out.println(rowDif);
			//System.out.println(colDif);
			System.out.println("AAA");
			return false;
		}
		
		//if the move is directly vertical or horizontal, it is illegal
		if (rowDif == 0 || colDif == 0) {
			//System.out.println(rowDif);
			//System.out.println(colDif);
			System.out.println("BBB");
			return false;
		}
		
		
		double dif = rowDif + 0.0 / colDif;
		//if the move is not diagonal, it is illegal
		if (dif == 1 || dif == -1) {
			//System.out.println("Row dif is " + rowDif);
			//System.out.println("Col dif is " + colDif);
			System.out.println(dif);
			System.out.println("CCC");
			return true;
		}
		
		else {
			//System.out.println("Row dif is " + rowDif);
			//System.out.println("Col dif is " + colDif);
			System.out.println(dif);
			System.out.println("DDD");
			return false;
		}
		/*
		
		
		//blue regular piece
		if (value == 1) {
			//down 1
			if (rowDif == 1) {
				//over one to either side
				return (colDif == 1 || colDif == -1);
			}
			
			//down 2
			else if (rowDif == 2) {
				if (colDif == 2) 
					return (squaresArray[row+1][col+1].getValue() == 2 || squaresArray[row+1][col+1].getValue() == 4); 
				
				else
					return (squaresArray[row+1][col-1].getValue() == 2 || squaresArray[row+1][col-1].getValue() == 4);
				
				}
			return false;
		}	
		
		//blue king
		else if (value == 3) {
			
			//up or down 1
			if (rowDif == 1 || rowDif == -1) {
				//over one to either side
				return (colDif == 1 || colDif == -1);
			}
			
			//down 2
			else if (rowDif == 2) {
				if (colDif == 2) 
					return (squaresArray[row+1][col+1].getValue() == 2 || squaresArray[row+1][col+1].getValue() == 4); 
				
				else
					return (squaresArray[row+1][col-1].getValue() == 2 || squaresArray[row+1][col-1].getValue() == 4);
				
			}
			
			//up 2
			else if (rowDif == -2) {
				if (colDif == 2) 
					return (squaresArray[row-1][col+1].getValue() == 2 || squaresArray[row-1][col+1].getValue() == 4); 
			
				else
					return (squaresArray[row-1][col-1].getValue() == 2 || squaresArray[row-1][col-1].getValue() == 4);
			
			}

			return false;
		}
		
		//green regular piece
		else if (value == 2) {
			//up 1
			if (rowDif == -1) {
				//over one to either side
				return (colDif == 1 || colDif == -1);
			}
			
			//up 2
			else if (rowDif == -2) {
				if (colDif == 2) 
					return (squaresArray[row-1][col+1].getValue() == 1 || squaresArray[row-1][col+1].getValue() == 3); 
				
				else
					return (squaresArray[row-1][col-1].getValue() == 1 || squaresArray[row-1][col-1].getValue() == 3);
				
				}
		return false;
			
			
		}
		
		//green king
		else if (value == 4) {
			
			//up or down 1
			if (rowDif == 1 || rowDif == -1) {
				//over one to either side
				return (colDif == 1 || colDif == -1);
			}
			
			//down 2
			else if (rowDif == 2) {
				if (colDif == 2) 
					return (squaresArray[row+1][col+1].getValue() == 1 || squaresArray[row+1][col+1].getValue() == 3); 
				
				else
					return (squaresArray[row+1][col-1].getValue() == 1 || squaresArray[row+1][col-1].getValue() == 3);
				
			}
			
			//up 2
			else if (rowDif == -2) {
				if (colDif == 2) 
					return (squaresArray[row-1][col+1].getValue() == 1 || squaresArray[row-1][col+1].getValue() == 3); 
			
				else
					return (squaresArray[row-1][col-1].getValue() == 1 || squaresArray[row-1][col-1].getValue() == 3);
			
			}

			return false;
		}
		
		return false;
		*/
	}
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	/*		
			
			// Board starts at bottom left as a green square 1,1
	 
	//regular blue pieces 
	if (value == 1) {
		//if the row is even (1,3,5,7)
		if (row%2 == 1) {
			//last col (next to side of board)
			if (col == 8) {
				//look only at row+1 and col 7
			}
			//any other col
			else {
				//look at row+1 and col +/- 1
			}
		
		}
		//if row is odd (2,4,6)
		else {
			//first col (next to side)
			if (col == 1) {
				//look only at row+1 and col 2
			}
			//any other col
			else {
				//look at row+1 and col +/- 1
			}
		}
		
	}
	
	
	return true;
	*/
		
		
	
	
	
	
		
}

