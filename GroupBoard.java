import java.awt.*;
import objectdraw.*;


public class GroupBoard {
 
	  
	  private double startX, startY,
	                  endX, endY;
	  private DrawingCanvas canvas;
	  
	  private double resolution,
	                  increment;
	  
	  private int squareCount;
	  
	  private Color oneColor,
	                twoColor;
	                
	  private FramedRect frame;
	  
	  private int numSquare;
	  
	  private Location loc;
	  
	  public final String[] grid = { "A1",
	                          "A2",
	                          "A3",
	                          "A4",
	                          "A5",
	                          "A6",
	                          "A7",
	                          "A8",
	                          "B1",
	                          "B2",
	                          "B3",
	                          "B4",
	                          "B5",
	                          "B6",
	                          "B7",
	                          "B8",
	                          "C1",
	                          "C2",
	                          "C3",
	                          "C4",
	                          "C5",
	                          "C6",
	                          "C7",
	                          "C8",
	                          "D1",
	                          "D2",
	                          "D3",
	                          "D4",
	                          "D5",
	                          "D6",
	                          "D7",
	                          "D8",
	                          "E1",
	                          "E2",
	                          "E3",
	                          "E4",
	                          "E5",
	                          "E6",
	                          "E7",
	                          "E8",
	                          "F1",
	                          "F2",
	                          "F3",
	                          "F4",
	                          "F5",
	                          "F6",
	                          "F7",
	                          "F8",
	                          "G1",
	                          "G2",
	                          "G3",
	                          "G4",
	                          "G5",
	                          "G6",
	                          "G7",
	                          "G8",
	                          "H1",
	                          "H2",
	                          "H3",
	                          "H4",
	                          "H5",
	                          "H6",
	                          "H7",
	                          "H8"};
	  
	  
	  private Squares[][] chessGrid;
	  
	  
	  public GroupBoard(double sX, double sY, double sSize, DrawingCanvas c){
	    
	    startX = sX;
	    startY = sY;
	    canvas = c;
	    
	    increment = sSize;

	    resolution = increment*8;
	    
	    loc = new Location(startX,startY);
	    
	    frame = new FramedRect(loc, startX+resolution, startY+resolution, canvas);
	    
	    chessGrid = new Squares[8][8];
	    
	    for (int row = 0; row < 8; row++){
	      for (int col = 0; col < 8; col++){
	        numSquare = row*8 + col;
	        
	        chessGrid[row][col] = new Squares(startX, startY, increment, numSquare, 0, canvas);
	        
	        
	        startX+= increment;
	        
	      }
	      
	      startY+= increment;
	      startX -= resolution;
	      
	    }
	  }
	    
	  public GroupBoard(Location point, double sSize, DrawingCanvas c){
	    
	    startX = point.getX();
	    startY = point.getY();
	    canvas = c;
	    
	    increment = sSize;

	    resolution = increment*8;
	    
	    loc = new Location(startX,startY);
	    
	    new GroupBoard(startX, startY, increment, canvas);
	    
	     
	    
	    
	  }
	  
