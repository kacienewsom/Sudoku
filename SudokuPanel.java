import javax.swing.JPanel;
import java.awt.Dimension;
public class SudokuPanel extends JPanel{
    private int dimension = 450;
    public SudokuPanel(int size){
        Dimension d = new Dimension(size, size);
        setPreferredSize(d);
    }
}
