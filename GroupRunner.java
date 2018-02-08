import objectdraw.*;
import java.awt.*;

public class GroupRunner extends WindowController {

	private GroupBoard board;
	private GroupSquares squares;
	
	
	public void begin() {
		board = new GroupBoard(0, 0, 200/8.0, canvas);
		//squares = new GroupSquares
		
	}
	
	public void onMouseClick(Location point) {
		board.setColor(Color.MAGENTA, Color.PINK);
	}
	
}
