package lk.ijse.dep.service;

public class BoardImpl implements Board {

    private Piece[][] pieces;
    private BoardUI boardUI;
    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;

        Piece [][] pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        for (int i = 0; i <pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }
    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < pieces[col].length; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }
}
