package TicTacToe.BasicComponents;

public class Board {
    private Figure[3][3]board;
    private boolean firstPlayersTurn;
    private boolean gameOver;
    private Player playerOne;
    private Player playerTwo;

    public Board() {
        this.board = new Figure[][];
        this.firstPlayersTurn = true;
        this.gameOver = false;
        this.playerOne = new Player(CROSS);
        this.playerTwo = new Player(DOT);
    }

    public void round(int firstPlayerMoveWidth, int firstPlayerMoveLength, int secondPlayerMoveWidth, int secondPlayerMoveLength) {
        if (gameOver) {
            return;
        }
        this.firstPlayersTurn = true;
        Figure firstPlayerTarget = this.board[firstPlayerMoveWidth, firstPlayerMoveLength];
        Figure secondPlayerTarget = this.board[secondPlayerMoveWidth, secondPlayerMoveLength];
        if (firstPlayerTarget == null) {
            this.board[firstPlayerMoveWidth, firstPlayerMoveLength] = CROSS;
        }
        if (secondPlayerTarget == null) {
            this.board[secondPlayerMoveWidth, secondPlayerMoveLength] = DOT;
        }
        for (Figure[] line : this.board) {
            int crossAmount = 0;
            int dotAmount = 0;
            for(Figure figure : line) {
                if (figure == CROSS) {
                    crossAmount++;
                } else if(figure == DOT) {
                    dotAmout++;
                }
            }
            if (dotAmount == 3 || crossAmount == 3) {
                this.gameOver = true;
            }
        }
    }
}
