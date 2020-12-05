package src;

import java.util.ArrayList;

/**
 * class for each of the squares on the sudoku board
 */
public class Square {
    private int value; // 0 for empty
    private int row; // 0 to 8, top to bottom
    private int col; // 0 to 8 left to right
    private int box; // 0 to 8, left to right, top to bottom
    private Boolean set; // true if set initially, false otherwise
    private ArrayList<Integer> possibleVals = new ArrayList<Integer>();

    public Square(int v, int r, int c, int b){
        value = v;
        row = r;
        col = c;
        box = b;
        if(value!=0){
            set = true;
        }else{
            set = false;
        }
    }

    public void setValue(int v){
        value = v;
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

    public Boolean isSet(){
        return set;
    }

    public ArrayList<Integer> getPossibleVals(){
        return possibleVals;
    }

    public void addPossibleVal(int value){
        possibleVals.add(value);
    }

    public void clearPossibleVals(){
        possibleVals = new ArrayList<Integer>();
    }
}
