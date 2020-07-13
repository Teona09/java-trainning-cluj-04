import Domain.DomainException;
import Domain.Square;
import Domain.Piece;

import java.util.ArrayList;

public class ChessBoard {
    Square[][] board;
    Player whitePlayer;
    Player blackPlayer;
    ArrayList<Piece> currentPieces= new ArrayList<Piece>(32);

    public ChessBoard() {
        whitePlayer = new WhitePlayer(true);
        blackPlayer = new BlackPlayer(false);
        //ArrayList<Piece> currentPieces = new ArrayList<Piece>(32);
        currentPieces = whitePlayer.getCurrentPieces();
        currentPieces.addAll(blackPlayer.getCurrentPieces());
        board = new Square[8][8];
        for (int i = 7; i >= 0; i--)
            for (int j = 0; j <= 7; j++) {
                board[i][j] = new Square(i, j, false, '#');
            }
        for (Piece p : currentPieces) {
            board[p.getLine()][p.getColumn()] = p.getSquare();
        }
    }

    public void updateBoard() {
        currentPieces.clear();
        currentPieces = whitePlayer.getCurrentPieces();
        currentPieces.addAll(blackPlayer.getCurrentPieces());
        for (Piece p : currentPieces) {
            if (!board[p.getLine()][p.getColumn()].equals(p.getSquare()))
                board[p.getLine()][p.getColumn()].setOccupied(true);
            board[p.getLine()][p.getColumn()].setSymbol(p.getSymbol());
        }

    }

    public void showBoard() {
        System.out.print("  ");
        for (int k = 0; k <= 7; k++) {
            System.out.print(k);
            System.out.print(' ');
        }
        System.out.println();
        for (int i = 7; i >= 0; i--) {
            System.out.print(i);
            System.out.print(' ');
            for (int j = 0; j <= 7; j++) {
                System.out.print(board[i][j].getSymbol());
                System.out.print(' ');
            }
            System.out.print(i);
            System.out.println();
        }
        System.out.print("  ");
        for (int k = 0; k <= 7; k++) {
            System.out.print(k);
            System.out.print(' ');
        }
        System.out.println();
        System.out.println();
    }

    void makeMove(int startLine, int startColumn, int finishLine, int finishColumn) throws DomainException {
        if (board[startLine][startColumn].getIsOccupied()) {
            if (board[finishLine][finishColumn].getIsOccupied()) {
                for (int i = 0; i < currentPieces.size(); i++)
                    if (currentPieces.get(i).getLine() == finishLine
                            && currentPieces.get(i).getColumn() == finishColumn) {
                        if(currentPieces.get(i).getIsWhite())
                            whitePlayer.deletePiece(currentPieces.get(i));
                        else
                            blackPlayer.deletePiece(currentPieces.get(i));
                        board[finishLine][finishColumn]=new Square(finishLine, finishColumn, false, '#');
                        break;
                    }
                for (Piece p : currentPieces)
                    if (p.getLine() == startLine && p.getColumn() == startColumn) {
                        board[startLine][startColumn]=new Square(startLine, startColumn, false, '#');
                        p.capture(finishLine, finishColumn);
                        board[p.getLine()][p.getColumn()]=p.getSquare();
                    }
            } else {
                for (Piece p : currentPieces)
                    if (p.getLine() == startLine && p.getColumn() == startColumn) {
                        p.move(finishLine, finishColumn);
                        board[startLine][startColumn]=new Square(startLine, startColumn, false, '#');
                        board[p.getLine()][p.getColumn()]=p.getSquare();
                        break;
                    }
            }
        } else System.out.println("no piece on this square");
    }
}