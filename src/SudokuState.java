package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * class for the state of the sudoku board
 */
public class SudokuState {
    private Square[][] squares = new Square[9][9];

    public SudokuState(String file) throws FileNotFoundException {
        try(
            BufferedReader breader = new BufferedReader(
                new FileReader(file)
            )
        ){
            String line = breader.readLine();

            int count = 0;
            int box = 0;

            while(line!=null){
                for(int j=0; j<line.length();j++){
                    char val = line.charAt(j);

                    // find which box a particular character belongs to
                    if(count<=2 && j<=2){
                        box = 0;
                    }else if(count<=2 && j>=3 && j<=5){
                        box = 1;
                    }else if(count<=2 && j>=6 && j<=8){
                        box = 2;
                    }else if(count>=3 && count<=5 && j<=2){
                        box = 3;
                    }else if(count>=3 && count<=5 && j>=3 && j<=5){
                        box = 4;
                    }else if(count>=3 && count<=5 && j>=6 && j<=8){
                        box = 5;
                    }else if(count>=6 && count<=8 && j<=2){
                        box = 6;
                    }else if(count>=6 && count<=8 && j>=3 && j<=5){
                        box = 7;
                    }else if(count>=6 && count<=8 && j>=6 && j<=8){
                        box = 8;
                    }
                    squares[count][j] = new Square(Integer.parseInt(String.valueOf(val)), count, j, box);
                }
                count += 1;
                line = breader.readLine();
            }
            
        }catch (FileNotFoundException e) {
            System.out.println("Error: Could not open " + file);
            throw new FileNotFoundException();
       } catch (IOException e) {
            System.out.println("Error: IOException when reading "+ file);
       } 
    }

    public Square[][] getSquares(){
        return squares;
    }

    public int getSquareVal(int x, int y){
        return squares[x][y].getValue();
    }

    // method for testing file read correctly
    public void printSquares(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(squares[i][j].getValue());
            }
            System.out.println("");
        }
    }
}