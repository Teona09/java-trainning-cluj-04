package Domain;

import java.util.Objects;

public class Square {
    int line,column;
    boolean isOccupied;
    char symbol;

    public Square(int x, int y, boolean oc,char sym){
        line=x;
        column=y;
        isOccupied=oc;
        symbol = sym;
    }

    public Square(Square oldSquare){
        this.line=oldSquare.getLine();
        this.column=oldSquare.getColumn();
        this.isOccupied=oldSquare.getIsOccupied();
        this.symbol=oldSquare.getSymbol();
    }

    public void setLine(int x){line=x;}
    public void setColumn(int y){column=y;}
    public void setOccupied(boolean oc){isOccupied = oc;}
    public void setSymbol(char sym){symbol=sym;}

    public int getColumn() {
        return column;
    }
    public int getLine(){
        return line;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public char getSymbol(){
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return getLine() == square.getLine() &&
                getColumn() == square.getColumn() &&
                isOccupied == square.isOccupied &&
                getSymbol() == square.getSymbol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLine(), getColumn(), isOccupied, getSymbol());
    }
}