	  public GroupBoard (DrawingCanvas c){
	    
	    startX = 0;
	    startY = 0;
	    canvas = c;
	    
	    if (canvas.getWidth()>canvas.getHeight()){
	      
	     increment = canvas.getHeight()/8;
	    }
	    
	    else {
	      
	      increment = canvas.getWidth()/8;
	    }
	    
	    loc = new Location(startX,startY);
	    
	    new GroupBoard (startX, startY, increment, canvas);
	    
	  }

	  
	  public void setColor(Color one, Color two){
	    oneColor = one;
	    twoColor = two;
	    
	    
	    for (int row = 0; row < 8; row++){
	      for (int col = 0; col < 8; col++){
	        numSquare = row*8 + col;
	        
	        chessGrid[row][col].setColor(oneColor, twoColor);
	        
	      }
	      
	      
	    }


	  }
	  
	  
	  
	}

	
	
	
	
	
	
	
	
	/* 
	private double startX, startY, endX, endY;
	private DrawingCanvas canvas;

	private double resolution, increment;

	private int squareCount;

	private Color oneColor, twoColor;
  
	private FramedRect frame;

	private double numSquare;

	private Location loc;

	public static final String[] grid = { "A1",
            "A2",
            "A3",
            "A4",
            "A5",
            "A6",
            "A7",
            "A8",
            "B1",
            "B2",
            "B3",
            "B4",
            "B5",
            "B6",
            "B7",
            "B8",
            "C1",
            "C2",
            "C3",
            "C4",
            "C5",
            "C6",
            "C7",
            "C8",
            "D1",
            "D2",
            "D3",
            "D4",
            "D5",
            "D6",
            "D7",
            "D8",
            "E1",
            "E2",
            "E3",
            "E4",
            "E5",
            "E6",
            "E7",
            "E8",
            "F1",
            "F2",
            "F3",
            "F4",
            "F5",
            "F6",
            "F7",
            "F8",
            "G1",
            "G2",
            "G3",
            "G4",
            "G5",
            "G6",
            "G7",
            "G8",
            "H1",
            "H2",
            "H3",
            "H4",
            "H5",
            "H6",
            "H7",
            "H8"}
            ;

	private Squares[][] chessGrid;


	public GroupBoard(double sX, double sY, double sSize, DrawingCanvas c){

		startX = sX;
		startY = sY;
		canvas = c;

		increment = sSize;

		resolution = increment*8;

		loc = new Location(startX,startY);

		frame = new FramedRect(loc, startX+resolution, startY+resolution, canvas);

		chessGrid = new Squares[8][8];

		for (int row = 0; row < 8; row++){
			for (int col = 0; col < 8; col++){
				numSquare = row*8 + col;

				chessGrid[row][col] = new Squares(loc, increment, numSquare, grid[(int) numSquare], canvas);


				loc.translate(increment,0);

			}

		loc.translate(-resolution,increment);
		}

	}

	public GroupBoard (Location point, double sSize, DrawingCanvas c){

		startX = point.getX();
		startY = point.getY();
		canvas = c;

		increment = sSize;

		resolution = increment*8;

		loc = new Location(startX,startY);

		new GroupBoard(startX, startY, increment, canvas);




}

	public GroupBoard(double sX, double sY, DrawingCanvas c){

		startX = sX;
		startY = sY;
		canvas = c;

		if (canvas.getWidth()>canvas.getHeight()){

			increment = canvas.getHeight()/8;
		}

		else {

			increment = canvas.getWidth()/8;
		}

		loc = new Location(startX,startY);

		new GroupBoard(startX, startY, increment, canvas);

	}


	public GroupBoard(Location point, DrawingCanvas c){

		startX = point.getX();
		startY = point.getY();
		canvas = c;

		if (canvas.getWidth()>canvas.getHeight()){

			increment = canvas.getHeight()/8;
		}

		else {

			increment = canvas.getWidth()/8;
		}

		loc = new Location(startX,startY);

		new GroupBoard(startX, startY, increment, canvas);
	}


	public void setColor(Color one, Color two){
		oneColor = one;
		twoColor = two;


		for (int row = 0; row < 8; row++){
			for (int col = 0; col < 8; col++){
				numSquare = row*8 + col;

				chessGrid[row][col].setColor(oneColor, twoColor);

			}


		}


	}





}


	
	
	
	
	
	
	
  private double startX, startY,
                  endX, endY;
  private DrawingCanvas canvas;
  
  private double resolution,
                  increment;
  
  private int squareCount;
  
  private Color oneColor,
                twoColor;
                
  private FramedRect frame;
  
  private double numSquare;
  
  private Location loc;
  
  public final String[] grid = {"A1",
                          "A2",
                          "A3",
                          "A4",
                          "A5",
                          "A6",
                          "A7",
                          "A8",
                          "B1",
                          "B2",
                          "B3",
                          "B4",
                          "B5",
                          "B6",
                          "B7",
                          "B8",
                          "C1",
                          "C2",
                          "C3",
                          "C4",
                          "C5",
                          "C6",
                          "C7",
                          "C8",
                          "D1",
                          "D2",
                          "D3",
                          "D4",
                          "D5",
                          "D6",
                          "D7",
                          "D8",
                          "E1",
                          "E2",
                          "E3",
                          "E4",
                          "E5",
                          "E6",
                          "E7",
                          "E8",
                          "F1",
                          "F2",
                          "F3",
                          "F4",
                          "F5",
                          "F6",
                          "F7",
                          "F8",
                          "G1",
                          "G2",
                          "G3",
                          "G4",
                          "G5",
                          "G6",
                          "G7",
                          "G8",
                          "H1",
                          "H2",
                          "H3",
                          "H4",
                          "H5",
                          "H6",
                          "H7",
                          "H8"
  };
  
  
  private Squares[][] chessGrid;
  
  
  public GroupBoard(double sX, double sY, double sSize, DrawingCanvas c){
    
    startX = sX;
    startY = sY;
    canvas = c;
    
    increment = sSize;

    resolution = increment*8;
    
    loc = new Location(startX,startY);
    
    frame = new FramedRect(loc, startX+resolution, startY+resolution, canvas);
    
    chessGrid = new Squares[8][8];
    
    for (int row = 0; row < 8; row++){
      for (int col = 0; col < 8; col++){
        numSquare = row*8 + col;
        
        chessGrid[col][row] = new Squares(loc, increment, numSquare, grid[(int) numSquare], canvas);
        //chessGrid[col][row] = new Squares(loc, increment, row, col, grid[(int) numSquare], canvas);
        
        
        loc.translate(increment,0);
        
      }
      
     loc.translate(-resolution,increment);
     }
      
    }
    
  public GroupBoard(Location point, double sSize, DrawingCanvas c){
    
    startX = point.getX();
    startY = point.getY();
    canvas = c;
    
    increment = sSize;

    resolution = increment*8;
    
    loc = new Location(startX,startY);
    
    new GroupBoard(startX, startY, increment, canvas);
    
     
    
    
  }
  
  public void setColor(Color one, Color two){
    oneColor = one;
    twoColor = two;



  }
  
  
  */
	  
	


