package TicTacToe.BasicComponents;
public class Figure {
    private boolean draw;
    public Type type;
    public Figure (Type type) {
        this.draw = true;
        this.type = type;
    }

    public boolean getDraw() {
        return this.draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
