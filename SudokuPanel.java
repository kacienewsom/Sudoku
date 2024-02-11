import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel implements MouseListener{
    private int dimPixels;
    private final int numCells = 9;
    private int[][] sGrid = new int[numCells][numCells];
    private Scanner s;
    public SudokuPanel(int size){
        dimPixels = size;
        Dimension d = new Dimension(dimPixels, dimPixels);
        setPreferredSize(d);
        GridLayout gl = new GridLayout(9,9);
        setLayout(gl);
        JLabel myLabel = new JLabel();
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        myLabel.setBorder(blackline);
        for (int i = 0; i < 81; i++) {
            myLabel = new JLabel();
            blackline = BorderFactory.createLineBorder(Color.BLACK);
            myLabel.setBorder(blackline);
            this.add(myLabel);
        }
        initGrid(24);        
        printGrid();
    }
    public void mouseExited(MouseEvent me){

    }
    public void mouseEntered(MouseEvent me){

    }
    public void mouseReleased(MouseEvent me){

    }

    public void mousePressed(MouseEvent me){

    }
    
    public void mouseClicked(MouseEvent me){

    }
    public void initGrid(int num){
        String fileName = "StartingGrids/Grid" + num;
        String str = new String();
        String rowDigits = new String();
        String[] digitArray;
        File file = new File(fileName);
        int row = 0, col = 0;
        try {
            s = new Scanner(file); 
            if (s != null){
                while (s.hasNextLine()){
                    str = s.nextLine();
                    row = str.charAt(0) - '0';
                    rowDigits = str.substring(3);
                    digitArray = rowDigits.split(",");
                    int val = 0;
                    for (int i = 0; i < digitArray.length; i++){
                        col = digitArray[i].charAt(0) - '0';
                        val = digitArray[i].charAt(2) - '0';
                        sGrid[row][col] = val;
                    }
                }
            }
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File Not Found");
        }
        finally {
            s.close();
        }
    }
    public void printGrid(){
        for (int i = 0; i < sGrid.length; i++){
            for (int j = 0; j < sGrid[i].length; j++){
                if (sGrid[i][j] > 0 && sGrid[i][j] < 10){
                    System.out.print(sGrid[i][j]);
                }
                else if (sGrid[i][j] == 0){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
