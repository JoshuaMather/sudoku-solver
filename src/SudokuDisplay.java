package src;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.BasicStroke;
import java.awt.Stroke;
 
/**
 * Display for the sudoku board
 */
public class SudokuDisplay extends JFrame implements MouseListener {
    // constants for sizes of various parts of the application
    public static final int grid_size = 11;
    public static final int box_size = 3;

    public static final int square_size = 60;
    public static final int width = square_size * grid_size;
    public static final int height = square_size * grid_size;

    int xBoardstart;
    int yBoardstart;

    public static final int xBOARDpos = 40; // Position of board
    public static final int yBOARDpos = 40; // Position of board
    public static final int xMARGIN= 50;   // Position of board
    public static final int yMARGIN= 10;   // Position of board

    private final Color backgroundColour = Color.white;
    public SudokuState sudokuState;

    private Boolean clicked = false;

    /**
     * constructor for the display
     */
    public SudokuDisplay() {
        xBoardstart= xMARGIN;
        yBoardstart= 2*yMARGIN;

        setSize(width, height);
        setLocation(xBOARDpos, yBOARDpos);
        getContentPane().setBackground(backgroundColour);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        // Draw the grid
        int x, y;
        x= xBoardstart;
        y= yBoardstart;

        Graphics2D g2d = (Graphics2D) g;
        for(int i= 0; i < 10;i++){ 
            if((i)%3==0){
                g2d.setStroke(new BasicStroke(4f));
            }else{
                g2d.setStroke(new BasicStroke(2f));
            }
            g2d.drawLine(x,yBoardstart,x,yBoardstart+9*square_size-1);          
            x+= square_size;
            g2d.drawLine(xBoardstart,y,xBoardstart+9*square_size-1,y);
            y+= square_size;
        }
        g2d.drawString("Click to start solving", 50, 600);

        // put initial values on board
        drawValues(g, x, y);
    }

    public void drawValues(Graphics g, int x, int y){
        for(int i= 0; i < 9;i++)
            for(int j= 0; j < 9; j++){
                x = xBoardstart+ i*square_size+ square_size/2;
                y = yBoardstart+ j*square_size+ square_size/2;
                if(sudokuState.getSquareVal(j, i)!=0){
                    g.drawString(String.valueOf(sudokuState.getSquareVal(j, i)), x-5, y+5);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}

