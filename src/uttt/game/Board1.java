package uttt.game;

import uttt.UTTTFactory;
import uttt.utils.Symbol;

public class Board1 implements BoardInterface {
  private Symbol symbol;
  private int markIndex;
  private int j;
  private MarkInterface[] markArray = new MarkInterface[9];
  private MarkInterface[] marks = new MarkInterface[9];

  public Board1() {
    this.symbol = Symbol.EMPTY;
    this.j = 0;
    this.markIndex = 0;
    this.markArray = new MarkInterface[9];
    this.marks = new MarkInterface[9];
    for (int i = 0; i < 9; i++) {
      markArray[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
      marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
    }

  }

  @Override
  public MarkInterface[] getMarks() {

    return marks;
  }

  @Override
  public void setMarks(MarkInterface[] marks) throws IllegalArgumentException {
    if (marks == null) {
      throw new IllegalArgumentException("Not valid");
    }
    this.marks = marks;
  }

  @Override
  public boolean setMarkAt(Symbol symbol, int markIndex) throws IllegalArgumentException {

    if (symbol == null) {
      throw new IllegalArgumentException("Invalid");
    }
    if (markIndex > 9 || markIndex < 0) {
      throw new IllegalArgumentException("Invalid");

    }
    if (marks[markIndex].getSymbol() == Symbol.EMPTY) {
      marks[markIndex].setSymbol(symbol);
      return true;
    }
    if (marks[markIndex].getSymbol() == Symbol.CROSS) {

      return false;
    }
    if (marks[markIndex].getSymbol() == Symbol.CIRCLE) {

      return false;
    } else {
      return false;
    }
  }

  @Override
  public boolean isClosed() {
    int y = this.markIndex;
    MarkInterface[] marks = getMarks();

    if ((marks[0].getSymbol() == marks[3].getSymbol())
        && (marks[3].getSymbol() == marks[6].getSymbol()) && marks[0].getSymbol() != Symbol.EMPTY) {
      return true;

    }
    if (marks[0].getSymbol() == marks[1].getSymbol()
        && marks[1].getSymbol() == marks[2].getSymbol() && marks[0].getSymbol() != Symbol.EMPTY) {
      return true;

    }
    if (marks[0].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[8].getSymbol() && marks[0].getSymbol() != Symbol.EMPTY) {
      return true;
    }
    if (marks[2].getSymbol() == marks[5].getSymbol()
        && marks[5].getSymbol() == marks[8].getSymbol() && marks[2].getSymbol() != Symbol.EMPTY) {
      return true;

    }
    if (marks[6].getSymbol() == marks[7].getSymbol()
        && marks[7].getSymbol() == marks[8].getSymbol() && marks[6].getSymbol() != Symbol.EMPTY) {
      return true;
    }
    if (marks[1].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[7].getSymbol() && marks[1].getSymbol() != Symbol.EMPTY) {
      return true;

    }
    if (marks[2].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[6].getSymbol() && marks[2].getSymbol() != Symbol.EMPTY) {
      return true;
    }
    if (marks[3].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[5].getSymbol() && marks[3].getSymbol() != Symbol.EMPTY) {
      return true;
    } else {
      for (int i = 0; i < 9; i++) {

        if (marks[i].getSymbol() == Symbol.EMPTY)

          return false;
      }
    }
    return true;
  }

  @Override
  public boolean isMovePossible(int markIndex) throws IllegalArgumentException {
    int y = markIndex;

    marks = getMarks();
    if (0 > y || y > 9) {
      throw new IllegalArgumentException("Invalid");
    } else if (0 <= y && y < 9) {
      Symbol shiv = marks[markIndex].getSymbol();
      if (shiv == Symbol.EMPTY) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Symbol getWinner() {

    int y = this.markIndex;
    MarkInterface[] marks = getMarks();

    if ((marks[0].getSymbol() == marks[3].getSymbol())
        && (marks[3].getSymbol() == marks[6].getSymbol()) && marks[0].getSymbol() != Symbol.EMPTY) {
      return marks[0].getSymbol();

    }
    if (marks[0].getSymbol() == marks[1].getSymbol()
        && marks[1].getSymbol() == marks[2].getSymbol() && marks[0].getSymbol() != Symbol.EMPTY) {
      return marks[0].getSymbol();

    }
    if (marks[0].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[8].getSymbol() && marks[0].getSymbol() != Symbol.EMPTY) {
      return marks[0].getSymbol();
    }
    if (marks[2].getSymbol() == marks[5].getSymbol()
        && marks[5].getSymbol() == marks[8].getSymbol() && marks[2].getSymbol() != Symbol.EMPTY) {
      return marks[2].getSymbol();

    }
    if (marks[6].getSymbol() == marks[7].getSymbol()
        && marks[7].getSymbol() == marks[8].getSymbol() && marks[6].getSymbol() != Symbol.EMPTY) {
      return marks[6].getSymbol();
    }
    if (marks[1].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[7].getSymbol() && marks[1].getSymbol() != Symbol.EMPTY) {
      return marks[1].getSymbol();

    }
    if (marks[2].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[6].getSymbol() && marks[2].getSymbol() != Symbol.EMPTY) {
      return marks[2].getSymbol();
    }
    if (marks[3].getSymbol() == marks[4].getSymbol()
        && marks[4].getSymbol() == marks[5].getSymbol() && marks[3].getSymbol() != Symbol.EMPTY) {
      return marks[3].getSymbol();
    }
    return Symbol.EMPTY;
  }
}
