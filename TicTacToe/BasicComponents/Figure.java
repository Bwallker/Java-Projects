package TicTacToe.BasicComponents;
public class Figure {
    private boolean draw;
    public Symbol symbol;
    public Figure (Symbol symbol) {
        this.draw = true;
        this.symbol = symbol;
    }

    public boolean getDraw() {
        return this.draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
