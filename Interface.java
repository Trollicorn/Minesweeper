import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Interface extends JFrame implements ActionListener{
    private Container pane;
    private GridLayout grid=new GridLayout(11,11,1,1);
    private char[][] board = new char[10][10];
    private JButton newgame;
    //private GridBagConstraints cButton=new GridBagConstraints();

    public void actionPerformed(ActionEvent e){
	String s=e.getActionCommand();
	if (s.equals("New Game")){
	    this.dispose();
	    System.out.println(s);
	    Interface f= new Interface();
	    f.setVisible(true);
	}
    }

    public Interface(){
	reset();
	newgame= new JButton ("New Game");
	newgame.addActionListener(this);
	newgame.setBounds(11,11,10,1);
	pane.add(newgame);
    }

    public void reset(){
	this.setTitle("MineSweeper");
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	//cButton.gridwidth=4;
	//cButton.weightx=0.0;
	//cButton.gridx=0;
	//cButton.gridy=1;
		

	//BorderPane pane= new BorderPane();
	pane=this.getContentPane();
	pane.setLayout(grid);
	pane.setBackground(Color.BLUE);
	makeBoard();
	for (int i=0; i < board.length * board[0].length; i++){
	    MineButton button = new MineButton(board, i / 10, i % 10);
	    button.setForeground(Color.WHITE);
	    button.addMouseListener(new MineListener(button));
	    button.setText("-");
	    pane.add(button);
	}

    }

    public void makeBoard(){
	int minesWanted = 15;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		if ((int)(Math.random() * 1000) % minesWanted == 0){
		    board[i][j] = 'm';
		}else{
		    board[i][j] = '-';
		}
	    }
	}
    }

    public static void main(String[] args) {
	Interface g = new Interface();
	g.setVisible(true);
    }
}
