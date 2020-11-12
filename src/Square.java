package src;

/**
 * class for each of the squares on the sudoku board
 */
public class Square {
    private int value; // 0 for empty
    private int row; // 0 to 8, top to bottom
    private int col; // 0 to 8 left to right
    private int box; // 0 to 8, left to right, top to bottom

    public Square(int v, int r, int c, int b){
        value = v;
        row = r;
        col = c;
        box = b;
    }

    public int getValue(){
        return value;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getBox(){
        return box;
    }
}
