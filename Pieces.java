import objectdraw.*;
import java.awt.*;
import java.util.*;
public class Pieces {		
	
	private int value = 0,
			row = 0,
			col = 0;
	private Location pos;
	
	private boolean onBoard = true;
	//if the piece is still alive in the game
	//will be changed to false when it is taken
	
	
	/*
	 * pieces constructor
	 * has an int for piece : 1 = white, 2 = red, 3 = white king, 4 = red king
	 * other values will result in a 0 piece (empty / null piece)
	 * 
	 * row and col are for the coordinates
	 */
	public Pieces(int value, int row, int col) {
		if (value >= 1 & value <= 4)
			this.value = value;
		else this.value = 0;
		
		
		if (row >= 1 & row <= 8)
			this.row = row;
		else this.row = 0;
		
		
		if (col >= 1 & col <= 8)
			this.col = col;
		else this.col = 0;
		
		pos = new Location(row, col);
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
	
	public Location getPos() {
		return pos;
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
			pos.translate(pos.getX() - row, 0);
		}
	}
	
	public void setCol(int col) {
		if (col >= 1 & col <= 8) {
			this.col = col;
			pos.translate(0, pos.getY() - col);
		}
	}
	
	public void setPos(int row, int col) {
		if (row >= 1 & row <= 8)
			if (col >= 1 & col <= 8) {
				this.row = row;
				this.col = col;
				pos = new Location(row, col);
			}
	}
	
	public void moveTo(Squares[][] squares, int row, int col) {
		
		squares[this.row][this.col].setValue(0);
		
		//sets the position of the piece using the square it is on
		setPos(squares[row][col].getRow(), squares[row][col].getCol());
		
		//sets the value of the square using the piece on the square
		squares[row][col].setValue(value);
	}
	
	public static void startingPos(Pieces[][] pieces, Squares[][] squares) {
	
		//white pieces
		for (int j = 0; j < 12; j++) {
			for (int row = 1; row <= 3; row++) {
				for (int col = 1; col <= 8;)
				//if the row is odd, set the pieces to col 1, 3, 5, 7 
				if (row % 2 == 1) {
					pieces[1][j].moveTo(squares, row, col);
					col += 2;
				}
				
				//if the row is even, set the pieces to col 2, 4, 6 , 8
				else {
					col++;
					pieces[1][j].moveTo(squares, row, col);
					col++;
				}
			}
		}
		
		//red pieces
		for (int j = 0; j < 12; j++) {
			for (int row = 6; row <= 8; row++) {
				for (int col = 1; col <= 8;)
				//if the row is odd, set the pieces to col 1, 3, 5, 7 
				if (row % 2 == 1) {
					pieces[2][j].moveTo(squares, row, col);
					col += 2;
				}
				//if the row is even, set the pieces to col 2, 4, 6 , 8
				else {
					col++;
					pieces[2][j].moveTo(squares, row, col);
					col++;
				}
			}
		}
		
	
	}
	
	
	
	public void taken() {
		onBoard = false;
	}
	
	
	public boolean isValidMove(Squares squares, Squares[][] squaresArray) {
		
		int rowDif = row - squares.getRow(), colDif = col - squares.getCol();
	
		//if the square is not empty, you cannot move there!!!
		if (squares.getValue() != 0) 
			return false;
		
		//if the move is directly vertical or horizontal, it is illegal
		else if (rowDif == 0 || colDif == 0)
			return false;
		
		//if the move is not diagonal, it is illegal
		else if (rowDif / colDif != 1 || rowDif / colDif != -1)
			return false;
		
		
		
		//white regular piece
		if (value == 1) {
			//up 1
			if (rowDif == 1) {
				//over one to either side
				return (colDif == 1 || colDif == -1);
			}
			
			//up 2
			else if (rowDif == 2) {
				if (colDif == 2) 
					return (squaresArray[row+1][col+1].getValue() == 2 || squaresArray[row+1][col+1].getValue() == 4); 
				
				else
					return (squaresArray[row-1][col-1].getValue() == 2 || squaresArray[row-1][col-1].getValue() == 4);
				
				}
			}
		return false;
		}
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	/*		
			
			// Board starts at bottom left as a black square 1,1
	 
	//regular white pieces 
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

