package Domain;

public class Pawn extends Piece{
    public Pawn(Square square,boolean isWhite){
        super(square, isWhite);
        if(isWhite) symbol='P';
        else symbol='p';
        square.setSymbol(symbol);
    }

    @Override
    public void move(int newLine, int newColumn) throws DomainException {
        if(this.getColumn()!=newColumn)
            throw new DomainException("invalid move. the pawn can not move between columns. \n" +
                    "maybe you wanted to capture a piece");
        if(!((newLine==this.getLine()+1 && this.getIsWhite())
                ||(newLine==this.getLine()-1 && !this.getIsWhite())))
            throw new DomainException("invalid move. the pawn can only move one line each time towards the enemy.");
        this.setLine(newLine);
        this.setColumn(newColumn);
    }

    @Override
    public void capture(int newLine, int newColumn) throws DomainException {
        if(!((newColumn==this.getColumn()+1 && this.getIsWhite())
                ||(newColumn==this.getColumn()-1)&&!this.getIsWhite()))
            throw new DomainException("invalid move. the pawn can capture only diagonally towards the enemy");
        if(!((newLine==this.getLine()+1 && this.getIsWhite())
                ||(newLine==this.getLine()-1)&&!this.getIsWhite()))
            throw new DomainException("invalid move. the pawn can capture only diagonally towards the enemy");
        this.setLine(newLine);
        this.setColumn(newColumn);
    }
}
