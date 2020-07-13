import Domain.Piece;

import java.util.ArrayList;

public class Player {
    boolean isWhite;
    ArrayList<Piece> allPieces = new ArrayList<Piece>(32);
    ArrayList<Piece> currentPieces = new ArrayList<Piece>(32);

    public Player(boolean isWhite){
        this.isWhite=isWhite;
    }

    public ArrayList<Piece> getAllPieces(){
        return allPieces;
    }

    public ArrayList<Piece> getCurrentPieces(){
        return allPieces;
    }

    public void deletePiece(Piece p){
        currentPieces.remove(p);
    }

    public void modifyPiece(Piece oldPiece, Piece newPiece){
        currentPieces.remove(oldPiece);
        currentPieces.add(newPiece);
    }
}
