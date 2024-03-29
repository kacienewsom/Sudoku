import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel implements MouseListener, KeyListener{
    private int dimPixels;
    private final int numCells = 9;
    private boolean cellClicked;
    private SudokuCell[][] sGrid = new SudokuCell[numCells][numCells];
    private SudokuCell[][] solutionGrid;
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
        initSolutionGrid(24);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int x = 15, y = 45;
        int height = getHeight();
        int width = getWidth();
        int cellSizeY = height / 9;
        int cellSizeX = width / 9;
        Font f = new Font("Arial",Font.BOLD,50);
        g2.setFont(f);
        if (cellClicked){
            g2.setColor(Color.YELLOW);
            g2.fillRect(cellX,cellY,50,50);
            g2.setColor(Color.BLACK);
        }
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(0,150,450,150);
        g2.drawLine(0,300,450,300);
        g2.drawLine(150,0,150,450);
        g2.drawLine(300,0,300,450);
        for (int i = 0; i < sGrid.length; i++){
            for (int j = 0; j < sGrid[i].length; j++){
                SudokuCell sc = sGrid[i][j];
                int val = sc.getVal();
                if (val != 0){
                    g2.drawString(val + "",x,y);
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

        int row = me.getY() / 50;
        int col = me.getX() / 50;
        cellX = col * 50;
        cellY = row * 50;
        SudokuCell sc = sGrid[row][col];
        sGrid[row][col].setEnabled(true);
        boolean readOnly = sc.getReadOnly();
        cellClicked = !readOnly;
        repaint();
    }
    public void keyTyped(KeyEvent e){
        char keyChar = e.getKeyChar();
        int row = cellY / 50;
        int col = cellX / 50;
        boolean isReadOnly = sGrid[row][col].getReadOnly();
        if (keyChar >= '1' && keyChar <= '9' && !isReadOnly){
            int val = keyChar - '0';
            sGrid[row][col].setVal(val);
            repaint();
        }
        if (keyChar == KeyEvent.VK_BACK_SPACE && !isReadOnly){
            sGrid[row][col].setVal(0);
            repaint();
        }
                
    }
    public void keyReleased(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){}

    public void initSolutionGrid(int num){
        String fileName = "Solutions/Grid" + num;
        String str = new String();
        File f = new File(fileName);
        try {
            s = new Scanner(f);
            int row = 0;
            solutionGrid = new SudokuCell[9][9];
            if (s != null){
                while (s.hasNextLine()){
                    str = s.nextLine();
                    for (int col = 0; col < str.length(); col++){
                        int val = (int) str.charAt(col) - '0';
                        solutionGrid[row][col] = new SudokuCell(val);
                    }
                    row++;
                }
            }
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File not found");
        }
        finally {
            s.close();
        }
    }
    public void initGrid(int num){
        String fileName = "StartingGrids/Grid" + num;
        String str = new String();
        String rowDigits = new String();
        String[] digitArray;
        File file = new File(fileName);
        int row = 0, col = 0;
        for (int i = 0; i < sGrid.length; i++){
            for (int j = 0; j < sGrid[i].length; j++){
                sGrid[i][j] = new SudokuCell(0);
            }
        }
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
                        sGrid[row][col] = new SudokuCell(val);
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
                SudokuCell sc = sGrid[i][j];
                int val = sc.getVal();
                if (val > 0 && val < 10){
                    System.out.print(val);
                }
                else if (val == 0){
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
