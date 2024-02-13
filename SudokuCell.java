import java.awt.Color;

import javax.swing.JLabel;

public class SudokuCell extends JLabel{

    private Color color;
    private int val;
    public SudokuCell(int val){
        this.val = val;
        this.color = Color.WHITE;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public void setVal(int val){
        this.val = val;
    }
    public int getVal(){
        return val;
    }
}
