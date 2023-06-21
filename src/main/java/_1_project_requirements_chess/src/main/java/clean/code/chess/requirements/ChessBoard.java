package _1_project_requirements_chess.src.main.java.clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate) {
        if (isLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate >= MAX_BOARD_WIDTH) {
            return false;
        }
        if (yCoordinate < 0 || yCoordinate >= MAX_BOARD_HEIGHT) {
            return false;
        }
        return true;
    }
}
