package src;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;


/**
 * Display for the sudoku board
 */
public class SudokuDisplay extends JFrame implements ActionListener {
    private static final long serialVersionUID = -4543169644495325055L;
    public SudokuState sudokuState;
    private JLabel[][] labels = new JLabel[9][9];
    private Boolean timer;

    public SudokuDisplay(SudokuState ss) {
        sudokuState = ss;
        setUp();
    }

    public void setUp(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                labels[i][j] = new JLabel();
            }
        }

        JCheckBox checkbox = new JCheckBox("Show Steps");

        JButton startButton = new JButton("Start Solving");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                startButton.setEnabled(false);
                checkbox.setEnabled(false);
                if(checkbox.isSelected()){
                    timer = true;
                }else{
                    timer = false;
                }
                startSolve(sudokuState.getSquares());
            }
        });    
        JPanel bcpanel = new JPanel();
        bcpanel.setLayout(new BoxLayout(bcpanel, BoxLayout.Y_AXIS));   
        bcpanel.add(startButton);
        bcpanel.add(checkbox);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel layout = new JPanel(new GridBagLayout());

        JPanel labelsPanel = new JPanel(new GridLayout(10,1,10,5));    

        for(int x=0; x<9; x++){
            JPanel j = new JPanel();
            for(int y=0; y<9; y++){
                j.add(labels[x][y]);
            }
            labelsPanel.add(j);
        }
        layout.add(labelsPanel);
        layout.add(bcpanel);
        // layout.add(startButton);
        // layout.add(checkbox);

        panel.add(layout, BorderLayout.CENTER);

        JFrame frame = new JFrame("Sudoku Solver");
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        updateValues();
    }

    public void updateValues() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                labels[i][j].setText(String.valueOf(sudokuState.getSquareVal(i, j)));
                labels[i][j].paintImmediately(labels[i][j].getVisibleRect());
            }
        }
    }

    public Boolean startSolve(Square[][] squares) {   
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(squares[i][j].getValue()==0){
                    ArrayList<Integer> vals = sudokuState.findPossibleVals(squares[i][j]);
                    for(int k=0; k<vals.size(); k++){
                        squares[i][j].setValue(squares[i][j].getPossibleVals().get(k));
                        updateValues();

                        if(timer==true){
                            try{
                                Thread.sleep(500);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        

                        if(startSolve(squares)){
                            return true;
                        }else{
                            squares[i][j].setValue(0);
                            updateValues();
                        }
                    }
                    return false;
                }
            }
        }  

        updateValues();
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}

