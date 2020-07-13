import Domain.DomainException;

public class Main {
    public static void main(String[] args) throws DomainException {
        ChessBoard board = new ChessBoard();
        System.out.println("we will use capital letters for white pieces and lower letters for black pieces");
        System.out.println("on this board we only have pawns");
        board.showBoard();
        System.out.println("we will move the white pawn from 1-1 to 5-1 using multiple moves");
        board.makeMove(1, 1, 2, 1);
        board.showBoard();
        board.makeMove(2, 1, 3, 1);
        board.showBoard();
        board.makeMove(3, 1, 4, 1);
        board.showBoard();
        board.makeMove(4, 1, 5, 1);
        board.showBoard();
        System.out.println("the white pawn we kept moving will capture a black pawn");
        board.makeMove(5, 1, 6, 2);
        board.showBoard();
        System.out.println("the black pawn from 6-2 was captured");
    }

}