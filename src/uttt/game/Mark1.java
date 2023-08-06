package uttt.game;

import javax.swing.text.Position;

import uttt.utils.Symbol;

public class Mark1 implements MarkInterface {
    private Symbol symbol;
    private int j;

    public Mark1(int j, Symbol symbol) {
        this.symbol = symbol;
        this.j = j;
        if (symbol == null || j > 8 || j < 0) {
            throw new IllegalArgumentException("Unimplemented method 'setSymbol'");
        }

    }

    @Override
    public Symbol getSymbol() {

        return this.symbol;

    }

    @Override
    public int getPosition() {

        return this.j;

    }

    @Override
    public void setSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("Unimplemented method 'setSymbol'");
        } else {
            this.symbol = symbol;
        }
    }

}
