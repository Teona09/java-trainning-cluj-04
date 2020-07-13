package Domain;

public abstract class Piece {
    Square square;
    boolean onBoard;
    boolean isWhite;
    char symbol;

    public abstract void move(int newLine, int newColumn) throws DomainException;
    public abstract void capture(int newLine, int newColumn) throws DomainException;

    public Piece(Square square, boolean isWhite){
        this.square=square;
        this.isWhite=isWhite;
        this.onBoard = true;
    }

    public boolean getOnBoard(){ return onBoard;}
    public int getLine(){ return square.getLine(); }
    public int getColumn(){ return square.getColumn(); }
    public boolean getIsWhite(){ return isWhite; }
    public Square getSquare(){return square;}
    public char getSymbol(){return symbol;};

    public void setOnBoard(boolean ok){onBoard=ok;}
    public void setIsWhite(boolean ok){isWhite=ok;}
    public void setLine(int x){this.square.setLine(x);};
    public void setColumn(int y){this.square.setColumn(y);};
}
