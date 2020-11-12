package src;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * Display for the sudoku board
 */
public class SudokuDisplay extends JPanel {
    // constants for sizes of various parts of the application
    public static final int grid_size = 9;
    public static final int box_size = 3;

    public static final int square_size = 80;
    public static final int width = square_size * grid_size;
    public static final int height = square_size * grid_size;

    private final Color backgroundColour= Color.white;

    /** 
     * constructor for display reading state from text file
     */
    public SudokuDisplay(){

    }
}

