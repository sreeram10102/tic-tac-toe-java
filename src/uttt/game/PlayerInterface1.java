package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class PlayerInterface1 implements PlayerInterface {
    private Symbol symbol;
    private Move boarders;

    public PlayerInterface1(Symbol symbol) {
        this.symbol = symbol;

    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move getPlayerMove(SimulatorInterface game, UserInterface ui) throws IllegalArgumentException {
        if (ui == null || game == null) {
            throw new IllegalArgumentException("null");
        }
        symbol = game.getCurrentPlayerSymbol();
        return ui.getUserMove();

    }

}
