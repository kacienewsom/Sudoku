import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class SudokuPanel extends JPanel{
    private int dimension = 450;
    public SudokuPanel(int size){
        Dimension d = new Dimension(size, size);
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
    }
}
