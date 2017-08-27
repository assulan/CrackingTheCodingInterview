package chapter8;

/**
 * Created by asus on 8/27/17.
 * Othello game design.
 */

enum Direction{
    left, right, up, down
}

enum Color {
    White, Black
}

class Game{
    private Player[] players;
    private static Game instance;
    private Board board;
    private final int ROWS = 10;
    private final int COLUMNS = 10;

    public Game() {
        board = new Board(ROWS, COLUMNS);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
    }

    public static Game getInstance(){
        if (instance == null) instance = new Game();
        return instance;
    }

    public Board getBoard(){ return board; }
}
class Board{
    private int blackCount = 0;
    private int whiteCount = 0;
    private OthelloPiece[][] board;

    public Board(int rows, int cols) {
        board = new OthelloPiece[rows][cols];
    }

    public void init(){}
    public boolean placeColor(int row, int col, Color color) { return  false;}
    private int flipSection(int row, int col, Color color, Direction direction){return 0;}
    public int getScoreForColor(Color c){
        if (c == Color.Black) return blackCount;
        return whiteCount;
    }
    public void updateScore(Color newColor, int newPieces){}

}

class OthelloPiece {
    private Color color;

    public OthelloPiece(Color color) {
        this.color = color;
    }

    public void flip(){
        if (color == Color.Black) color = Color.White;
        else color = Color.Black;
    }

    public Color getColor() {
        return color;
    }
}

class Player{
    private Color color;
    public Player(Color c){
        color = c;
    }

    public int getScore(){return 0;}
    public boolean playPiece(int row, int col){
        return Game.getInstance().getBoard().placeColor(row, col, color);
    }

    public Color getColor() {
        return color;
    }
}

public class Challenge8_8 {
}
