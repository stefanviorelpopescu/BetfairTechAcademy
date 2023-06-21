package _1_project_requirements_chess.src.main.java.clean.code.chess.requirements;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate = -1;
    private int yCoordinate = -1;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (chessBoard.isLegalBoardPosition(newX, newY)) {
            return;
        }
        if (movementType == MovementType.MOVE) {
            if (this.xCoordinate != newX) {
                return;
            }
            switch (this.pieceColor) {
                case BLACK:
                    if ((yCoordinate == 6 && newY == 4) || yCoordinate == newY + 1) {
                        this.yCoordinate = newY;
                    }
                    break;
                case WHITE:
                    if ((yCoordinate == 1 && newY == 3) || yCoordinate == newY - 1) {
                        this.yCoordinate = newY;
                    }
                    break;
            }
        }
        if (movementType == MovementType.CAPTURE) {
            switch (this.pieceColor) {
                case BLACK:
                    if (yCoordinate == newY + 1 && Math.abs(xCoordinate - newX) == 1) {
                        this.setXCoordinate(newX);
                        this.setYCoordinate(newY);
                    }
                    break;
                case WHITE:
                    if (yCoordinate == newY - 1 && Math.abs(xCoordinate - newX) == 1) {
                        this.setXCoordinate(newX);
                        this.setYCoordinate(newY);
                    }
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: %s%dCurrent Y: %d%sPiece Color: %s", eol, xCoordinate, yCoordinate, eol, pieceColor);
    }
}
