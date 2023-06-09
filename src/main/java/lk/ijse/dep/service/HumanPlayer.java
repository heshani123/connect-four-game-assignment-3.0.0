package lk.ijse.dep.service;

public class HumanPlayer extends Player {
    public HumanPlayer(Board board) {
        super(board);

    }

    @Override
    public void movePiece(int col) {
        System.out.println(col);
        if (board.isLegalMove(col)) {
            board.updateMove(col, Piece.BLUE);

        }
        Winner ob = board.findWinner();
        if(!ob.getWinningPiece().equals(Piece.EMPTY))
        {
            System.out.println(ob);
            board.getBoardUI().notifyWinner(ob);
        }
    }

}

