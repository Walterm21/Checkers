//Parker Scanlon

//Program that will run the game and user interface
//Uses the Square and Pieces classes
import java.awt.Color;

import objectdraw.*;
public class Game extends WindowController {
	
	private Square[][] board;
	private Piece [][] pieces;
	private int turn = 0;
	private Location lastPoint;
	private boolean pieceSelect;
	private int selectedPiece, selectedSquare;
	
	//turn is which player turn
	//0 is blue, 1 is green
	
	//set up and start the game
	public void begin() {
		
		//setting size for the board
		int size = 0;
		if (canvas.getHeight() > canvas.getWidth()) size = canvas.getHeight();
		else size = canvas.getWidth();
		size /= 8;
		
		//declaring piece and square arrays
		//note, squares are 9x9, but the 0 rows are not used, makes it easier to call the squares and visualize it
		board = new Square[9][9];
		pieces = new Piece[2][12];
		
		//making the board
		for (int row = 1; row <= 8; row++) {
			for (int col = 1; col <= 8; col++) {
				board[row][col] = new Square(0, row, col, new Location((row - 1) * size, (col - 1) * size), size, canvas);
				board[row][col].setColor(Color.BLACK, Color.RED);
			}
		}
		
		//making the pieces
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				pieces[i][j] = new Piece(i+1, 0, 0, new Location(0, 0), size, canvas);
			}
		}
		
		
		//Pieces test = new Pieces(0, 2, 3, new Location(1 * size, 2 * size), size, canvas);
		//test.setColor(Color.YELLOW);
		
		
		//System.out.println(board[4][5].getRow() + "\t" + board[2][7].getCol() + "\t" + board[8][8].getValue());
		
		Piece.startingPos(pieces, board);
	}
	
	//onMousePress and onMouseRelease will be the two main methods, and the program will react differently depending on where and when the ouse is pressed and released
	
	public void onMousePress(Location point) {
		lastPoint = point;
		//if (turn == 0) {
			for (int j = 0; j < 12; j++) {
				if (pieces[turn][j].getOnBoard()) {
					if (pieceSelect = pieces[turn][j].contains(point)) {
						selectedPiece = j;
						return;
					}
				}
			}
		
		/*else {
			for (int j = 0; j < 12; j++) {
				if (pieces[1][j].getOnBoard()) {
					if (pieceSelect = pieces[1][j].getCircle().contains(point)) {
						selectedPiece = j;
						return;
					}
				}
			}
		}*/
		
		
		
	}
	
	
	public void onMouseDrag(Location point) {
		
		
		if (pieceSelect) {
			//pieces[turn][selectedPiece].getCircle().moveTo( point.getX()+point.getX() - lastPoint.getX(),point.getY()+point.getY() - lastPoint.getY() );
			pieces[turn][selectedPiece].getCircle().move( point.getX() - lastPoint.getX(), point.getY() - lastPoint.getY() );
			lastPoint = point;
		}
	}
	
	
	public void onMouseRelease(Location point) {
		//if a piece has been selected
		if (pieceSelect) {
			//loops through squares to see where piece was released
			for (int row = 1; row <= 8; row++) {
				for (int col = 1; col <= 8; col++) {
					if (board[row][col].contains(point)) {
						
						//does not seem to allow any move
						//if (pieces[turn][selectedPiece].isValidMove(board[row][col], board)) { 
							//had to switch col and row, could be a concern later
							pieces[turn][selectedPiece].moveTo(board, col, row);
							
							//changed turn when move has been made
							if (turn == 0) turn++;
							else turn--;
							
							//will check if any valid moves are available
							return;
						
						//}
					}
			
				}
			}
		}
	}
	
	
	
	
	
	
}
