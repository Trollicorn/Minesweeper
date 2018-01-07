//package layoutsample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interface extends JFrame implements ActionListener{
    private Container pane;

    public void actionPerformed(ActionEvent e){

    }

    public Interface(){
	this.setTitle("MineSweeper");
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//BorderPane pane= new BorderPane();
	pane=this.getContentPane();
	pane.setLayout(new FlowLayout());
	for (int i=0; i<100; i++){
	    pane.add(new JButton());
	}
    }

    public static void main(String[] args) {
        Interface g = new Interface();
        g.setVisible(true);
    }
}
