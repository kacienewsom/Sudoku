import java.awt.Color;

import javax.swing.JLabel;

public class SudokuCell extends JLabel{

    private Color color;
    private int val;
    private boolean readOnly;
    public SudokuCell(int val){
        this.val = val;
        this.color = Color.WHITE;
        this.readOnly = (this.val != 0);
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
    public void setReadOnly(boolean readOnly){
        this.readOnly = readOnly;
    }
    public boolean getReadOnly(){
        return readOnly;
    }
}
