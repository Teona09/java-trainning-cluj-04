import Domain.Pawn;
import Domain.Piece;
import Domain.Square;

public class WhitePlayer extends Player{
    public WhitePlayer(boolean isWhite) {
        super(isWhite);
        for(int column=0;column<=7;column++){
            Piece p = new Pawn(new Square(1,column,true,'P'),isWhite);
            allPieces.add(p);
            currentPieces.add(p);
        }
    }
}
