package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private BoardUI boardUI;
    private Piece[][] pieces;

    public BoardImpl(BoardUI boardUI){
        this.boardUI=boardUI;
        pieces=new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        for(int i=0;i<pieces.length;i++){
            for(int j=0;j<pieces[i].length;j++){
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
        for(int i=0;i<pieces[col].length;i++){
            if(pieces[col][i].equals(Piece.EMPTY)){
                return i;

            }

        }
        return-1;
    }

    @Override
    public boolean isLegalMove(int col) {


            if(findNextAvailableSpot(col)!=-1){

                return true;

            }


        return false;
    }

    @Override
    public boolean existLegalMoves() {

        for(int i=0;i<NUM_OF_COLS;i++){
            for (int j=0;j<NUM_OF_ROWS;j++){
                if(pieces[i][j].equals(Piece.EMPTY))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        int a= findNextAvailableSpot(col);
        pieces[col][a]=move;
        if(move.equals(Piece.BLUE)) {
            boardUI.update(col, true);
        }else{
            boardUI.update(col, false);
        }

    }

    @Override
    public Winner findWinner() {

         for (int i=0;i<NUM_OF_COLS;i++){
             if(pieces[i][1].equals(pieces[i][2]) && pieces[i][2].equals(pieces[i][3])){
                 if(pieces[i][0].equals(pieces[i][3])){
                     return new Winner(pieces[i][3],i,0,i,3);
                 }
                 if(pieces[i][4].equals(pieces[i][3])){
                     return new Winner(pieces[i][3],i,2,i,4);
                 }

             }

         }
        for (int j = 0; j < NUM_OF_ROWS; j++) {
            if (pieces[2][j].equals(pieces[3][j])){
                if (pieces[0][j].equals(pieces[1][j])&&pieces[1][j].equals(pieces[3][j])&&(!pieces[0][j].equals(Piece.EMPTY))){
                    return new Winner(pieces[3][j],0,j,3,j);
                }
                if (pieces[1][j].equals(pieces[2][j]) && pieces[4][j].equals(pieces[3][j])){
                    return new Winner(pieces[3][j],1,j,4,j);
                }
                if (pieces[5][j].equals(pieces[4][j]) && pieces[4][j].equals(pieces[3][j])){
                    return new Winner(pieces[3][j],2,j,5,j);
                }
            }
        }
         return new Winner(Piece.EMPTY);

    }
}
