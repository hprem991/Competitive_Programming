// Piece Games
class Piece {
	public int m_curPos_x;
	public int m_curPos_y;
	
	public boolean isValidMove(int x, int y) {return false;};
	public void move(int x, int y) {
		m_curPos_x = x;
		m_curPos_y = y;
	};
}

class Rook implements Piece {
	public boolean move(int x, int y) {
		if(isValidMove(x, y)) {
			super.move(x, y);
		}
	}
	
	public boolean isValidMove(int x, int y) {
		// Implement the Rooks Valid Move
		
	}
}

class Game {
	// Interfaces
}

class Chess implements Game {
	int board[][];
	// This is a Choice of DS
	Map<String, ArrayList<Piece>> pieces = new HashMap<String, ArrayList<Piece>>();
	public Game(int boardSize) {
			InitializeBoard(boardSize);
	}
	
	void InitializeBoard(int boardSize) {
		board = new int[boardSize][boardSize];
		InitializePieces();
	}
	
	void InitializePiecs() {
		
	}
}
