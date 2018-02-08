import objectdraw.*;
public class Board extends WindowController {
	
	private Squares[][] squares;
	private Pieces [][] pieces;
	
	public void begin() {
		squares = new Squares[9][9];
		pieces = new Pieces[2][12];
		
		for (int row = 1; row <= 8; row++) {
			for (int col = 1; col <= 8; col++) {
				//squares[row][col] = new Squares(0, row, col);
			}
		}
		
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				pieces[i][j] = new Pieces(i+1, 0, 0);
			}
		}
		
		
		System.out.println(squares[4][5].getRow() + "\t" + squares[2][7].getCol() + "\t" + squares[8][8].getValue());
		
		//Pieces.startingPos(pieces, squares);
	}
}
