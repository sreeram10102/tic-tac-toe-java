package uttt.game;

import uttt.UTTTFactory;
import uttt.utils.Move;
import uttt.utils.Symbol;

public class Simulator1 implements SimulatorInterface {
    private int markIndex1 = 0;
    private int boardIndex1;
    private Symbol symbol;
    private int fake2;
    private BoardInterface[] marker = new BoardInterface[9];
    private PlayerInterface playerOne;
    private PlayerInterface playerTwo;
    private int nextIndex;

    public Simulator1() {
        this.markIndex1 = 0;
        this.boardIndex1 = -1;
        this.symbol = Symbol.CROSS;

        this.nextIndex = -1;
        this.marker = new BoardInterface[9];
        for (int i = 0; i < 9; i++) {
            marker[i] = new Board1();
        }
    }

    @Override
    public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui)
            throws IllegalArgumentException {
        if (playerOne == null || playerTwo == null || ui == null) {
            throw new IllegalArgumentException("INvalid");
        }

        setCurrentPlayerSymbol(playerOne.getSymbol());

        while (!isGameOver()) {
            PlayerInterface playNow;
            if (getCurrentPlayerSymbol() == Symbol.CROSS)
                playNow = playerOne;
            else {
                playNow = playerTwo;
            }
            Move getter = playNow.getPlayerMove(this, ui);
            ui.updateScreen(this);
            int brd = getter.getBoardIndex();
            int mrk = getter.getMarkIndex();

            if (isMovePossible(brd, mrk)) {
                setMarkAt(playNow.getSymbol(), brd, mrk);
                ui.updateScreen(this);

            } else {
                continue;
            }

            if (getCurrentPlayerSymbol() == playerOne.getSymbol()) {
                setCurrentPlayerSymbol(playerTwo.getSymbol());
            } else {
                setCurrentPlayerSymbol(playerOne.getSymbol());
            }

            // else {
            // System.out.println("INvalid move");
            // }
        }

        if (getWinner() == Symbol.CROSS) {
            ui.showGameOverScreen(Symbol.CROSS);
        } else if (getWinner() == Symbol.CIRCLE) {
            ui.showGameOverScreen(Symbol.CIRCLE);
        } else {
            ui.showGameOverScreen(Symbol.EMPTY);
        }

    }

    @Override
    public BoardInterface[] getBoards() {

        return marker;

    }

    @Override
    public void setBoards(BoardInterface[] boards) throws IllegalArgumentException {
        if (boards == null) {
            throw new IllegalArgumentException("Invalid");
        }

        this.marker = boards;

    }

    @Override
    public Symbol getCurrentPlayerSymbol() {

        return symbol;
    }

    @Override
    public void setCurrentPlayerSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.symbol = symbol;

    }

    @Override
    public boolean setMarkAt(Symbol symbol, int boardIndex, int markIndex) throws IllegalArgumentException {
        // int i=0;
        MarkInterface[] marks = marker[boardIndex].getMarks();
        boardIndex1 = boardIndex;
        if (symbol == null || boardIndex > 8 || boardIndex < 0 || markIndex > 8 || markIndex < 0) {
            throw new IllegalArgumentException("Inavalid correctness");
        }

        if ((marks[markIndex].getSymbol() == Symbol.EMPTY) && (isMovePossible(boardIndex))
                && (!(marker[boardIndex].isClosed())) && (symbol != Symbol.EMPTY)) {
            // System.out.println("Galthi");
            setIndexNextBoard(markIndex);

            nextIndex = getIndexNextBoard();
            markIndex1 = markIndex;
            marker[boardIndex1].setMarkAt(symbol, markIndex1);
            if (marker[markIndex].isClosed()) {
                setIndexNextBoard(-1);

            }
            return true;
        }
        if ((marks[markIndex].getSymbol() == Symbol.CROSS) || (marks[markIndex].getSymbol() == Symbol.CIRCLE)
                || marker[boardIndex].isClosed()) {
            return false;
        }

        return false;

    }

    @Override
    public int getIndexNextBoard() {
        return nextIndex;

    }

    @Override
    public void setIndexNextBoard(int index) throws IllegalArgumentException {
        if (index > 8 || index < -1) {
            throw new IllegalArgumentException("Invalid");
        }
        nextIndex = index;
    }

    @Override
    public boolean isGameOver() {

        if (marker[0].getWinner() == marker[1].getWinner() && marker[1].getWinner() == marker[2].getWinner()
                && marker[0].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[3].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[4].getWinner()
                && marker[3].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[6].getWinner() == marker[7].getWinner() && marker[7].getWinner() == marker[8].getWinner()
                && marker[6].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[0].getWinner() == marker[3].getWinner() && marker[3].getWinner() == marker[6].getWinner()
                && marker[0].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[1].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[7].getWinner()
                && marker[1].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[2].getWinner() == marker[5].getWinner() && marker[5].getWinner() == marker[8].getWinner()
                && marker[2].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[0].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[8].getWinner()
                && marker[0].getWinner() != Symbol.EMPTY)
            return true;
        if (marker[2].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[6].getWinner()
                && marker[2].getWinner() != Symbol.EMPTY)
            return true;
        else {
            for (int i = 0; i < 9; i++) {
                if (marker[i].getWinner() == Symbol.EMPTY)

                    return false;
            }
        }
        return true;

    }

    @Override
    public boolean isMovePossible(int boardIndex) throws IllegalArgumentException {
        if (boardIndex > 8 || boardIndex < 0) {
            throw new IllegalArgumentException("Invalid");
        }

        MarkInterface[] marks = marker[boardIndex].getMarks();
        if (isGameOver()) {
            return false;
        } else if (!marker[boardIndex].isClosed()) {
            for (int i = 0; i < 9; i++) {
                // System.out.println("chdithu");
                if (marks[i].getSymbol() == Symbol.EMPTY) {
                    // System.out.println("ivide");
                    return true;
                }

            }
        }
        return false;
    }

    @Override
    public boolean isMovePossible(int boardIndex, int markIndex) throws IllegalArgumentException {
        if (boardIndex > 8 || boardIndex < 0 || markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("Invalid");
        }

        if (isGameOver()) {
            return false;

        } else if (!marker[boardIndex].isClosed()) {

            MarkInterface[] marks = marker[boardIndex].getMarks();
            if ((marks[markIndex].getSymbol() == Symbol.EMPTY) && isMovePossible(boardIndex)) {
                // System.out.println("njan");
                if (getIndexNextBoard() != -1 && getIndexNextBoard() != boardIndex) {
                    return false;
                }
                return true;

            }
        }

        return false;
    }

    @Override
    public Symbol getWinner() {
        if (marker[0].getWinner() == marker[1].getWinner() && marker[1].getWinner() == marker[2].getWinner()
                && marker[0].getWinner() != Symbol.EMPTY)
            return marker[0].getWinner();
        if (marker[0].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[8].getWinner()
                && marker[0].getWinner() != Symbol.EMPTY)
            return marker[0].getWinner();
        if (marker[1].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[7].getWinner()
                && marker[1].getWinner() != Symbol.EMPTY)
            return marker[1].getWinner();
        if (marker[2].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[6].getWinner()
                && marker[2].getWinner() != Symbol.EMPTY)
            return marker[2].getWinner();
        if (marker[6].getWinner() == marker[7].getWinner() && marker[7].getWinner() == marker[8].getWinner()
                && marker[6].getWinner() != Symbol.EMPTY)
            return marker[6].getWinner();
        if (marker[3].getWinner() == marker[4].getWinner() && marker[4].getWinner() == marker[5].getWinner()
                && marker[3].getWinner() != Symbol.EMPTY)
            return marker[3].getWinner();
        if (marker[0].getWinner() == marker[3].getWinner() && marker[3].getWinner() == marker[6].getWinner()
                && marker[0].getWinner() != Symbol.EMPTY)
            return marker[0].getWinner();
        if (marker[2].getWinner() == marker[5].getWinner() && marker[5].getWinner() == marker[8].getWinner()
                && marker[2].getWinner() != Symbol.EMPTY)
            return marker[2].getWinner();
        return Symbol.EMPTY;
    }

}