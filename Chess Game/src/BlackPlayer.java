import Domain.Pawn;
import Domain.Piece;
import Domain.Square;

public class BlackPlayer extends Player{
    public BlackPlayer(boolean isWhite) {
        super(isWhite);
        for(int column=0;column<=7;column++){
            Piece p = new Pawn(new Square(6,column,true,'p'),isWhite);
            allPieces.add(p);
            currentPieces.add(p);
        }
    }
}
