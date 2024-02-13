import javax.swing.JFrame;
public class Sudoku extends JFrame {

    public Sudoku(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sudoku");
        //this.setVisible(true);
    }

    public static void main(String[] args){
        Sudoku s = new Sudoku();
        SudokuPanel sp = new SudokuPanel(450);
        s.setContentPane(sp);
        s.setVisible(true);
        s.pack();
    }


}
