package src;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * main driver class for the application
 */
public class Sudoku {

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String file = "";
        while(file == ""){
            System.out.println("Enter Sudoku file to solve: ");
            String s = in.nextLine();
            try{
                file = s;
                file = "boards/" + file;
                SudokuState ss = new SudokuState(file);
                //ss.printSquares();
            }catch(Exception e){
                System.out.println("Enter a valid file");
                file = ""; // lets the while loop run again
                System.out.println("");
            }
        }
        
    }
}
