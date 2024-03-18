package lk.ijse.dep.service;

public class AiPlayer extends Player {
    public AiPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {

        int x = colChosser();
        if (x== -1){

            do {

                int range = 6;
                col = (int)(Math.random()*range);

            }while (!board.isLegalMove(col));
        }else {

            col = x;
        }

        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);

        if(board.findWinner().getWinningPiece()!=(Piece.EMPTY)) {
            board.getBoardUI().notifyWinner(board.findWinner());
        }else {
            if (!board.existLegalMoves())  board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }
    }

    private int colChosser() {

        for (int i = 0; i <6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.GREEN);
                if (board.findWinner().getWinningPiece() == Piece.GREEN) {

                    board.updateMove(i, row, Piece.EMPTY);
                    return i;
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);
                }
            }
        }

        for (int i = 0; i <6; i++) {

            if (board.isLegalMove(i) ){
                int row = board.findNextAvailableSpot(i);
                board.updateMove(i,Piece.BLUE);
                if (board.findWinner().getWinningPiece() == Piece.BLUE) {

                    board.updateMove(i, row, Piece.EMPTY);
                    return i;
                }
                else{
                    board.updateMove(i, row, Piece.EMPTY);
                }
            }

        }
        return -1;
    }
}


/*package lk.ijse.dep.service;

public class AiPlayer extends Player {
    
    public AiPlayer(Board board) {
        super(board);
    }

    public void movePiece(int col) {

        col = findBestMove();


        this.board.updateMove(col, Piece.GREEN);
        this.board.getBoardUI().update(col, false);

        if ((board.findWinner().getWinningPiece()).equals(Piece.EMPTY)) {

            if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }

        } else {
            board.getBoardUI().notifyWinner(board.findWinner());
        }

    }


    private int minimax(int depth, boolean maximizingplayer) {

        if (this.board.findWinner().getWinningPiece().equals(Piece.GREEN)) {
            return 1;
        }

        if (this.board.findWinner().getWinningPiece().equals(Piece.BLUE)) {
            return -1;
        }

        if (depth == 4 || !this.board.existLegalMoves()) {
            return 0;
        }

        if (this.board.existLegalMoves()) {
            if (maximizingplayer) {
//            int maxEval = (int) Double.NEGATIVE_INFINITY;
                for (int i = 0; i < this.board.NUM_OF_COLS; i++) {
                    if (this.board.isLegalMove(i)) {
                        int row = this.board.findNextAvailableSpot(i);
                        this.board.updateMove(i, Piece.GREEN);
                        int heuristicVal = minimax(depth + 1, false);
//                    maxEval = Math.max(heuristicVal, maxEval);
                        this.board.updateMove(i, row, Piece.EMPTY);
                        if (heuristicVal == 1) {
                            return heuristicVal;
                        }
                    }

                }
//            return maxEval;
            } else {
//            int minEval = (int) Double.POSITIVE_INFINITY;
                for (int i = 0; i < this.board.NUM_OF_COLS; i++) {
                    if (this.board.isLegalMove(i)) {
                        int row = this.board.findNextAvailableSpot(i);
                        this.board.updateMove(i, Piece.BLUE);
                        int heuristicVal = minimax(depth + 1, true);
//                      minEval = Math.min(heuristicVal, minEval);
                        this.board.updateMove(i, row, Piece.EMPTY);
                        if (heuristicVal == -1) {
                            return heuristicVal;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int findBestMove() {


        boolean userWinningState = false;
        int tiedColumn = 0;

//        if (board.exitLegalMove()) {
        for (int i = 0; i < this.board.NUM_OF_COLS; i++) {
            if (this.board.isLegalMove(i) && this.board.existLegalMoves()) {
                int row = this.board.findNextAvailableSpot(i);
                this.board.updateMove(i, Piece.GREEN);
                int score = minimax(0, false);
                this.board.updateMove(i, row, Piece.EMPTY);

                if (score == 1) {
                    return i;
                }

                if (score == -1) {
                    userWinningState = true;
                } else {
                    tiedColumn = i;
                }
            }
        }

        if ((userWinningState) && (this.board.isLegalMove(tiedColumn))) {
            return tiedColumn;
        }

        int col = 0;

        do {
            col = (int) (Math.random() * 6);
        } while (!this.board.isLegalMove(col));

        return col;
    }
}*/

/*public class AiPlayer extends Player{
    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {
        do {
            col =  (int) (Math.random() * 6);

        }while (!board.isLegalMove(col));

        board.updateMove(col,Piece.GREEN);
        board.getBoardUI().update(col,false);

        if (board.findWinner().getWinningPiece().equals(Piece.EMPTY)) {
            if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner( new Winner(Piece.EMPTY)); //winner kenek nathi hinda
            }
        }else {
            board.getBoardUI().notifyWinner(board.findWinner());
        }

    }
}*/
