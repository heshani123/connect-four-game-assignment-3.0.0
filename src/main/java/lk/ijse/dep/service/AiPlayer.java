package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player{
        public AiPlayer(Board board){
            super(board);
        }

        @Override
        public void movePiece(int col) {
            Random r = new Random();
            do{
                col=r.nextInt(6);
            }while(!board.isLegalMove(col));
            System.out.println("Clicked");
            if(board.isLegalMove(col)){
                board.updateMove(col,Piece.GREEN);

            }
            Winner ob = board.findWinner();
            if(!ob.getWinningPiece().equals(Piece.EMPTY))
            {
                System.out.println(ob);
                board.getBoardUI().notifyWinner(ob);
            }


        }
    }

