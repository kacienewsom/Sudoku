import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

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
    private boolean cellClicked;
    private int[][] sGrid = new int[numCells][numCells];
    private Scanner s;
    private int cellX, cellY;
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
        addMouseListener(this);
    }
    public void paintComponent(Graphics g){
        int x = 15, y = 45;
        int height = getHeight();
        int width = getWidth();
        int cellSizeY = height / 9;
        int cellSizeX = width / 9;
        Font f = new Font("Arial",Font.BOLD,50);
        g.setFont(f);
        if (cellClicked){
            g.setColor(Color.YELLOW);
            g.fillRect(cellX,cellY,50,50);
            g.setColor(Color.BLACK);
        }
        for (int i = 0; i < sGrid.length; i++){
            for (int j = 0; j < sGrid[i].length; j++){
                if (sGrid[i][j] != 0){
                    g.drawString(sGrid[i][j] + "",x,y);
                }
                x += cellSizeX;
            }
            y += cellSizeY;
            x = 15;
        }
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
        cellClicked = true;
        int row = me.getY() / 50;
        int col = me.getX() / 50;
        cellX = col * 50;
        cellY = row * 50;
        repaint();
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
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
