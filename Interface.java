import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interface extends JFrame implements ActionListener{
    private Container pane;
    private JPanel panel;
    private GridLayout grid=new GridLayout(10,10,1,1);

    public void actionPerformed(ActionEvent e){

    }

    public Interface(){
	this.setTitle("MineSweeper");
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//BorderPane pane= new BorderPane();
	pane=this.getContentPane();
	pane.setLayout(grid);
	pane.setBackground(Color.BLUE);
	for (int i=0; i<100; i++){
	    JButton button0= new JButton();
	    button0.setForeground(Color.WHITE);
	    pane.add(button0);
	}
    }

    public static void main(String[] args) {
        Interface g = new Interface();
        g.setVisible(true);
    }
}
